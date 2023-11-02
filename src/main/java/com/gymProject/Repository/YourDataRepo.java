package com.gymProject.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gymProject.model.YourData;

import java.util.List;

import javax.transaction.Transactional;

@Repository
public interface YourDataRepo extends JpaRepository<YourData, Integer> {
    
	@Transactional
	public int deleteByid(int id);

	public List<YourData> findBycustomerId(String customerId);



	
}
