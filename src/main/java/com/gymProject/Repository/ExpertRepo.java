package com.gymProject.Repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gymProject.model.Expert;



@Repository
public interface ExpertRepo extends JpaRepository<Expert, Integer> {

	@Transactional
	public int deleteByid(int id);

}
