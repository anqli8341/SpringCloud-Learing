package com.msa.openfeignproducer.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import com.msa.commonapi.dto.Instance;



/**
 * @author anquan li
 */
@RestController
@RequestMapping("/feign-service")
public class FeignServiceController  {
  private static final Logger logger = LoggerFactory.getLogger(FeignServiceController.class);

  private static String DEFAULT_SERVICE_ID = "application";
  private static String DEFAULT_HOST = "localhost";
  private static int DEFAULT_PORT = 8080;

  @RequestMapping(value="/instance/{serviceId}",method = RequestMethod.GET)
  public Instance getInstanceByServiceId(@PathVariable("serviceId") String serviceId) {
    logger.info("Get Instance By serviceId {}", serviceId);
    return new Instance(serviceId, DEFAULT_HOST, DEFAULT_PORT);
  }

  @RequestMapping(value = "/instance/{serviceId}", method = RequestMethod.DELETE)
  public String deleteInstanceByServiceId(@PathVariable("serviceId") String serviceId) {
    logger.info(" delete Instance By serviceId {} ", serviceId);
    return "Instance whose serviceId is " + serviceId + " is deleted";
  }

  @RequestMapping(value = "/instance", method = RequestMethod.POST)
  public String createInstance(@RequestBody Instance instance) {

    logger.info("Create Instance whose serviceId is {}", instance.getServiceId());
    return "Instance whose serviceId is" + instance.getServiceId() + " is created";
  }

  @RequestMapping(value = "/instance/{serviceId}", method = RequestMethod.PUT)
  public String updateInstanceByServiceId(@PathVariable("serviceId") String serviceId) {
    logger.info("Update Instance whose serviceId is {}", serviceId);
    return "Instance whose serviceId is " + serviceId + " is updated";
  }

}
