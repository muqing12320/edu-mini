package com.zhangsan.edu.mock.service.adv;

import com.baomidou.mybatisplus.extension.service.IService;
import java.util.List;
import java.util.Map;

public interface AdvService<T> extends IService<T> {
   Map<Long, T> all(boolean useCache);

   boolean saveOrUpdate(T entity, Boolean useCache);

   boolean saveOrUpdateBatch(List<T> list, int batchSize, Boolean useCache);

   T getById(Long id, Boolean useCache);

   T getOneByRandom();

   void removeWithCache();
}
