package com.example.OrderTest.domain.event;

import lombok.AllArgsConstructor;
import lombok.Getter;

// 이벤트 객체
@Getter
@AllArgsConstructor
public class StockChange {
  private Long productId;
  private int changeNum;
}
