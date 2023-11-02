package com.gymProject.controller;

import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.gymProject.Repository.TodaysSpecialRepo;
import com.gymProject.dto.Response;
import com.gymProject.model.TodaysSpecial;
import com.gymProject.service.TodaysSpecialService;

import ch.qos.logback.classic.Logger;

@Controller
public class TodaysSpecialController {
	
	private static final Logger logger=(Logger) LoggerFactory.getLogger(TodaysSpecialController.class);

	
	@Autowired
	private TodaysSpecialService todaysSpecialService;
	
	@Autowired
	private TodaysSpecialRepo todaysSpecialRepo;
	
	//upload daily videos 
	@PostMapping("/uploadTodaysSpecialVideo")
	@ResponseBody
	public Response uploadTodaysSpecialVideo(
	@RequestParam(name="videos",required = false)MultipartFile videos1		
	) {
		TodaysSpecial todaysSpecial = new TodaysSpecial();
		String uploadVideo = todaysSpecialService.storesvideos(videos1);
		todaysSpecial.setVideos("http://103.38.50.113:8080/GymAppProjects/uploadFiles/"+uploadVideo);
		
		Response response = new Response<>();
		response.setMessage("Video Not Uploaded..!!");
		response.setStatus("Not Success");
		
		TodaysSpecial todaysSpecial2 = todaysSpecialService.save(todaysSpecial);
		if(todaysSpecial2 != null) {
			response.setMessage("Video Uploaded Successfully..!!");
			response.setStatus("Success");
			response.setData(todaysSpecial2);
		}
		return response;
	}
	
	//retrieve All Uploaded Videos
	@PostMapping("/retrieveAllTodaysSpecialVideos")
	@ResponseBody
	public List<TodaysSpecial> retrieveAllTodaysSpecialVideos(){
		
		List<TodaysSpecial> list = todaysSpecialService.findAll();
		return list;
	}
       
	//delete special Video By id
	@PostMapping("/deleteTodaysSpecialVideoByid")
	@ResponseBody
	public ResponseEntity<String> deleteTodaysSpecialVideoByid(@RequestBody TodaysSpecial todaysSpecial){
	
		int i = todaysSpecialRepo.deleteByid(todaysSpecial.getId());
		if(i>0) {
			return ResponseEntity.ok("Video Deleted Successfully");
		}
		else
			return ResponseEntity.badRequest().body("Video Not Deleted");
	}
	
	
	
	
	
	
	
}
