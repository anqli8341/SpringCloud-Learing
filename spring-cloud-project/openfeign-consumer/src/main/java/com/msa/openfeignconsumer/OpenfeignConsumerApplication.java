package com.msa.openfeignconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author anquan li
 */
@SpringBootApplication
@EnableFeignClients
public class OpenfeignConsumerApplication {

  public static void main(String[] args) {
    SpringApplication.run(OpenfeignConsumerApplication.class, args);
  }
}
