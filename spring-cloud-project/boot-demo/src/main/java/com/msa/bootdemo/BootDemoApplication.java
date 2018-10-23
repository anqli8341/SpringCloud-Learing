package com.msa.bootdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.msa.filterlogstarter.annotation.EnableLogFilter;

/**
 * @author anquan li
 */

@SpringBootApplication
@RestController
@EnableLogFilter
public class BootDemoApplication {

  public static void main(String[] args) {
    SpringApplication.run(BootDemoApplication.class, args);
  }

  @GetMapping("/test")
  public String test() {
    return "this is a demo boot";
  }
}
