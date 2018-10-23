package com.msa.eurekaclient.controller;

import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.msa.helloserviceapi.dto.User;
import com.msa.helloserviceapi.service.HelloService;

/**
 * @author anquan li
 */
@RestController
public class RefactorHelloController implements HelloService {
  private final Logger logger = LoggerFactory.getLogger(getClass().getName());

  @Override
  public String hello(@RequestParam("name") String name) {
    return "Hello " + name;
  }

  @Override
  public User hello(@RequestHeader("name") String name, @RequestHeader("age") Integer age) {
    return new User(name, age);
  }

  @Override
  public String hello(@RequestBody User user) {
    try {
      int sleepTime = new Random().nextInt(3000);
      logger.info("sleepTime:" + sleepTime);
      Thread.sleep(sleepTime);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return "Hello " + user.getName() + ", " + user.getAge();
  }
}
