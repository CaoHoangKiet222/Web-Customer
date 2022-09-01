package com.web.dao;

import com.web.model.Customer;
import java.util.List;

/** CustomerDao */
public interface CustomerDao {
  public List<Customer> getCustomers();
}
