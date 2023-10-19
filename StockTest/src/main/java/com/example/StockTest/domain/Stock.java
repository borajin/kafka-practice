package com.example.StockTest.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity
@Table(name = "stock")
public class Stock {
  @Id
  @GeneratedValue
  private Long id;

  @Column
  private Long productId;

  @Column(length = 20)
  private String productName;

  @Column
  private int stock;

  public void order(int changeNum) {
    this.stock -= changeNum;
  }
}
