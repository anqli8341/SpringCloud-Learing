package com.msa.eurekaclient.controller;

import java.util.List;
import java.util.Random;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import com.msa.feignconsumer.entity.User;


/**
 * @author anquan li
 */
@RestController
public class HelloController {
  private final Logger logger = Logger.getLogger(this.getClass().getName());
  @Value("${spring.application.name}")
  private String serviceName;
  @Autowired
  private DiscoveryClient client;

  @RequestMapping(value = "/hello", method = RequestMethod.GET)
  public String index() {
    List<ServiceInstance> serviceInstances = client.getInstances(serviceName);
    int sleepTime = new Random().nextInt(1000);
    for (int i = 0; i < serviceInstances.size(); i++) {
      ServiceInstance serviceInstance = serviceInstances.get(i);
      logger.info("sleepTime:" + sleepTime);
      try {
        Thread.sleep(sleepTime);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      logger.info("/hello, host:" + serviceInstance.getHost() + serviceInstance.getPort() + ",service_id:" + serviceInstance.getServiceId());
    }

    return "Hello World";
  }

  @RequestMapping(value = "/hello1", method = RequestMethod.GET)
  public String hello(@RequestParam String name) {
    return "Hello " + name;
  }

  @RequestMapping(value = "/hello2", method = RequestMethod.GET)
  public User hello(@RequestHeader String name, @RequestHeader Integer age) {
    return new User(name, age);
  }

  @RequestMapping(value = "/hello3", method = RequestMethod.POST)
  public String hello(@RequestBody User user) {
    return "Hello "+ user.getName() + ", " + user.getAge();
  }

}
