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

import com.gymProject.Repository.ExpertRepo;
import com.gymProject.dto.Response;
import com.gymProject.model.Expert;
import com.gymProject.service.ExpertService;

import ch.qos.logback.classic.Logger;

@Controller
public class ExpertController {
	
	private static final Logger logger=(Logger) LoggerFactory.getLogger(ExpertController.class);

	
	@Autowired
	private ExpertService expertService;
	
	@Autowired
	private ExpertRepo expertRepo;
	
	//save Expert Details
	@PostMapping("/saveExpertDetails")
	@ResponseBody
	public Response saveExpertDetails(
	@RequestParam(name="name" ,required = false)String name,
	@RequestParam(name="detailDescription" ,required = false)String detailDescription,
	@RequestParam(name="experience" ,required = false)String experience,
	@RequestParam(name="ratings" ,required = false)String ratings,
	@RequestParam(name="mobileNo" ,required = false)String mobileNo,
	
	
	@RequestParam(name="file" ,required = false) MultipartFile file	
	) {
		
		Expert expert = new Expert();
		String imgUpload = expertService.storesimage(file);
		
		expert.setName(name);
		expert.setDetailDescription(detailDescription);
		expert.setExperience(experience);
		expert.setRatings(ratings);
		expert.setMobileNo(mobileNo);
		expert.setImage("http://103.38.50.113:8080/GymAppProjects/uploadFiles/"+imgUpload);
		
		Response response = new Response();
		response.setStatus("Not Success");
		response.setMessage("Data Not Saved.!!");
		
		Expert expert2 = expertService.save(expert);
		if(expert2 != null) {
			response.setStatus("Success");
			response.setMessage("Data Saved Successfully..!!");
			response.setData(expert2);
		}
		return response;
		
	}
	
	//retrieve All Expert Data
	@PostMapping("/getAllExpertData")
	@ResponseBody
	public List<Expert> getAllExpertData(){
		
		List<Expert> list = expertService.findAll();
		return list;
	}
	
	//delete By id
	@PostMapping("/deleteExpertDataById")
	@ResponseBody
	public ResponseEntity<String> deleteExpertDataById(@RequestBody Expert expert){
		int i = expertRepo.deleteByid(expert.getId());
		if(i>0) {
			return ResponseEntity.ok("Data Deleted");
		}
		else
			return ResponseEntity.badRequest().body("Data not deleted..");
	}
	

}
