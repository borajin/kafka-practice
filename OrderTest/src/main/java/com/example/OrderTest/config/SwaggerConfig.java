package com.example.OrderTest.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition(
    info = @Info(title = "카프카 테스트 - order"))
@RequiredArgsConstructor
@Configuration
public class SwaggerConfig {

  @Bean
  public GroupedOpenApi chatOpenApi() {
    String[] paths = {"/**"};

    return GroupedOpenApi.builder()
        .group("카프카 테스트 - order")
        .pathsToMatch(paths)
        .build();
  }
}