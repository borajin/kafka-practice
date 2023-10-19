package com.example.StockTest.domain;

import com.example.StockTest.domain.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockRepository extends JpaRepository<Stock, Long> {
  Stock findByProductId(Long productId);
}
