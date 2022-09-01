package com.web.controller;

import com.web.dao.CustomerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/** CustomerController */
@Controller
@RequestMapping(path = "/customer")
public class CustomerController {
  @Autowired
  @Qualifier("customerRepository")
  private CustomerDao customerDao;

  @GetMapping("/list")
  public String showCustomers(Model model) {
    model.addAttribute("customers", customerDao.getCustomers());
    return "list-customer";
  }
}
