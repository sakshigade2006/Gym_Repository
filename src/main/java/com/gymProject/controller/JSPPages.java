package com.gymProject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class JSPPages {
	
	
//Sign in JSP	
@GetMapping("/")
public String Signin(Model model) {
	return "signin";
}

//Index JSP
@GetMapping("/index")
public String Index(Model model) {
	return "index";
}

//workout JSP
@GetMapping("/workOutEdit")
public String workoutJSP(Model model) {
	return "workOutEdit";
}

//logout api
@GetMapping("/logout")
public String logout(Model model) {
	return "signin";
}


//expertEdit api
@GetMapping("/expertEdit")
public String expertEdit(Model model) {
	return "expertEdit";
}

//TodaySpecialVideoEdit api
@GetMapping("/todaySpecialVideoEdit")
public String TodaySpecialVideoEdit(Model model) {
	return "TodaySpecialVideoEdit";
}

}
