package com.haqq.microservice;

import com.haqq.microservice.model.User;
import com.haqq.microservice.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

@Controller
public class LoginController {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private RestTemplate restTemplate = new RestTemplate();



    @RequestMapping("/")
    public String checkMVC(){
        return "login";
    }

    @RequestMapping("/login")
    public String loginHome(@RequestParam("username") String username, @RequestParam("password") String password, Model model){
        User user;

        try {
            user = userRepo.findByName(username);
        }catch (Exception e){
            System.out.println("user not found");
           return "login";
        }

        if(user != null){
            model.addAttribute("username", username);
            return "home";
        }

        model.addAttribute("error", "User not found");
        return "login";
    }


    @RequestMapping("/register")
    public String getLogin(){
            return "register";
    }


    @RequestMapping("/set-user")
    public String gotoRegisterMicroservice(@RequestParam("username") String username, @RequestParam("password1") String password1, @RequestParam("password2") String password2, Model model){
        if(password1.equals(password2)){
            restTemplate.getForObject("http://localhost:8081/register-user/"+username+"/"+password1, String.class);
            model.addAttribute("success", "Register Success");

        }else{
            model.addAttribute("error", "password not match");
        }
        return "login";
    }
}
