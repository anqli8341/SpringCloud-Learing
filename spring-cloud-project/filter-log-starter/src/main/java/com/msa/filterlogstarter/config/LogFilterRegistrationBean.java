package com.msa.filterlogstarter.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;

import com.msa.filterlogstarter.filter.LogFilter;

/**
 * @author anquan li
 */

public class LogFilterRegistrationBean extends FilterRegistrationBean<LogFilter> {

  public LogFilterRegistrationBean() {
    super();
    this.setFilter(new LogFilter());
    this.addUrlPatterns("/*");
    this.setName("LogFilter");
    this.setOrder(1);
  }
}
