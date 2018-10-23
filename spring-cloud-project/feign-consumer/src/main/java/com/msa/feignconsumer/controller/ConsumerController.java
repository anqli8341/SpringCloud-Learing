package com.msa.feignconsumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.msa.feignconsumer.entity.User;
import com.msa.feignconsumer.service.HelloService;
import com.msa.feignconsumer.service.RefactorHelloService;
//import com.msa.helloserviceapi.dto.User;

/**
 * @author anquan li
 */
@RestController
public class ConsumerController {
  @Autowired
  HelloService helloService;
  @Autowired
  RefactorHelloService refactorHelloService;

  @RequestMapping(value = "/feign-consumer",method = RequestMethod.GET)
  public String helloConsumer(){
    return helloService.hello();
  }
  @RequestMapping(value="/feign-consumer2",method = RequestMethod.GET)
  public String helloConsumer2(){
    StringBuilder sb=new StringBuilder();
    sb.append(helloService.hello()).append("\n");
    sb.append(helloService.hello("eric")).append("\n");
    sb.append(helloService.hello("eric",30)).append("\n");
    sb.append(helloService.hello(new User("eric",30))).append("\n");
    return sb.toString();
  }
//  @RequestMapping(value="/feign-consumer3",method = RequestMethod.GET)
//  public String helloConsumer3() {
//    StringBuilder sb = new StringBuilder();
//    sb.append(refactorHelloService.hello("eric")).append("\n");
//    sb.append(refactorHelloService.hello("eric", 30)).append("\n");
//    sb.append(refactorHelloService.hello(new User("eric", 30))).append("\n");
//    return  sb.toString();
//  }
}
