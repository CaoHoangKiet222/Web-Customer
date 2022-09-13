package com.web.api;

import com.web.model.Customer;

/** CustomerResponse */
public class CustomerResponse extends ApiResponse {
  private Customer customer;

  public CustomerResponse() {}

  public CustomerResponse(String message, int status, long timestamp) {
    this(message, status, timestamp, null);
  }

  public CustomerResponse(String message, int status, long timestamp, Customer customer) {
    super(message, status, timestamp);
    this.customer = customer;
  }

  public void setCustomer(Customer customer) {
    this.customer = customer;
  }

  public Customer getCustomer() {
    return this.customer;
  }
}
