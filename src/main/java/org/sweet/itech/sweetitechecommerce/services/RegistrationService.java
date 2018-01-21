package org.sweet.itech.sweetitechecommerce.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.sweet.itech.sweetitechecommerce.enums.RoleType;
import org.sweet.itech.sweetitechecommerce.models.role.Role;
import org.sweet.itech.sweetitechecommerce.models.role.RoleRepository;
import org.sweet.itech.sweetitechecommerce.models.user.User;
import org.sweet.itech.sweetitechecommerce.models.user.UserRepository;
import org.sweet.itech.sweetitechecommerce.models.userroles.UserRole;
import org.sweet.itech.sweetitechecommerce.models.userroles.UserRoleRepository;

@Component
public class RegistrationService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	
	@Autowired
	private UserRoleRepository userRoleRepository;
	
	public ResponseEntity<?> registerUser(final User user){
		userRepository.save(user);
		Role role = roleRepository.findOne( Long.valueOf(RoleType.USER.getValue()) );
		UserRole userRole = new UserRole();
		userRole.setRole(role);
		userRole.setUser(user);
		userRoleRepository.save(userRole);
		return ResponseEntity.ok("created");
	}

}
