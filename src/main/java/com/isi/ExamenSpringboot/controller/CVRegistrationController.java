package com.isi.ExamenSpringboot.controller;

import com.isi.ExamenSpringboot.entity.CVEntity;
import com.isi.ExamenSpringboot.servivce.CVService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/registration")
public class CVRegistrationController {
    private CVService cvService;

    public CVRegistrationController(CVService cvService) {
        this.cvService = cvService;
    }
    @ModelAttribute("user")
    public CVEntity cvEntity() {
        return new CVEntity();
    }
    @GetMapping
    public String showRegistrationForm(ModelMap modelMap) {
        CVEntity cv = new CVEntity();
        modelMap.addAttribute("cv",cv);
        return "registration";
    }
    @PostMapping
    public String registerUserAccount(@ModelAttribute("user") CVEntity cvEntity) {
        cvService.save(cvEntity);
        return "redirect:/registration?success";
    }

}
