package com.web.dao;

import com.web.model.Customer;
import java.util.List;

/** CustomerDao */
public interface CustomerDao {
  public List<Customer> getCustomers();

  public void saveCustomer(Customer customer);

  public Customer getCustomer(int id) throws Exception;

  public void deleteCustomer(int id) throws Exception;
}
