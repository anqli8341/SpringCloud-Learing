package com.msa.apigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import com.msa.apigateway.filter.AccessFilter;
import com.msa.apigateway.filter.DidiErrorAttributes;
import com.msa.apigateway.filter.DidiFilterProcessor;
import com.netflix.zuul.FilterProcessor;


/**
 * @author anquan li
 */
@SpringBootApplication
@EnableZuulProxy
public class ApiGatewayApplication {

  public static void main(String[] args) {
   // FilterProcessor.setProcessor(new DidiFilterProcessor());
    SpringApplication.run(ApiGatewayApplication.class, args);
  }
  @Bean
  public AccessFilter accessFilter(){
    return new AccessFilter();
  }
  @Bean
  public DidiErrorAttributes didiErrorAttributes(){
    return new DidiErrorAttributes();
  }
}
