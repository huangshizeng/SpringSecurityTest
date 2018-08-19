package com.huang.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {
    @RequestMapping(value = {"/", "/home"})
    public String home() {
        return "home";
    }

    @RequestMapping("hello")
    public String hello() {
        return "hello";
    }

    @RequestMapping("login")
    public String login() {
        return "login";
    }
}
