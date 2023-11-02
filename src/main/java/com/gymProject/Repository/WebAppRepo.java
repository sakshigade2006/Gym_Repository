package com.gymProject.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gymProject.model.LoginAdminRequest;

public interface WebAppRepo extends JpaRepository<LoginAdminRequest, Integer> {

	LoginAdminRequest findByUserNameAndPassWord(String username, String password);



	

}
