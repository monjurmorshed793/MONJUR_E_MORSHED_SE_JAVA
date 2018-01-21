package org.sweet.itech.sweetitechecommerce.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.sweet.itech.sweetitechecommerce.models.user.User;
import org.sweet.itech.sweetitechecommerce.services.RegistrationService;

@RestController
public class RegistrationController {
	
	@Autowired
	private RegistrationService registrationService;
	
	@PostMapping("/register")
  ResponseEntity<?> registerUser(@RequestBody User user){
		return registrationService.registerUser(user);
	}

}
