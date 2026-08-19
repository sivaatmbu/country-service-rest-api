package com.countryService.demo.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.countryService.demo.Beans.Country;
import com.countryService.demo.Beans.Message;
import com.countryService.demo.Services.CountryService;

@RestController

public class CountryController {
	//we already have CountryService it has all services 
	//so first create Object for that class and call those methods with that object 
	//but in spring boot we can simply do that instead that object using @Autowired annotation followed by "ClassName object"
	
	@Autowired
	CountryService countryService;
	// -------------------------------
	@GetMapping("/getAllCountries")
	public List<Country> getAllCountries() {
	    return countryService.getAllCountries();
	}
	@GetMapping("/getCountryById/{id}")
	public Country getCountryById(@PathVariable int id) {
	    return countryService.getCountryById(id);
	}
	@GetMapping("/getCountryByName/countryName")
	public Country getCountryByName(@RequestParam String countryName) {
		return countryService.getCountryByName(countryName);
	}
	@PostMapping("/addCountry")
	public Country addCountry(@RequestBody Country country) {
		return countryService.addCountry(country);
	}
	@PutMapping("/updateCountry")
	public Country updateCountry(@RequestBody Country country) {    //
		return countryService.updateCountry(country);
	}
	@DeleteMapping("/deleteCountry/{id}")
	public Message deleteCountry(@PathVariable int id) {
		return countryService.deleteCountry(id);
	}
}
