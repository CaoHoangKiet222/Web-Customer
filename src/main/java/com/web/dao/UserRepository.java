package com.web.dao;

import com.web.model.User;
import javax.transaction.Transactional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/** UserRepository */
@Repository
public class UserRepository implements UserDao {
  @Autowired private SessionFactory sessionFactory;

  @Override
  @Transactional
  public User findUserByName(String name) {
    Session session = sessionFactory.getCurrentSession();
    Query<User> query = session.createQuery("from User where name = '" + name + "'", User.class);
    return (User) query.uniqueResult();
  }
}
