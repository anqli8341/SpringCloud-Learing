package com.msa.userservice.controller;

import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Logger;

import org.apache.commons.lang.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.msa.userservice.entity.User;


/**
 * @author anquan li
 */
@RestController
public class UserController {
  private final Logger logger = Logger.getLogger(this.getClass().getName());
  ConcurrentHashMap<Long, User> concurrentHashMap = new ConcurrentHashMap<>();

  /**
   * 保存用户
   *
   * @return
   */
  @RequestMapping(value = "/save", method = RequestMethod.POST)
  public User save() {
    User user = new User();
    user.setId(new Long("1111"));
    user.setUserName("eric");
    concurrentHashMap.put(user.getId(), user);
    return user;
  }

  @RequestMapping(value = "/users", method = RequestMethod.GET)
  public User getUserById(@RequestParam(value = "id", required = false, defaultValue = "0") String id) {
    logger.info(this.getClass().getName() + "id=[" + id + "]");
    if (StringUtils.isEmpty(id)) {
      return null;
    }
    User user = concurrentHashMap.get(Long.parseLong(id));
    logger.info(" id :=" + user.getId() + ",userName :=" + user.getUserName());
    return user;
  }


}
