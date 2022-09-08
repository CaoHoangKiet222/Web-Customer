package com.web.service;

import com.web.model.User;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/** MyUserDetail */
public class MyUserDetail implements UserDetails {
  private String name;
  private String password;
  private boolean active;
  private List<GrantedAuthority> authorities;

  public MyUserDetail() {}

  public MyUserDetail(User user) {
    this.name = user.getName();
    this.password = user.getPassword();
    this.active = user.getActive();
    this.authorities =
        Arrays.stream(user.getRoles().split(","))
            .map(SimpleGrantedAuthority::new)
            .collect(Collectors.toList());
  }

  public Collection<? extends GrantedAuthority> getAuthorities() {
    return this.authorities;
  }

  @Override
  public String getPassword() {
    return this.password;
  }

  @Override
  public String getUsername() {
    return this.name;
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return this.active;
  }
}
