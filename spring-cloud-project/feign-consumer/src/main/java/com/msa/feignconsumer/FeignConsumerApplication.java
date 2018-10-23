package com.msa.feignconsumer;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import feign.Logger;


/**
 * @author anquan li
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients

public class FeignConsumerApplication {

  public static void main(String[] args) {
    SpringApplication.run(FeignConsumerApplication.class, args);
  }
//  @Bean
//  public Logger.Level feignLoggerLevel() {
//    return feign.Logger.Level.FULL;
//  }
}
