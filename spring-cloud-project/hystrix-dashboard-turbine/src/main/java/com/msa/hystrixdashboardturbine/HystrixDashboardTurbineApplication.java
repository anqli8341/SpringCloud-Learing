package com.msa.hystrixdashboardturbine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

/**
 * @author anquan li
 */

@SpringBootApplication
@EnableTurbine
@EnableDiscoveryClient
public class HystrixDashboardTurbineApplication {

  public static void main(String[] args) {
    SpringApplication.run(HystrixDashboardTurbineApplication.class, args);
  }
}
