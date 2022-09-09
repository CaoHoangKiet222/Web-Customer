package com.web.controller;

import com.web.dao.CustomerDao;
import com.web.model.Customer;
import com.web.service.MyUserDetail;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/** CustomerController */
@Controller
@RequestMapping(path = "/customer")
public class CustomerController {
  @Autowired
  @Qualifier("customerRepository")
  private CustomerDao customerDao;

  @GetMapping("/")
  public String homeCustomer() {
    return "redirect:/list";
  }

  @GetMapping("/list")
  public String showCustomers(@AuthenticationPrincipal MyUserDetail myUserDetail, Model model) {
    model.addAttribute("userName", myUserDetail.getUsername());
    model.addAttribute("customers", customerDao.getCustomers());
    return "list-customer";
  }

  @GetMapping("/newCustomerForm")
  public String newCustomerForm(Model model) {
    model.addAttribute("newCustomer", new Customer());
    return "new-customer";
  }

  @PostMapping("/saveCustomer")
  public String addNewCustomer(
      @Valid @ModelAttribute("newCustomer") Customer newCustomer,
      BindingResult bindingResult,
      Model model) {
    System.out.println(bindingResult);
    if (bindingResult.hasErrors()) {
      return "new-customer";
    }
    customerDao.saveCustomer(newCustomer);
    return "redirect:list"; // redirect to /customer/list
  }

  @GetMapping("/updateCustomer")
  public String updateCustomer(@RequestParam("customerId") String id, Model model)
      throws NumberFormatException, Exception {
    model.addAttribute("customer", customerDao.getCustomer(Integer.parseInt(id)));
    return "update-customer";
  }

  @GetMapping("/deleteCustomer")
  public String deleteCustomer(@RequestParam("customerId") String id, Model model)
      throws NumberFormatException, Exception {
    customerDao.deleteCustomer(Integer.parseInt(id));
    return "redirect:list";
  }
}
