package com.web.api;

import com.web.dao.CustomerDao;
import com.web.model.Customer;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/** CustomerRestController */
@RestController
@RequestMapping("/api")
public class CustomerRestController {
  @Autowired private CustomerDao customerDao;

  @GetMapping("/customers")
  private ResponseEntity<List<Customer>> getCustomers() {
    final List<Customer> customers = customerDao.getCustomers();
    return ResponseEntity.ok(customers);
  }

  // ======================
  // https://stackoverflow.com/questions/30502962/testing-spring-security-with-postman
  // -> if test, choose the last one in stackoverflow
  // ======================
  @GetMapping("/customers/{id}")
  private ResponseEntity<CustomerResponse> getCustomer(@PathVariable(required = true) final int id)
      throws RuntimeException {
    final Customer customer = customerDao.getCustomer(id);
    return new ResponseEntity<>(
        new CustomerResponse(
            "Customer with id = " + id + " found!!!",
            HttpStatus.OK.value(),
            System.currentTimeMillis(),
            customer),
        HttpStatus.OK);
  }

  @RequestMapping(
      value = {"/customers/new-customer", "/customers/update-customer"},
      method = {RequestMethod.POST, RequestMethod.PUT})
  private ResponseEntity<CustomerResponse> saveOrUpdateCustomer(@RequestBody Customer customer) {
    String messageSuf;
    if (customer.getId() != 0) {
      messageSuf = " has been updated!!!";
    } else {
      messageSuf = " has been added!!!";
    }
    customerDao.saveCustomer(customer);
    String messagePre = "Customer with id = " + customer.getId();
    return ResponseEntity.ok(
        new CustomerResponse(
            messagePre + messageSuf, HttpStatus.OK.value(), System.currentTimeMillis(), customer));
  }

  @DeleteMapping("/customers/{id}")
  private ResponseEntity<CustomerResponse> deleteCustomer(
      @PathVariable(required = true) final int id) throws RuntimeException {
    final Customer customer = customerDao.deleteCustomer(id);
    return ResponseEntity.ok(
        new CustomerResponse(
            "Customer with id = " + id + " has been deleted!!!",
            HttpStatus.OK.value(),
            System.currentTimeMillis(),
            customer));
  }
}
