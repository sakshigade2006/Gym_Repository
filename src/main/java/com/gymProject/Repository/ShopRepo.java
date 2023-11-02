package com.gymProject.Repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gymProject.model.Shop;

@Repository
public interface ShopRepo extends JpaRepository<Shop, Integer> {

	public Shop findByid(int id);

	@Transactional
	public int deleteByid(int id);

}
