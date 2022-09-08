package com.web.service;

import com.web.dao.UserDao;
import com.web.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/** MyUserDetailService */
@Service
public class MyUserDetailService implements UserDetailsService {
  @Autowired
  @Qualifier("userRepository")
  private UserDao userDao;

  @Override
  public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
    User user = userDao.findUserByName(userName);
    if (user == null) {
      throw new UsernameNotFoundException("Not found" + userName);
    }
    return new MyUserDetail(user);
  }
}
