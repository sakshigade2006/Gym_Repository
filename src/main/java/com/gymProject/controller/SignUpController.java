package com.gymProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gymProject.Repository.SignUpRepo;
import com.gymProject.dto.Response;
import com.gymProject.model.SignUp;
import com.gymProject.service.SignUpService;

@Controller
public class SignUpController {
	
	@Autowired
	private SignUpService signUpService;
	
	@Autowired
	private SignUpRepo signUpRepo;
	
	//save signUp details 
	@PostMapping("/saveSignUpData")
	@ResponseBody
	public Response saveSignUpData(@RequestBody SignUp signUp) {
		
		Response response = new Response();
		response.setStatus("Not Success");
		response.setMessage("Data Not Saved");
		
		SignUp signUp1 = signUpService.save(signUp);
		if(signUp1 != null) {
			response.setStatus("Success");
			response.setMessage("Data Saved..!!");
			response.setData(signUp1);
		}
		return response;
	}
	
	//retrieve Sign Up By Id
	@PostMapping("/getSignUpDetails")
	@ResponseBody
	public Response getSignUpDetails(@RequestBody SignUp signUp) {
		
		Response response = new Response();
		response.setStatus("Not Success");
		response.setMessage("Data Not Found");
		
		SignUp signUp2 = signUpService.findByid(signUp.getId());
		if(signUp2 != null) {
			response.setStatus("Success");
			response.setMessage("Data Found..!!");
			response.setData(signUp2);
		}
		return response;
	}
	
	//retrieve All Data
	@PostMapping("/getAllSignUpData")
	@ResponseBody
	public List<SignUp> getAllSignUpData(){
		
		List<SignUp> list = signUpService.findAll();
		return list;
	}
	
	//Delete SignUp By Id
	@PostMapping("/deleteSignUpDetailsById")
	@ResponseBody
	public ResponseEntity<String> deleteSignUpDetailsById(@RequestBody SignUp signUp){
		
		int i = signUpRepo.deleteByid(signUp.getId());
		if(i>0) {
			
			return ResponseEntity.ok("Data Deleted Successfully..!!");
		}
		else
			return ResponseEntity.badRequest().body("Data Not Deleted..!!");
		
	}
	
}
