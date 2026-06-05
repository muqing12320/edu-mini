package com.zhangsan.edu.mock.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.apache.commons.io.IOUtils;
import org.springframework.boot.system.ApplicationHome;

public class ConfigUtil {
   public static String loadJsonFile(String fileName) {
      String filePath = getJarDir() + "/" + fileName;
      File file = new File(filePath);
      InputStream resourceAsStream = null;

      try {
         Object var6;
         if (file.exists()) {
            var6 = new FileInputStream(file);
         } else {
            var6 = Thread.currentThread().getContextClassLoader().getResourceAsStream(fileName);
         }

         String json = IOUtils.toString((InputStream)var6, "utf-8");
         return json;
      } catch (IOException e) {
         e.printStackTrace();
         throw new RuntimeException("配置文件" + fileName + "读取异常");
      }
   }

   public static String getJarDir() {
      File file = getJarFile();
      return file == null ? null : file.getParent();
   }

   private static File getJarFile() {
      ApplicationHome h = new ApplicationHome(ConfigUtil.class);
      File jarF = h.getSource();
      System.out.println(jarF.getParentFile().toString());
      return jarF;
   }
}
