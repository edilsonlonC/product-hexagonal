package com.opencoders.products.infrastructure.config.athentication;

import com.opencoders.products.infrastructure.database.ports.out.UserJPARepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class JwtConfig {
    @Autowired
    private UserJPARepository userJPARepository;
    @Bean
    UserDetailsService userDetailsService () {
        return username -> userJPARepository.findByEmail(username).orElseThrow(() -> new UsernameNotFoundException("user not found"));
    }
    @Bean
    AuthenticationManager authenticationManager (AuthenticationConfiguration config ) throws Exception {
        return config.getAuthenticationManager();
    }
    @Bean
    AuthenticationProvider authenticationProvider () {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }
    @Bean
    PasswordEncoder passwordEncoder () {
        return new BCryptPasswordEncoder();
    }
}

