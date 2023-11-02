package com.gymProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gymProject.Repository.CashOnDeliveryRepo;
import com.gymProject.dto.Response;
import com.gymProject.model.CashOnDelivery;
import com.gymProject.service.CashOnDeliveryService;

@Controller
public class CashOnDeliveryController {
	
	@Autowired
	CashOnDeliveryService cashOnDeliveryService;
	
	@Autowired
	CashOnDeliveryRepo cashOnDeliveryRepo;
	
	@PostMapping("/saveCashOnDeliveryData")
	@ResponseBody
	public Response saveCashOnDeliveryData(@RequestBody CashOnDelivery cashOnDelivery) {
		
		Response response = new Response<>();
		response.setStatus("Not Success");
		response.setMessage("Data Not Saved..!!");
		
		CashOnDelivery cashOnDelivery2 = cashOnDeliveryService.save(cashOnDelivery);
		if(cashOnDelivery2 != null) {
			response.setStatus("Success");
			response.setMessage("Data Saved Successfully..!!");
			response.setData(cashOnDelivery2); 
		}
		return response;
		
	}
	
	@PostMapping("retrieveCashOndeliveryDataByCustomerId")
	@ResponseBody
	public Response retrieveCashOndeliveryDataById(@RequestBody CashOnDelivery cashOnDelivery) {
		Response response = new Response<>();
		response.setStatus("Not Success");
		response.setMessage("Data Not Found..!!");
		
		CashOnDelivery cashOnDelivery2 = cashOnDeliveryService.findBycustomerId(cashOnDelivery.getCustomerId());
		if(cashOnDelivery2 != null) {
			response.setStatus("Success");
			response.setMessage("Data Found");
			response.setData(cashOnDelivery2);
		}
		return response;	
	}
	
	@PostMapping("retrieveAllDataCashOnDelivery")
	@ResponseBody
	public List<CashOnDelivery> retrieveAllDataCashOnDelivery(){
		List<CashOnDelivery> list = cashOnDeliveryService.findAll();
		return list;
	}
	
	@PostMapping("/deleteByidCashOnDelivery")
	@ResponseBody
	public ResponseEntity<String> deleteByidCashOnDelivery(@RequestBody CashOnDelivery cashOnDelivery){
		int i = cashOnDeliveryRepo.deleteByid(cashOnDelivery.getId());
		if(i>0) {
			return ResponseEntity.ok("Data Deleted Successfully..!!");
		}
		else
			return ResponseEntity.badRequest().body("Data Not Deleted");
	}

}
