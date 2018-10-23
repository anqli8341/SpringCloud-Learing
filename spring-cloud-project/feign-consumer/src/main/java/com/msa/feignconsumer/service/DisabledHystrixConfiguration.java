package com.msa.feignconsumer.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import feign.Feign;

/**
 * @author anquan li
 */
@Configuration
public class DisabledHystrixConfiguration {

  @Bean
  @Scope("prototype")
  public Feign.Builder feignBuilder(){
    return Feign.builder();
  }
}
