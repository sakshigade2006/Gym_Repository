package com.gymProject.controller;

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
public class LogInController {
	
	@Autowired
	private SignUpService signUpService;
	
	@Autowired
	private SignUpRepo signUpRepo;
	
	//retrievel Code
	@PostMapping("/retrieveSignUpDetails")
	@ResponseBody
	public Response retrieveSignUpDetails(@RequestBody SignUp signUp) {
		Response response = new Response();
		response.setStatus("Fail");
		response.setMessage("No data found");
		
		SignUp signUp2 = signUpService.fingByMobileNoAndPassword(signUp.getMobileNo(),signUp.getPassword());
		if(signUp2 != null) {
			response.setStatus("Success");
			response.setMessage("Login Data");
			response.setData(signUp2);
		}
		return response;
	}

	//delete By Id
	@PostMapping("/deleteByIdSignUp")
	@ResponseBody
	public ResponseEntity<String> deleteByIdSignUp(@RequestBody SignUp signUp){
		int i = signUpRepo.deleteByid(signUp.getId());
		
		if(i>0) {
			
			return ResponseEntity.ok("Data Deleted Successfull..");
			
		}
		
		else
			return ResponseEntity.badRequest().body("Data Not Deleted");
		
	}
	
	//update Password By Id
	@PostMapping("/updatePasswordById")
	@ResponseBody
	public Response updatePasswordById(@RequestBody SignUp signUp) {
	 
		Response response = new Response();
		response.setStatus("Not Success");
		response.setMessage("No Password Updated");
		
		SignUp signUp2 = signUpService.updateThroughid(signUp);
		if(signUp2 != null) {
			response.setStatus("Success");
			response.setMessage("Password Updated Successfully..!!");
			response.setData(signUp2);
		}
		return response;
	}
	
	
}
