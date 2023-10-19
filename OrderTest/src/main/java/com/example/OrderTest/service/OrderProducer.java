package com.example.OrderTest.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import java.util.concurrent.ExecutionException;

// 메시지 발송을 위한 프로듀서
public interface OrderProducer {
  // 재고 차감
  void updateStock(Long productId, int changeNum) throws JsonProcessingException, InterruptedException, ExecutionException;

}
