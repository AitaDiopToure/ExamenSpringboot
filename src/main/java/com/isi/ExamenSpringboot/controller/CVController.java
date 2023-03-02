package com.isi.ExamenSpringboot.controller;

import com.isi.ExamenSpringboot.entity.CVEntity;
import com.isi.ExamenSpringboot.servivce.CVService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Controller
public class CVController {
    @Autowired
    private CVService service;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
        CVEntity cv = service.edit(id);
        model.addAttribute("cv", cv);
        return "edit";
    }

    @PostMapping("/update")
    public String updateCVEntity(CVEntity cv) {
        service.save(cv);
        return "redirect:/edit/" + cv.getId();
    }

    @GetMapping(value = "/visualisation")
    public  String getAll (Model model){
        model.addAttribute("cv", service.findAll());
        return "/visualisation";
    }
}
