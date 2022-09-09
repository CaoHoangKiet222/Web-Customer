package com.web.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

/** SecurityConfig */
// ->
// https://spring.io/blog/2022/02/21/spring-security-without-the-websecurityconfigureradapter
// https://stackoverflow.com/questions/25869260/how-can-i-add-users-to-the-inmemoryauthentication-builder-after-it-has-been-buil
@Configuration
@EnableWebSecurity
public class SecurityConfig {
  @Autowired UserDetailsService userDetailsService;

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    // https://www.baeldung.com/spring-security-expressions
    http.authorizeRequests()
        // filter from top to down
        .antMatchers("/customer/list")
        .hasAnyRole("USER", "ADMIN", "CREATOR", "EDITOR")
        .antMatchers("/customer/newCustomerForm")
        .hasAnyRole("CREATOR", "ADMIN")
        .antMatchers("/customer/updateCustomer")
        .hasAnyRole("EDITOR", "ADMIN")
        .antMatchers("/customer/deleteCustomer")
        .hasRole("ADMIN")
        .antMatchers("/admin/**")
        .hasRole("ADMIN")
        .and()
        .formLogin()
        .permitAll()
        .and()
        .exceptionHandling()
        .accessDeniedPage("/access-denied/403");
    return http.build();
  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    // https://www.codejava.net/frameworks/spring-boot/spring-security-without-password-encoding
    return new BCryptPasswordEncoder();
  }

  @Bean
  public WebSecurityCustomizer webSecurityCustomizer() {
    return (web) -> web.ignoring().antMatchers("/resources/**");
  }
}
