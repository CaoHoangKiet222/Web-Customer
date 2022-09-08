package com.web.dao;

import com.web.model.User;

/** UserDao */
public interface UserDao {
  public User findUserByName(String name);
}
