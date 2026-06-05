package com.zhangsan.edu.mock.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class RandomCollection {
   public static <T> T getOneFrom(List<T> list) {
      int randInt = RandomNum.getRandInt(0, list.size() - 1);
      return (T)list.get(randInt);
   }

   public static <T> List<T> getSomeFrom(List<T> list, Integer num) {
      HashSet idxSet = new HashSet();
      List<T> rslist = new ArrayList();

      while(idxSet.size() != num) {
         int randIdx = RandomNum.getRandInt(0, list.size() - 1);
         if (!idxSet.contains(randIdx)) {
            idxSet.add(randIdx);
            rslist.add(list.get(randIdx));
         }
      }

      return rslist;
   }

   public static <K, V> V getOneFrom(Map<K, V> hashMap) {
      Object[] values = hashMap.values().toArray();
      if (values.length >= 1) {
         int randInt = RandomNum.getRandInt(0, values.length - 1);
         return (V)values[randInt];
      } else {
         return null;
      }
   }

   public static <K, V> V getOneFrom(Map<K, V> hashMap, List<K> excludeKeyList) {
      HashMap<K, V> cloneMap = new HashMap();
      cloneMap.putAll(hashMap);

      for(K key : excludeKeyList) {
         cloneMap.remove(key);
      }

      Object[] values = cloneMap.values().toArray();
      if (values.length >= 1) {
         int randInt = RandomNum.getRandInt(0, values.length - 1);
         return (V)values[randInt];
      } else {
         return null;
      }
   }
}
