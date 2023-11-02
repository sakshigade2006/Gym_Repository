package com.gymProject.controller;


import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.gymProject.Repository.WorkOutRepo;
import com.gymProject.dto.Response;
import com.gymProject.model.WorkOut;
import com.gymProject.service.WorkOutService;


import ch.qos.logback.classic.Logger;



@Controller
public class WorkOutController {
	
		
	@Autowired
	private WorkOutService workOutService;
	
	@Autowired
	private WorkOutRepo workOutRepo;
	
	
	 @PostMapping("/saveWorkOutData") 
	 @ResponseBody
	 public Response saveWorkOutData(@RequestBody WorkOut workOut) {
		 
		 Response response = new Response();
		 response.setStatus("Not Success");
		 response.setMessage("Data Not Saved..!!");
		 
		 WorkOut workOut2 = workOutService.save(workOut);
		 if(workOut2 != null) {
			 response.setStatus("Success");
			 response.setMessage("Data Saved Successfully..!!");
			 response.setData(workOut2);
		 }
		 return response;
	 }
	 
	
	//Retrieve WorkOut Data By Id
	@PostMapping("/getWorkOutDataById")
	@ResponseBody
	public Response getWorkOutDataById(@RequestBody WorkOut workOut) {
		Response response = new Response();
		response.setStatus("Not success");
		response.setMessage("Data not found");
		
		WorkOut workOut2 = workOutService.findByid(workOut.getId());
		if(workOut2 != null) {
			response.setData(workOut2);
			response.setStatus("Success");
			response.setMessage("Data retrieved");	
		}
		return response;
		
	}
	
	//Retrieve All Data 
	@PostMapping("/getAllWorkOutData")
	@ResponseBody
	public List<WorkOut> getAllWorkOutData(){
		
		List<WorkOut> list = workOutService.findAll();
		return list;
	}
	
	//delete WorkOut Data By Id
	@PostMapping("/deleteWorkOutById")
	@ResponseBody
	public ResponseEntity<String> deleteWorkOutById(@RequestBody WorkOut workOut){
		int i = workOutRepo.deleteByid(workOut.getId());
		if(i>0) {
			return ResponseEntity.ok("Data Deleted..!!");
		}
		else
			return ResponseEntity.badRequest().body("Data Not Deleted..!!");
	}
	
	
	
	

}
