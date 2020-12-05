package com.haha.pt.test.kafka;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;

public class Kafka {

    public static void main(String[] args) {
            Properties properties = new Properties();
            properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,"node1:9092,node2:9092,node3:9092");
            properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
            properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
            KafkaProducer<String, String> kafkaProducer = new KafkaProducer<String, String>
                            (properties);
            for (int i = 0; i < 200; i++) {
            ProducerRecord<String, String> record = new ProducerRecord<String, String>
                                ("baizhi",i+"","Hello Kafka:"+i);
            kafkaProducer.send(record);
            }
            kafkaProducer.flush();
            kafkaProducer.close();
    }

}
