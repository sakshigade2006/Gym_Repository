package com.gymProject.service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.gymProject.Exception.FileStorageException;
import com.gymProject.Repository.WorkOutRepo;
import com.gymProject.model.WorkOut;
import com.gymProject.property.FileStorageProperties;





@Service
public class WorkOutService {
	
	/* private final Path fileStorageLocation ; */
	
	@Autowired
	WorkOutRepo workOutRepo;
	
	/*
	 * @Autowired public WorkOutService(FileStorageProperties fileStorageProperties)
	 * { this.fileStorageLocation=Paths.get(fileStorageProperties.getUploadDir()).
	 * toAbsolutePath().normalize(); try {
	 * Files.createDirectories(this.fileStorageLocation); }catch(Exception ex) {
	 * throw new
	 * FileStorageException("Could not create the directory where the uploaded files will be stored."
	 * , ex); } }
	 */
	
	
	
 
	/*
	 * public String storesvideo(MultipartFile video1) { String videos =
	 * StringUtils.cleanPath(video1.getOriginalFilename()) ; try {
	 * if(videos.contains("..")) {
	 * 
	 * throw new
	 * FileStorageException("Sorry! Filename contains invalid path sequence "+videos
	 * ); } Path targetLocation=this.fileStorageLocation.resolve(videos);
	 * Files.copy(video1.getInputStream(),targetLocation,
	 * StandardCopyOption.REPLACE_EXISTING); return videos; } catch(IOException ex)
	 * { throw new
	 * FileStorageException("Could Not store file"+videos+"Please try again !"+ex);
	 * }
	 * 
	 * }
	 */
	
	
	/*
	 * public Resource loadFileAsResource(String fileName) { try { Path filePath =
	 * this.fileStorageLocation.resolve(fileName).normalize(); Resource resource =
	 * new UrlResource(filePath.toUri()); if(resource.exists()) { return resource; }
	 * else { throw new
	 * com.gymProject.Exception.MyFileNotFoundException("File not found" +fileName);
	 * } } catch(MalformedURLException ex) { throw new
	 * com.gymProject.Exception.MyFileNotFoundException("File not found " +fileName,
	 * ex); } }
	 */

	public WorkOut save(WorkOut workOut) {
		return workOutRepo.save(workOut);
	}



	public WorkOut findByid(int id) {
	
		return workOutRepo.findByid(id);
	}


	public List<WorkOut> findAll() {
		
		return workOutRepo.findAll();
	}


	
	

}
