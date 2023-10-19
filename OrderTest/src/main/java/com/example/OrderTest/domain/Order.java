package com.example.OrderTest.domain;

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
@Table(name = "t_order")
public class Order {
  @Id
  @GeneratedValue
  private Long id;

  @Column
  private Long productId;

  @Column(length = 20)
  private String productName;

  @Column
  private int orderNum;
}
