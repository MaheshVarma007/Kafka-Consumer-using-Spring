package com.kafkaproducer.example.demo.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Service
public class ConsumerController {

    @KafkaListener(topics = "KafkaTest2",containerGroup = "group_id",containerFactory = "kafkaListenerContainerFactory")
    public void consume(String msg){
        System.out.println("Consumed Messages is :"+msg);
    }

    @KafkaListener(topics="kafkaTest2",containerGroup = "group_json", containerFactory = "userKafkaListenerFactory")
    public void consumeJson(User user){
        System.out.println("Consumed JSON message: "+user);
    }

}
