package com.gymProject.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gymProject.Repository.YourDataRepo;
import com.gymProject.model.YourData;


@Service
public class YourDataService {

	@Autowired
	private YourDataRepo yourDataRepo;

	public YourData save(YourData yourData) {
		
		return yourDataRepo.save(yourData);
	}


	public List<YourData> findAll() {
		
		return yourDataRepo.findAll();
	}


	public List<YourData> findBycustomerId(String customerId) {
		
		return yourDataRepo.findBycustomerId(customerId);
	}


	
}
