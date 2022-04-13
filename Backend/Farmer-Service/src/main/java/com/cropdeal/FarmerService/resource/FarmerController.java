package com.cropdeal.FarmerService.resource;


import java.util.Arrays;




import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


import com.cropdeal.FarmerService.models.Crop;
import com.cropdeal.FarmerService.models.Farmer;

import com.cropdeal.FarmerService.repository.FarmerRepository;
import com.cropdeal.FarmerService.repository.UserRepository;




@RestController
@CrossOrigin("http://localhost:4200")
public class FarmerController {

	@Autowired
	private RestTemplate restTemp;

	@Autowired
	private FarmerRepository farmerRepo;

	@Autowired
	FarmerService farmercustom;
	
	@Autowired
	UserRepository repository;

	

	@PostMapping("/addfarmer")
	public String addfarmer(@RequestBody Farmer farmer) {
		farmerRepo.save(farmer);
		return "Added farmer with id " + farmer.getId();
	}

	@GetMapping("/findfarmer")
	public List<Farmer> getfarmer() {
		return farmerRepo.findAll();
	}

	
	@GetMapping("/findfarmer/{id}")
	public Optional<Farmer> getfarmer(@PathVariable String id) {
		return farmerRepo.findById(id);
	}

	@PutMapping("/farmer/update/{id}")
	public void updateFarmer(@RequestBody Farmer farmer, @PathVariable("id") String id) {
		farmercustom.updateFarmer(id, farmer);

	}

	@DeleteMapping("/deletefarmer/{id}")
	public String deleteFarmer(@PathVariable String id) {
		farmerRepo.deleteById(id);
		return "farmer deleted havin id " + id;
	}
	
	
	
	
	
	
	
	//---------get all crops----------------------------------------------------//
	@GetMapping("/farmer/get/crop")
	public List<Object> getCropatFarmer() {
		Object[] crop = restTemp.getForObject("http://Crop-Service/findcrop", Object[].class);
		return Arrays.asList(crop);
	}
	
	//------------------------------get crops by id-----------------------

	@GetMapping("/farmer/get/crop/{id}")
	public List<Crop> getCropatFarmerbyID(@PathVariable("id") String id) {
		Crop crop = restTemp.getForObject("http://Crop-Service/findcrop/" + id, Crop.class);
		return Arrays.asList(crop);
	}
	
	//-------------------------delete the crop by farmer---------------------

	@RequestMapping(value = "/farmer/delete/crop/{_id}", method = RequestMethod.DELETE)
	public String deleteCropById(@PathVariable("_id") String _id) {
		return restTemp.exchange("http://Crop-Service/deletecrop/" + _id, HttpMethod.DELETE, null, String.class)
				.getBody();
	}
	
	//-----------------------------adding crops by farmer---------------

	@RequestMapping(value = "/farmer/add/crop", method = RequestMethod.POST)
	public String addCropatFarmer(@RequestBody Crop crop) {
		HttpEntity<Crop> entity = new HttpEntity<Crop>(crop);
		return restTemp.exchange("http://Crop-Service/addcrop", HttpMethod.POST, entity, String.class).getBody();

	}

	
	//---------------------update the crop by farmer-----------------------------
		@RequestMapping(value="/farmer/update/crop/{id}", method = RequestMethod.PUT)
		public String updateCropatFarmer(@RequestBody Crop crop) {
			HttpEntity<Crop> entity = new HttpEntity<Crop>(crop);
			return restTemp.exchange("http://Crop-Service/updatecrop/", HttpMethod.PUT, entity, String.class).getBody();

		}
		
		
}
