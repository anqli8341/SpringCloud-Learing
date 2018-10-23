package com.msa.ribbonconsumer.service;

import java.util.concurrent.Future;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.msa.userservice.entity.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.command.AsyncResult;


/**
 * @author anquan li
 */
@Service
public class HelloService {
  private final Logger logger = Logger.getLogger(this.getClass().getName());
  @Autowired
  RestTemplate restTemplate;

  public String helloService() {
    return restTemplate.getForEntity("http://HELLO-SERVICE/hello", String.class).getBody();
  }

  public String hello() {
    long start = System.currentTimeMillis();
    String result = restTemplate.getForEntity("http://HELLO-SERVICE/hello", String.class).getBody();
    long end = System.currentTimeMillis();
    logger.info("Spend time :" + (end - start));
    return result;
  }

  @HystrixCommand(fallbackMethod = "getUser")
  public User getUserById(String id) {
    return restTemplate.getForObject("http://USER-SERVICE/users?id={1}", User.class, id);
  }

  @HystrixCommand(fallbackMethod = "defaultUser")
  public Future<User> getUserByIdAsync(String id) {
    return new AsyncResult<User>() {
      @Override
      public User invoke() {
        return restTemplate.getForObject("http://USER-SERVICE/users?id={1}", User.class, id);
      }
    };
  }

  @HystrixCommand(fallbackMethod = "defaultUser")
  public User saveUser() {
    User user = new User();
    user.setId(new Long(1111));
    user.setUserName("eric");
    return restTemplate.postForObject("http://USER-SERVICE/save", user, User.class);
  }

  public User defaultUser() {
    System.out.println("操作发生错误...............");
    return new User();
  }

  public User getUser(String id) {
    System.out.println("查询操作发生错误...............[" + id + "]");
    return new User();
  }
}
