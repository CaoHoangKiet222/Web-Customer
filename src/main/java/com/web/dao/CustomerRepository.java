package com.web.dao;

import com.web.model.Customer;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/** CustomerRepository */
// -> sub class of @Component, use for DAO implementation (auto-scan)
// -> provides translation of any JDBC related exceptions means any checked exceptions, Spring will
// translate to unchecked exceptions
@Repository
public class CustomerRepository implements CustomerDao {
  @Autowired
  // -> find @Bean(name = "sessionFactory") in HibernateConfig
  private SessionFactory sessionFactory;

  @Override
  @Transactional
  public List<Customer> getCustomers() {
    final Session session = sessionFactory.getCurrentSession();
    Query<Customer> query = session.createQuery("from Customer", Customer.class);
    List<Customer> customers = query.getResultList();
    return customers;
  }
}
