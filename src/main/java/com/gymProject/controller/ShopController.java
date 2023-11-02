package com.gymProject.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.gymProject.Repository.ShopRepo;
import com.gymProject.dto.Response;
import com.gymProject.model.Shop;
import com.gymProject.service.ShopService;

@Controller
public class ShopController {
	
	@Autowired
	private ShopService shopService;
	
	@Autowired 
	private ShopRepo shopRepo;
	
   
	//save shop details
		@PostMapping("/saveshopData")
		@ResponseBody
		public Response saveshopData(
	    @RequestParam(name="productName", required = false)	String productName,		
		@RequestParam(name="description", required = false) String description,		
		@RequestParam(name="image", required = false)MultipartFile image1,
		@RequestParam(name="image2", required = false)MultipartFile image2,
		@RequestParam(name="image3", required = false)MultipartFile image3,
		@RequestParam(name="image4", required = false)MultipartFile image4,
		@RequestParam(name="image5", required = false)MultipartFile image5,
		@RequestParam(name="quantity", required = false) String quantity,
		@RequestParam(name="color", required = false) String color,
		@RequestParam(name="product_title", required = false) String product_title,
		@RequestParam(name="price", required = false) String price,
		@RequestParam(name="priceDiscount", required = false) String priceDiscount,
		@RequestParam(name="shortDescription", required = false) String shortDescription	
		
		) {
			
			
			Shop shop = new Shop();
			String uploadImage = shopService.storesimage(image1);
			String uploadImage2 = shopService.storesimage(image2);
			String uploadImage3 = shopService.storesimage(image3);
			String uploadImage4 = shopService.storesimage(image4);
			String uploadImage5 = shopService.storesimage(image5);
			shop.setProductName(productName);
			shop.setDescription(description);
			shop.setPrice(price);
			shop.setQuantity(quantity);
			shop.setColor(color);
			shop.setProduct_title(product_title);
			shop.setPriceDiscount(priceDiscount);
			shop.setShortDescription(shortDescription);
			
			shop.setImage("http://103.38.50.113:8080/GymAppProjects/uploadFiles/"+uploadImage);
			shop.setImage2("http://103.38.50.113:8080/GymAppProjects/uploadFiles/"+uploadImage2);
			shop.setImage3("http://103.38.50.113:8080/GymAppProjects/uploadFiles/"+uploadImage3);
			shop.setImage4("http://103.38.50.113:8080/GymAppProjects/uploadFiles/"+uploadImage4);
			shop.setImage5("http://103.38.50.113:8080/GymAppProjects/uploadFiles/"+uploadImage5);
			
			
			Response response= new Response<>();
			response.setMessage("Data Not Saved..!!");
			response.setStatus("Not Success");
			
			Shop shop2 = shopService.save(shop);
			if(shop2 != null) {
				response.setMessage("Data Saved..!!");
				response.setStatus("Success");
				response.setData(shop2);
				
			}
			return response;
		}
		
	
	
	
	
	/*
	 * //save details with upload Multiple Images
	 * 
	 * @PostMapping("/uploadImagesAndDetails")
	 * 
	 * @ResponseBody public Response uploadImagesAndDetails(
	 * 
	 * @RequestParam(name="files", required = false) List<MultipartFile> files,
	 * 
	 * @RequestParam(name="productName", required = false)String productName,
	 * 
	 * @RequestParam(name="productTitle", required = false)String productTitle,
	 * 
	 * @RequestParam(name="description", required = false)String description,
	 * 
	 * @RequestParam(name="shortDescription", required = false)String
	 * shortDescription,
	 * 
	 * @RequestParam(name="quantity", required = false)String quantity,
	 * 
	 * @RequestParam(name="price", required = false)String price,
	 * 
	 * @RequestParam(name="color", required = false)String color )
	 * 
	 * {
	 * 
	 * Response response = new Response<>(); response.setStatus("Not Success");
	 * response.setMessage("Data Not Saved..!!"); try { Shop shop= new Shop();
	 * List<String> storeValueInArray = new ArrayList<>();
	 * 
	 * List<String> multipleImages = new ArrayList<>();
	 * 
	 * for(MultipartFile file : files) { String multipleImage =
	 * shopService.storesimage(file); storeValueInArray.add(multipleImage);
	 * multipleImages.add(multipleImage); }
	 * 
	 * shop.setProductName(productName); shop.setProductTitle(productTitle);
	 * shop.setDescription(description); shop.setShortDescription(shortDescription);
	 * shop.setQuantity(quantity); shop.setPrice(price); shop.setColor(color);
	 * shop.setImage(storeValueInArray.toString());
	 * 
	 * Shop shop2= shopService.save(shop); if(shop2 != null) { //return
	 * ResponseEntity.ok().body("Data Saved Successfully..!!");
	 * response.setMessage("Data Saved Successfully..!!");
	 * response.setStatus("Success"); response.setData(shop2);
	 * 
	 * } } catch(Exception e) { //return
	 * ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
	 * //System.out.println(e.getMessage()); e.printStackTrace(); } return response;
	 * }
	 */
	
	
	//retrieve Shop Details By id
	@PostMapping("retrieveShopDataById")
	@ResponseBody
	public Response retrieveShopDataById(@RequestBody Shop shop) {
		
		Response response= new Response<>();
		response.setMessage("Data Not Found..!!");
		response.setStatus("Not Success");
		
		Shop shop2 = shopService.findByid(shop.getId());
		if(shop2 != null) {
			response.setMessage("Data Found..!!");
			response.setStatus("Success");
			response.setData(shop2);
		}
		return response;
	}
	
	//retrieve All 
	@PostMapping("retrieveAllShopData")
	@ResponseBody
	public List<Shop> retrieveAllShopData() {
		
		List<Shop> list = shopService.findAll();
		return list;
	}
	
	//delete Shop Data by id
	@PostMapping("/deleteShopDataById")
	@ResponseBody
	public ResponseEntity<String> deleteShopDataById(@RequestBody Shop shop) {
		
		int i = shopRepo.deleteByid(shop.getId());
		
		if(i>0) {
			return ResponseEntity.ok("Data Deleted Successfully..!!");
		}
		else
			return ResponseEntity.badRequest().body("Data Not Deleted..");
	}
	
	
	

}
