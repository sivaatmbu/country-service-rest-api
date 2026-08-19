package com.countryService.demo.Services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Component;

import com.countryService.demo.Beans.Country;
import com.countryService.demo.Beans.Message;

@Component
public class CountryService{
	static HashMap<Integer,Country>hashmapDatabase;
	public CountryService() {
		hashmapDatabase=new HashMap<>();
		Country india=new Country(1,"India","Delhi");
		Country usa=new Country(2,"USA","Washington DC");
		Country uk=new Country(3,"UK","London");
		Country japan=new Country(4,"Japan","Tokyo");
		Country china=new Country(5,"China","Beejing");
		Country russia=new Country(6,"Russia","Masco");
		hashmapDatabase.put(1,india);
		hashmapDatabase.put(2,usa);
		hashmapDatabase.put(3,uk);
		hashmapDatabase.put(4,japan);
		hashmapDatabase.put(5,china);
		hashmapDatabase.put(6,russia);
	}

	// SERVICE 1 -- GET ALL COUNTRIES
	public List<Country> getAllCountries(){ 
		List<Country> countries=new ArrayList<Country>(hashmapDatabase.values());
		return countries;
	}
	//SERVICE 2  --GET COUNTRY BY ID
	public Country getCountryById(int id) {
		Country country=hashmapDatabase.get(id);
		return country;
	}
	//SERVICE 3 --GET COUNTRY BY NAME
	public Country getCountryByName(String countryName) {
		Country country=null;
		for(int i:hashmapDatabase.keySet()) {
			if(hashmapDatabase.get(i).getCountryName().equalsIgnoreCase(countryName)) {
				country=hashmapDatabase.get(i);
			}
		}
		return country;
	}
	//SERVICE 4 --ADD NEW COUNTRY - WE WILL PROVIDE ONLY COUNTRY NAME AND CAPITAL BUT ID SHOULD BE ALLOCATED AUTOMATICALLY
		    //so first we create a method which will give us the next id for the new country 
			public int getNextId() {
				int max=0;
				for(int id:hashmapDatabase.keySet()) {
					if(id>max) {
						max=id;
					}
				}
				return max+1;        // this will give us the next id for the new country we are going to add
			}
	public Country addCountry(Country country) {
		country.setId(getNextId());
		hashmapDatabase.put(country.getId(), country);
		return country;
	}
	//SERVICE 5 -- UPDATE COUNTRY
	public Country updateCountry(Country country) {
		if(country.getId()>0) {
			hashmapDatabase.put(country.getId(), country);
		}
		return country;
	}
	//SERVICE 6 -- DELETE COUNTRY - AND DISPLAY A MESSAGE  - COUNTRY DELETED SUCCESSFULLY
		// in this service we need to display a message so first we create a message class and we will use when required 
		// but where to create that message class -- we create it as a bean class
	public Message deleteCountry(int id) {
		hashmapDatabase.remove(id);
		Message msg=new Message();
		msg.setMsg("COUNTRY DELETED SUCCESSFULLY !!");
		msg.setId(id);
		return msg;
	} 
	//now we done with Service Class (all services are ready now just map using Controller class ) - inside Controller Package 
}
