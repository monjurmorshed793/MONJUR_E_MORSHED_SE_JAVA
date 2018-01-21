package org.sweet.itech.sweetitechecommerce.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.sweet.itech.sweetitechecommerce.models.user.User;
import org.sweet.itech.sweetitechecommerce.models.user.UserRepository;
import org.sweet.itech.sweetitechecommerce.models.userroles.UserRole;
import org.sweet.itech.sweetitechecommerce.models.userroles.UserRoleRepository;

@Component
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserRoleRepository userRoleRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(userName);
        UserRole userRole = userRoleRepository.findByUserId(user.getId());
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(),
                AuthorityUtils.createAuthorityList(userRole.getRole().getName()));
    }

}
