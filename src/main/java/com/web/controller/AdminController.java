package com.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/")
public class AdminController {
    @GetMapping("/admin")
    public String showAdminForm() {
        return "<h1>Hello Admin</h1>";
    }
}
