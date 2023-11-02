package com.gymProject.Repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gymProject.model.TodaysSpecial;

@Repository
public interface TodaysSpecialRepo extends JpaRepository<TodaysSpecial, Integer>{

	@Transactional
	int deleteByid(int id);

}
