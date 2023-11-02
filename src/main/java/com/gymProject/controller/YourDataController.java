package com.gymProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gymProject.Repository.YourDataRepo;
import com.gymProject.dto.Response;
import com.gymProject.model.YourData;
import com.gymProject.service.YourDataService;

@Controller
public class YourDataController {
	
	@Autowired
	private YourDataService yourDataService;
	
	@Autowired
	private YourDataRepo yourDataRepo;

	
	@PostMapping("/saveYourData")
	@ResponseBody
	public Response saveYourData(@RequestBody YourData yourData)  {
		
		Response response = new Response();
		response.setStatus("Not Success");
		response.setMessage("Data Not Saved");
		
		YourData yourData2 = yourDataService.save(yourData);
		if(yourData2 != null) {
			response.setStatus("Success");
			response.setMessage("Data Saved Successfully..!!");
			response.setData(yourData2);
		}
		return response;
	}
	
	//retrieve Your Data By customer Id
	@PostMapping("/retrieveDataByCustomerId")
	@ResponseBody
	public Response retrieveById(@RequestBody YourData yourData) {
		Response response = new Response();
		response.setStatus("Not Success");
		response.setMessage("Data Not Found");
		
		List<YourData> yourData2 = yourDataService.findBycustomerId(yourData.getCustomerId());
		if(!yourData2.isEmpty()) {
			response.setStatus("Success");
			response.setMessage("Data Found..!!");
			response.setData(yourData2);
		}
		return response;	
	}
	
	//retrieve All Data
	@PostMapping("/getAllYourData")
	@ResponseBody
	public List<YourData> getAllYourData(){
		List<YourData> data = yourDataService.findAll();
		return data;
	}
	
	//Delete Your Data By Id
	@PostMapping("/deleteYourDataById")
	@ResponseBody
	public ResponseEntity<String> deleteYourDataById(@RequestBody YourData yourData){
		
		int i = yourDataRepo.deleteByid(yourData.getId());
		if(i>0) {
			return ResponseEntity.ok("Data Deleted Successfully..!!");
		}
		else
			return ResponseEntity.badRequest().body("Data Not Deleted..!!");
	}
	
	
	

}
