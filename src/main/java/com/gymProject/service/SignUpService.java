package com.gymProject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gymProject.Repository.SignUpRepo;
import com.gymProject.model.SignUp;

@Service
public class SignUpService {
	
	@Autowired
	SignUpRepo signUpRepo;

	public SignUp save(SignUp signUp) {
		
		return signUpRepo.save(signUp);
	}

	public SignUp findByid(int id) {
		
		return signUpRepo.findByid(id);
	}

	public List<SignUp> findAll() {
		
		return signUpRepo.findAll();
	}

	public SignUp fingByMobileNoAndPassword(String mobileNo, String password) {
	
		return signUpRepo.findByMobileNoAndPassword(mobileNo,password) ;
	}

	public SignUp updateThroughid(SignUp signUp) {
		
		return signUpRepo.saveAndFlush(signUp);
	}

}
