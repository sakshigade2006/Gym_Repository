package com.gymProject.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gymProject.model.SignUp;

import javax.transaction.Transactional;

@Repository
public interface SignUpRepo extends JpaRepository<SignUp, Integer> {

	public SignUp findByid(int id);

	@Transactional
	public int deleteByid(int id);

	public SignUp findByMobileNoAndPassword(String mobileNo, String password);

}
