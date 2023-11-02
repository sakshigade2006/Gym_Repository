package com.gymProject.Repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gymProject.model.CashOnDelivery;

@Repository
public interface CashOnDeliveryRepo  extends JpaRepository<CashOnDelivery, Integer>{

	public CashOnDelivery findBycustomerId(String customerId);

	@Transactional
	public int deleteByid(int id);

}
