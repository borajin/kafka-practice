package com.example.OrderTest.service;

import com.example.OrderTest.domain.event.StockChange;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderProducerImpl implements OrderProducer{
  private final KafkaTemplate<String, String> kafkaTemplate;
  private final ObjectMapper objectMapper = new ObjectMapper();

  @Value(value = "${kafka.topic.stock}")
  private String TOPIC_STOCK;

  @Override
  public void updateStock(Long productId, int changeNum) throws JsonProcessingException {
    StockChange stockChange = new StockChange(productId, changeNum);
    String message = objectMapper.writeValueAsString(stockChange);
    this.kafkaTemplate.send(new ProducerRecord<>(TOPIC_STOCK, message));
  }
}
