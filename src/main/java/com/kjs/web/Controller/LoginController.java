package com.kjs.web.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String login() {
        System.out.println("LoginController - GET -  login 실행");
        return "Login";
    }

    @GetMapping("/signup")
    public String register() {
        System.out.println("LoginController - GET - register 실행");
        return "Register";
    }


}
