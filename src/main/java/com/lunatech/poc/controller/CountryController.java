package com.lunatech.poc.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lunatech.poc.model.Airport;
import com.lunatech.poc.model.Country;
import com.lunatech.poc.repository.AirportRepository;
import com.lunatech.poc.repository.CountryRepository;

@RestController
@RequestMapping(path = "/lunatech")
public class CountryController {
	@Autowired
	private CountryRepository countryRepository;
	
	@Autowired
	private AirportRepository airportRepository;

	@GetMapping(path = "/country")
	public @ResponseBody List<Country> getAllCountries() {
		List<Country> countryList = countryRepository.getCountryCodeAndName();
		return countryList;
	}

	@GetMapping(path = "/country/{countryCode}")
	public @ResponseBody List<Airport> getAllAirportsByCountryCode(@PathVariable String countryCode) {
		List<Airport> airportList = airportRepository.getAirportByCountryCode(countryCode);
		System.out.println("Given Country code " + countryCode);
		return airportList;
	}
}
