package com.web.controller;

import com.web.service.MyUserDetail;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/** LogginController */
@Controller
@RequestMapping("/")
public class LogginController {
  @GetMapping("/")
  public String getAll(@AuthenticationPrincipal MyUserDetail myUserDetail, Model model) {
    if (myUserDetail != null) {
      boolean isAdmin =
          myUserDetail.getAuthorities().stream()
              .anyMatch(role -> role.getAuthority().equals("ROLE_ADMIN"));
      if (isAdmin) {
        return "redirect:admin/home";
      }
      return "redirect:customer/list";
    }
    // if use "redirect:login" -> don't use these
    // .antMatchers("/**")
    // .authenticated()
    return "redirect:login";
  }

  @GetMapping("/access-denied/403")
  public String accessDenied() {
    return "403";
  }
}
