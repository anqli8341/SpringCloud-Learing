package com.msa.eurekaclientconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;


/**
 * @author anquan li
 */

@SpringBootApplication
@Configuration
public class EurekaClientConsumerApplication {

  public static void main(String[] args) {
    SpringApplication.run(EurekaClientConsumerApplication.class, args);
  }

  @Bean
  @LoadBalanced
  public RestTemplate restTemplate() {
    return new RestTemplate();
  }
}
