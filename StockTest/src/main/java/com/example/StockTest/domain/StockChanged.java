package com.example.StockTest.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor //cannot deserialize from Object value
@AllArgsConstructor
public class StockChanged {
  private Long productId;
  private int changeNum;
}
