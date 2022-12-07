package com.tobias.salerservice.outer.adaptor;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tobias.salerservice.outer.dto.SalerDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class KafkaProducer {
    private final KafkaTemplate<String, String> kafkaTemplate;

    public SalerDto send(String kafkaTopic, SalerDto salerDto) {
        ObjectMapper mapper = new ObjectMapper();
        String jsonInString = "";
        try {
            jsonInString = mapper.writeValueAsString(salerDto);
        } catch (Exception e) {
            e.printStackTrace();
        }
        kafkaTemplate.send(kafkaTopic, jsonInString);
        log.info("Kafka Producer send data from the salerservice: " + salerDto);

        return salerDto;
    }

    // TODO: service interface를 통해 생성 (리팩터링할 것)
}
