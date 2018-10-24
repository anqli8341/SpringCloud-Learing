package com.msa.rabbitmqhello.config;



import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.amqp.core.Queue;


/**
 * @author anquan li
 */
@Configuration
public class RabbitConfig {
  @Bean
  public Queue helloQueue(){
    return new Queue("hello");
  }
}
