package com.gymProject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gymProject.Repository.WebAppRepo;
import com.gymProject.model.LoginAdminRequest;

@Service
public class WebAppService {

	@Autowired
	private WebAppRepo webAppRepo;

	public LoginAdminRequest authenticate(String username, String password) {
		// TODO Auto-generated method stub
		return webAppRepo.findByUserNameAndPassWord(username,password);
	}
	

	

}
