package com.example.StockTest.web;

import com.example.StockTest.domain.Stock;
import com.example.StockTest.domain.StockRepository;
import java.util.List;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class StockController {

  private final StockRepository stockRepository;

  @PostMapping(path = "/stocks")
  public Stock createStocks(@RequestParam Long productId, @RequestParam String productName,
      @RequestParam int stock) {
    return stockRepository.save(new Stock(null, productId, productName, stock));
  }

  @GetMapping(path = "/stocks")
  public List<Stock> getStocks() {
    return stockRepository.findAll();
  }
}
