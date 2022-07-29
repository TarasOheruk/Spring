package com.example.registring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AppController {

    @Autowired
    UserService userService;

    @GetMapping ("/main")
    public String view(){
        return "index";
    }

    @GetMapping ("/register")
    public String signUp(Model model){
        model.addAttribute("user",new User());
        return "signup_form";
    }
    @PostMapping("/process_register")
    public String Regisrt(User user){
        userService.saveDefaultUser(user);
        return "index";
    }

    @GetMapping("/list_user")
    public String users()
    {
        return "users";
    }
}
