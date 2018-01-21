package org.sweet.itech.sweetitechecommerce.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.GlobalAuthenticationConfigurerAdapter;
import org.sweet.itech.sweetitechecommerce.services.CustomUserDetailsService;

@Configuration
public class WebServerConfig extends GlobalAuthenticationConfigurerAdapter {

    @Autowired
    CustomUserDetailsService userDetailsService;

    @Override
    public void init(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }


}
