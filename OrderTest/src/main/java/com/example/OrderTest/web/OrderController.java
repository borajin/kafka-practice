package com.example.OrderTest.web;

import com.example.OrderTest.domain.Order;
import com.example.OrderTest.service.OrderProducer;
import com.example.OrderTest.domain.OrderRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.util.concurrent.ExecutionException;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OrderController {

  private final OrderRepository orderRepository;
  private final OrderProducer orderProducer;

  @Transactional
  @PostMapping(path = "/orders")
  public String createOrder(@RequestParam Long productId, @RequestParam String productName,
      @RequestParam int orderNum)
      throws ExecutionException, JsonProcessingException, InterruptedException {

    Order order = orderRepository.save(new Order(
        null,
        productId,
        productName,
        orderNum
    ));

    try {

      orderProducer.updateStock(order.getProductId(), order.getOrderNum());
    } catch (Exception e) {
      return e.getMessage();
    }


    return order.getProductName() + " : " + order.getOrderNum();
  }
}
