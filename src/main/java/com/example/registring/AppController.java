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
    public UserRepository repo;

    @GetMapping ("")
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

        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String encodedpassword = bCryptPasswordEncoder.encode(user.getPassword());
        user.setPassword(encodedpassword);
        repo.save(user);

        return "index";
    }

    @GetMapping("/list_user")
    public String users()
    {
        return "users";
    }
}
