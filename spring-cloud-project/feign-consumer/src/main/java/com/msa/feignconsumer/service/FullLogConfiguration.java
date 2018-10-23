package com.msa.feignconsumer.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.Logger;

/**
 * @author anquan li
 */
@Configuration
public class FullLogConfiguration {
  @Bean
  public Logger.Level feignLoggerLevel() {
    return feign.Logger.Level.FULL;
  }
}
