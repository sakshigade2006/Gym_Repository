package com.gymProject.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gymProject.model.WorkOut;
import javax.transaction.Transactional;



@Repository
public interface WorkOutRepo extends JpaRepository<WorkOut, Integer> {

	public WorkOut findByid(int id);

	@Transactional
	public int deleteByid(int id);

	
}
