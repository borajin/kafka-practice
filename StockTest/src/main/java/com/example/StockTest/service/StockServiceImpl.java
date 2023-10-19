package com.example.StockTest.service;

import com.example.StockTest.domain.StockRepository;
import com.example.StockTest.domain.Stock;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
@Transactional
public class StockServiceImpl implements StockService{

  private final StockRepository stockRepository;

  @Override
  public void updateStock(Long productId, int changeNum) {
    Stock stock = stockRepository.findByProductId(productId);
    stock.order(changeNum);
  }
}
