package com.msa.eurekaclientconsumer.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author anquan li
 */
@RestController
public class AskController {
  @Autowired
  RestTemplate restTemplate;
  @Value("${spring.application.name}")
  private String name;

  @RequestMapping(value = "/ask")
  public String ask() {
    String askHelloFromService = restTemplate.getForEntity("http://EUREKA-CLIENT-SERVICE/hello/{name}", String.class, name).getBody();
    return askHelloFromService;

  }

}
