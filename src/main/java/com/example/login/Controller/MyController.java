package com.example.login.Controller;

import com.example.login.Service.LoginService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MyController {
    LoginService ls = new LoginService();

    @GetMapping("/")
    public String login() {
        return "/index";
    }

    @GetMapping("/site")
    public String login(@RequestParam String username, @RequestParam String password) {

        if (ls.tryLogin(username, password) != null) {
            return "/site";
        } else {
            return errorSite();
        }
    }

    @GetMapping("/newUser")
    public String createUser() {
        return "/newUser";
    }

    @GetMapping("/createUser")
    public String addUser(@RequestParam String username, @RequestParam String password) {
        ls.addUser(username, password);
        return "/createUser";
    }

    @GetMapping("/404")
    public String errorSite() {
        return "/404";
    }


}
