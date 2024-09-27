package com.kjs.web.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {

    @GetMapping("/")
    public String index() {
        System.out.println("MainController - index 실행");
        return "hello.html";
    }

}
