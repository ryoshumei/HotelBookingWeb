package com.example.hotelbookingweb.controllers.admin;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;



// A Basic Authentication
@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class WebSecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.formLogin(login -> login
                .loginProcessingUrl("/admin/logIn")
                .loginPage("/admin/logIn")
                .defaultSuccessUrl("/admin/checkGuests")
                .failureUrl("/")
                .permitAll()

        ).logout(logout -> logout
                .logoutUrl("/admin/logout")
                .logoutSuccessUrl("/admin/logIn")


        ).authorizeHttpRequests(authz -> authz
                .requestMatchers("/")
                .permitAll()
                .requestMatchers("/roomsInformation")
                .permitAll()
                .requestMatchers("/roomsInformation/confirmBooking")
                .permitAll()
                .requestMatchers("/admin")
                .hasRole("ADMIN")
                .anyRequest().authenticated()
        );


        return http.build();
    }


}
