package com.example.login.Controller;

import com.example.login.Model.nrGenerator;
import com.example.login.Service.cafeSystem;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MyController {
    cafeSystem system = new cafeSystem();
    nrGenerator nrGenerator = new nrGenerator();

    @GetMapping("/")
    public String login() {
        system.setConnection();
        return "/index";
    }

    @GetMapping("/site")
    public String login(@RequestParam String username, @RequestParam String password) {

        if (system.tryLogin(username, password) != null) {
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
        system.addUser(username, password);
        return "/createUser";
    }


    @GetMapping("/404")
    public String errorSite() {
        return "/404";
    }

    @GetMapping("/numberGuess")
    public String random(@RequestParam int nr, Model model) {
        nr = nrGenerator.randomGenerator();
        model.addAttribute("nr", nr);
        return "/numberGuess";
    }

}
