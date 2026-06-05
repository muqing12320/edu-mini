package com.zhangsan.edu.mock.service.adv.impl;

import com.zhangsan.edu.mock.service.adv.AdvService;
import com.zhangsan.edu.mock.util.RandomNum;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import javax.annotation.PostConstruct;

public class AdvServiceImpl<M extends BaseMapper<T>, T> extends ServiceImpl<M, T> implements AdvService<T> {
   protected Map<Long, T> cache = null;

   public void truncateTable() {
      Class<T> tClass = this.currentModelClass();
   }

   public void removeWithCache() {
      this.remove((Wrapper)null);
      this.cache.clear();
   }

   @PostConstruct
   protected void loadCache() {
      this.cache = new ConcurrentHashMap();
      List<T> list = this.list((Wrapper)null);
      this.loadCache(list);
   }

   protected void loadCache(List<T> list) {
      for(T t : list) {
         Long id = this.getId(t);
         this.cache.put(id, t);
      }

   }

   public Map<Long, T> all(boolean useCache) {
      if (this.cache != null && this.cache.size() > 0) {
         return this.cache;
      } else {
         this.loadCache();
         return this.cache;
      }
   }

   protected Long getId(T entity) {
      Long id = null;

      try {
         Field field = entity.getClass().getDeclaredField("id");
         Method method = entity.getClass().getDeclaredMethod("getId");
         id = (Long)method.invoke(entity);
         return id;
      } catch (Exception e) {
         e.printStackTrace();
         throw new RuntimeException("can't get id from the bean");
      }
   }

   public boolean saveOrUpdate(T entity, Boolean useCache) {
      super.saveOrUpdate(entity);
      if (this.cache != null) {
         Long id = this.getId(entity);
         this.cache.put(id, entity);
      }

      return true;
   }

   public boolean saveOrUpdateBatch(List<T> list, int batchSize, Boolean useCache) {
      super.saveOrUpdateBatch(list, batchSize);
      if (useCache && this.cache != null) {
         for(T t : list) {
            Long id = this.getId(t);
            this.cache.put(id, t);
         }
      }

      return true;
   }

   public T getById(Long id, Boolean useCache) {
      T t = null;
      if (useCache && this.cache != null) {
         t = (T)this.cache.get(id);
      }

      if (t == null || !useCache) {
         t = (T)this.getById(id);
      }

      return t;
   }

   public T getOneByRandom() {
      int size = this.cache.size();
      if (size > 0) {
         int randInt = RandomNum.getRandInt(0, size - 1);
         Object[] objects = this.cache.values().toArray();
         return (T)objects[randInt];
      } else {
         return null;
      }
   }
}
