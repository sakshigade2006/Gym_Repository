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
import com.gymProject.Repository.ExpertRepo;
import com.gymProject.model.Expert;
import com.gymProject.property.FileStorageProperties;

@Service
public class ExpertService {
	
	private final Path fileStorageLocation ;
	
	@Autowired
	private ExpertRepo expertRepo;
	
	@Autowired
	public ExpertService(FileStorageProperties fileStorageProperties) {
		this.fileStorageLocation=Paths.get(fileStorageProperties.getUploadDir()).toAbsolutePath().normalize();
		try {
			Files.createDirectories(this.fileStorageLocation);
		}catch(Exception ex) {
			throw new FileStorageException("Could not create the directory where the uploaded files will be stored.", ex);
		}
	}
	
	

	
	public Resource loadFileAsResource(String fileName) {
		try {
			Path filePath = this.fileStorageLocation.resolve(fileName).normalize();
			Resource resource = new UrlResource(filePath.toUri());
			if(resource.exists()) {
				return resource;
			}
			else {
				throw new com.gymProject.Exception.MyFileNotFoundException("File not found" +fileName);
			}
		} catch(MalformedURLException ex) {
			throw new com.gymProject.Exception.MyFileNotFoundException("File not found " +fileName, ex);
		}
	}




	public String storesimage(MultipartFile file) {
		String image = StringUtils.cleanPath(file.getOriginalFilename()) ;
		try {
	        if(image.contains("..")) {
					
					throw new FileStorageException("Sorry! Filename contains invalid path sequence "+file);
				}
	       Path targetLocation=this.fileStorageLocation.resolve(image);
	       Files.copy(file.getInputStream(),targetLocation, StandardCopyOption.REPLACE_EXISTING);
	       return image;
			}
			catch(IOException ex) {
				throw new FileStorageException("Could Not store file"+file+"Please try again !"+ex);
			}	
	
	}




	public Expert save(Expert expert) {
	
		return expertRepo.save(expert);
	}




	public List<Expert> findAll() {
		
		return expertRepo.findAll();
	}




	
	
	

	



	

}
