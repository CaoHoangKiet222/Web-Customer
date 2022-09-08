package com.web.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

/** SecurityConfig */
// ->
// https://spring.io/blog/2022/02/21/spring-security-without-the-websecurityconfigureradapter
@Configuration
@EnableWebSecurity
public class SecurityConfig {
  @Autowired UserDetailsService userDetailsService;

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http.authorizeRequests()
        .antMatchers("/**")
        .hasRole("USER")
        .antMatchers("/admin/**")
        .hasRole("ADMIN")
        .and()
        .formLogin();
    return http.build();
  }

  // In-Memory Authentication
  // @Bean
  // public InMemoryUserDetailsManager userDetailsService() {
  // return new
  // InMemoryUserDetailsManager(userDetailsService.loadUserByUsername("kiet"));
  // }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return NoOpPasswordEncoder.getInstance();
  }

  // @Bean
  // public DataSource dataSource() {
  // return new
  // EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2).addScript()
  // }

  // @Bean
  // public WebSecurityCustomizer webSecurityCustomizer() {
  // return (web) -> web.ignoring().antMatchers("/ignore1", "/ignore2");
  // }
}
