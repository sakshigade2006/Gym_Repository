package com.gymProject.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Data;

@Entity
@Data
public class YourData {
	
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public String getHeight() {
		return height;
	}
	public void setHeight(String height) {
		this.height = height;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String customerId;
	private String gender;
	private String unit;
	private String height;
	private String age;
	private String date;
	private String bodyFatPercent;
	private String bodyWeight;
	private String lossGainWeight;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getBodyFatPercent() {
		return bodyFatPercent;
	}
	public void setBodyFatPercent(String bodyFatPercent) {
		this.bodyFatPercent = bodyFatPercent;
	}
	public String getBodyWeight() {
		return bodyWeight;
	}
	public void setBodyWeight(String bodyWeight) {
		this.bodyWeight = bodyWeight;
	}
	public String getLossGainWeight() {
		return lossGainWeight;
	}
	public void setLossGainWeight(String lossGainWeight) {
		this.lossGainWeight = lossGainWeight;
	}
	
	

}
