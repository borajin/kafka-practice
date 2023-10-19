package com.example.StockTest.service;

import com.example.StockTest.domain.StockChanged;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StockConsumer {
  private static final String TOPIC_STOCK = "stock";  //어노테이션 값은 상수여야 함

  private final StockService stockService;
  private final ObjectMapper objectMapper = new ObjectMapper();

  @KafkaListener(topics = TOPIC_STOCK)
  public void updateStock(String message) throws JsonProcessingException {
    StockChanged stockChanged = objectMapper.readValue(message, StockChanged.class);
    stockService.updateStock(stockChanged.getProductId(), stockChanged.getChangeNum());
  }
}
