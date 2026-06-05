package com.zhangsan.edu.mock.util;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogUtil {
   private static final Logger log = LoggerFactory.getLogger(LogUtil.class);

   public static void logToJson(Object logObject) {
      log.info(JSON.toJSONString(logObject));
   }

   public static void log(String logString) {
      log.info(logString);
   }
}
