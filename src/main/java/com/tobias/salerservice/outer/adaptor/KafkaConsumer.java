package com.tobias.salerservice.outer.adaptor;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tobias.salerservice.inner.repository.SalerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@Slf4j
public class KafkaConsumer {
    SalerRepository repository;

    @Autowired
    public KafkaConsumer(SalerRepository repository){
        this.repository = repository;
    }

    @KafkaListener(topics = "sale-request-topic")
    public void processMessage(String kafkaMessage){
        log.info("Kafka Message: ====> " + kafkaMessage);

        Map<Object,Object> map = new HashMap<>();
        ObjectMapper mapper = new ObjectMapper();
        try{
            map = mapper.readValue(kafkaMessage, new TypeReference<Map<Object, Object>>() {});
            }catch(JsonProcessingException e) {
            e.printStackTrace();
        }

        //repository.save(entity);
    }
}
