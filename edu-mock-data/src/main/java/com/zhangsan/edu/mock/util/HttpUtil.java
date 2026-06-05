package com.zhangsan.edu.mock.util;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import okhttp3.Call;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class HttpUtil {
   private static OkHttpClient client;

   private HttpUtil() {
   }

   public static OkHttpClient getInstance() {
      if (client == null) {
         synchronized(HttpUtil.class) {
            if (client == null) {
               client = new OkHttpClient();
            }
         }
      }

      return client;
   }

   public static void get(String json, String mockUrl) {
      String encodeJson = "";

      try {
         encodeJson = URLEncoder.encode(json, "utf-8");
      } catch (UnsupportedEncodingException e) {
         e.printStackTrace();
      }

      String url = mockUrl + "?param=" + encodeJson;
      Request request = (new Request.Builder()).url(url).get().build();
      Call call = getInstance().newCall(request);
      Response response = null;
      long start = System.currentTimeMillis();

      try {
         response = call.execute();
         long end = System.currentTimeMillis();
         System.out.println(response.body().string() + " used:" + (end - start) + " ms");
      } catch (IOException e) {
         e.printStackTrace();
         throw new RuntimeException("发送失败...检查网络地址...");
      }
   }

   public static void post(String json, String mockUrl) {
      System.out.println(json);
      RequestBody requestBody = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), json);
      Request request = (new Request.Builder()).url(mockUrl).post(requestBody).build();
      Call call = getInstance().newCall(request);
      Response response = null;
      long start = System.currentTimeMillis();

      try {
         response = call.execute();
         long end = System.currentTimeMillis();
         System.out.println(response.body().string() + " used:" + (end - start) + " ms");
      } catch (IOException e) {
         e.printStackTrace();
         throw new RuntimeException("发送失败...检查网络地址...");
      }
   }
}
