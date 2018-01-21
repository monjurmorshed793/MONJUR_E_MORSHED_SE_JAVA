package org.sweet.itech.sweetitechecommerce.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.sweet.itech.sweetitechecommerce.models.user.User;
import org.sweet.itech.sweetitechecommerce.models.user.UserRepository;

import java.security.Principal;

/**
 * Created by Munna on 25-Jun-17.
 */
@RestController
public class UserController {

  @Autowired
  private UserRepository userRepository;

  @GetMapping("/user")
  public User user(Principal user) {
    User loggedUser = userRepository.findByEmail(user.getName());
    loggedUser.setPassword("");
    return loggedUser;
  }
}
