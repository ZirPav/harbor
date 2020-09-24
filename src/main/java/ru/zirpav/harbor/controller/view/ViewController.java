package ru.zirpav.harbor.controller.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {

    @GetMapping("/")
    public String home() {
        return "harbor";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/logout")
    public String logout() {
        return "harbor";
    }

    @GetMapping("/register")
    public String register(){
        return "register";
    }

    @GetMapping("/user")
    public String userInfo() {
        return "user";
    }

    @GetMapping("/admin")
    public String adminInfo() {
        return "users";
    }
}
