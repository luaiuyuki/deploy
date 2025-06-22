package com.example.servingwebcontent.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/home")
    public String homePage(Model model, HttpServletRequest request) {
        model.addAttribute("objects", new String[]{"Student", "Course", "Transcript"});
        model.addAttribute("username", request.getUserPrincipal().getName());
        return "home"; // trả về file home.html
    }
}
