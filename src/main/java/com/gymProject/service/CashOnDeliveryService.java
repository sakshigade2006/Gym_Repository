package com.gymProject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gymProject.Repository.CashOnDeliveryRepo;
import com.gymProject.model.CashOnDelivery;

@Service
public class CashOnDeliveryService {
    
	@Autowired
    CashOnDeliveryRepo cashOnDeliveryRepo;
	
	
	
	public CashOnDelivery save(CashOnDelivery cashOnDelivery) {
		
		return cashOnDeliveryRepo.save(cashOnDelivery);
	}

	public CashOnDelivery findBycustomerId(String customerId) {
	
		return cashOnDeliveryRepo.findBycustomerId(customerId);
	}

	public List<CashOnDelivery> findAll() {
		
		return cashOnDeliveryRepo.findAll();
	}
	
	

}
