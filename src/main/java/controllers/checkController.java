package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class checkController {

    private static final String EMAIL_REGEX = "^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$";

    @GetMapping("/")
    public String getEmail(){
        return "index";
    }

    @PostMapping("/validate")
    public String validateEmail(@RequestParam("email") String email, Model model){
        boolean isValid = email.matches(EMAIL_REGEX);
        if (!isValid){
            model.addAttribute("message","Email is invalid");
            return "index";
        }
        model.addAttribute("email",email);
        return "success";
    }
}
