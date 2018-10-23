package com.msa.eurekaclientconsumer.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;


/**
 * @author anquan li
 */
@RestController
public class ServiceInstanceRestController {
  @Value("${spring.application.name}")
  private String applicationName;
  @Autowired
  private RestTemplate restTemplate;

  @RequestMapping("/service-instances")
  public JSON serviceInstancesByApplicationName() {
    //String serviceInstancesFromService=restTemplate.getForEntity("http://EUREKA-CLIENT-SERVICE/service-instances/{applicationName}",String.class,applicationName).getBody();
    JSONObject serviceInstanceObject = restTemplate.getForObject("http://EUREKA-CLIENT-SERVICE/service-instances/{applicationName}", JSONObject.class, applicationName);
    return serviceInstanceObject;
  }
}
