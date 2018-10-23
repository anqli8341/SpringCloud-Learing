package com.msa.eurekaclientservice.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author anquan li
 */
@RestController
public class SayHelloController {

  @Autowired
  private DiscoveryClient discoveryClient;

  @RequestMapping(value = "/hello/{name}")
  public String sayHello(@PathVariable("name") String name) {
    return "Hello ,".concat(name).concat("!");
  }

  @RequestMapping("/service-instances/{applicationName}")
  public List<ServiceInstance> serviceInstancesByApplicationName(@PathVariable("applicationName") String applicationName) {

    return this.discoveryClient.getInstances(applicationName);
  }
}
