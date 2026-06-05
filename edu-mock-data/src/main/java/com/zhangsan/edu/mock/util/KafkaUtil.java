package com.zhangsan.edu.mock.util;

import java.util.Properties;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

public class KafkaUtil {
   public static KafkaProducer<String, String> kafkaProducer = null;

   public static KafkaProducer<String, String> createKafkaProducer(String kafkaServer) {
      Properties properties = new Properties();
      properties.put("bootstrap.servers", kafkaServer);
      properties.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
      properties.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
      KafkaProducer<String, String> producer = null;

      try {
         producer = new KafkaProducer(properties);
      } catch (Exception e) {
         e.printStackTrace();
      }

      return producer;
   }

   public static void send(String topic, String msg, String kafkaServer) {
      if (kafkaProducer == null) {
         kafkaProducer = createKafkaProducer(kafkaServer);
      }

      kafkaProducer.send(new ProducerRecord(topic, msg));
   }
}
