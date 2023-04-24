package com.example.carservice.web;

import com.example.carservice.model.view.ServiceOrderViewModel;
import com.example.carservice.sec.CurrentUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller

public class HomeController {

    private final CurrentUser currentUser;

    public HomeController(CurrentUser currentUser) {
        this.currentUser = currentUser;
    }


    @GetMapping("/")
    public String index(Model model) {

        if (currentUser.getId() == null){
            return "index";
        }


        return "home";
    }
}
//3:18:00