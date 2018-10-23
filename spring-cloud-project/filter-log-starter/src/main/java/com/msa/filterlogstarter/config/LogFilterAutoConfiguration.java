package com.msa.filterlogstarter.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.msa.filterlogstarter.filter.LogFilter;

/**
 * @author anquan li
 */
@Configuration
@ConditionalOnClass({LogFilterRegistrationBean.class, LogFilter.class})
public class LogFilterAutoConfiguration {

  @Bean
  @ConditionalOnMissingBean(LogFilterRegistrationBean.class)
  public LogFilterRegistrationBean logFilterRegistrationBean() {
    return new LogFilterRegistrationBean();
  }
}
