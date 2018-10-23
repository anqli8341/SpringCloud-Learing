package com.msa.ribbonconsumer.web;

import java.util.concurrent.Future;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.msa.ribbonconsumer.service.HelloService;
import com.msa.userservice.entity.User;


/**
 * @author anquan li
 */
@RestController
public class ConsumerController {
  private final Logger logger = Logger.getLogger(this.getClass().getName());

  @Autowired
  RestTemplate restTemplate;
  @Autowired
  LoadBalancerClient loadBalancerClient;
  @Autowired
  HelloService helloService;

  @RequestMapping(value = "/ribbon-consumer", method = RequestMethod.GET)
  public String helloConsumer() {
    ServiceInstance serviceInstance = loadBalancerClient.choose("HELLO-SERVICE");
    logger.info("host=" + serviceInstance.getHost() + ",port=" + serviceInstance.getPort() + ",serviceId=" + serviceInstance.getServiceId());
    return restTemplate.getForEntity("http://HELLO-SERVICE/hello", String.class).getBody();
  }

  @RequestMapping(value = "/helloConsumer", method = RequestMethod.GET)
  public String hello() {
    return helloService.helloService();
  }

  @RequestMapping(value = "/helloTimeout", method = RequestMethod.GET)
  public String helloConsumerTimeout() {
    return helloService.hello();
  }

  @RequestMapping(value = "/saveUser", method = RequestMethod.GET)
  public User saveUser() {
    return helloService.saveUser();
  }

  @RequestMapping(value = "/users", method = RequestMethod.GET)
  public User getUserById(String id) {

    return helloService.getUserById(id);
  }

  @RequestMapping(value = "usersAsync", method = RequestMethod.GET)
  public Future<User> getUserByIdAsync(String id) {
    return helloService.getUserByIdAsync(id);
  }
}
