package com.gymProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.gymProject.model.LoginAdminRequest;
import com.gymProject.service.WebAppService;


@Controller
public class WebAppController {
	
	@Autowired
	private WebAppService webAppService;
	
	@PostMapping("/loginadmin")
    public String login(@ModelAttribute("user") LoginAdminRequest loginRequest, Model model) {
        String username = loginRequest.getUserName();
        String password = loginRequest.getPassWord();

      
        loginRequest  = webAppService.authenticate(username, password);

        if (loginRequest != null) {
            // User authenticated successfully, redirect to the next page
            return "index";
        } else {
            // Invalid credentials, add the error message to the model
            String errorMessage = "Wrong Credential !!!";
            model.addAttribute("errorMessage", errorMessage);
            return "signin";
        }
    }

}
