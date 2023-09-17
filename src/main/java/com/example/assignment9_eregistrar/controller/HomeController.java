package com.example.assignment9_eregistrar.controller;

import com.example.assignment9_eregistrar.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @Autowired
    private StudentRepository studentRepository;

    @GetMapping({"/", "/home"})
    public String getHome(Model model) {
        model.addAttribute("students", studentRepository.findAll());
        return "homepage";
    }
}
