package com.qa.catapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.catapi.models.Cat;
import com.qa.catapi.service.CatService;

@RestController
@RequestMapping("/home")
public class CatController {
	
	
	
	@Autowired
	CatService service;
	
	//URL's -- We need to ensure that we place / after variables???
	// The controller is able to give requests and take requests -- depending on URL
	
	@Autowired
	public CatController(CatService catService) {
		this.service = catService;
	}
	
	@GetMapping()
	public String showHOne() {
		return "<h1> Hello World </h1> "
				+ "<br/>"
				+ "<p> Hello Everyone </p>";
	}
	//Response Body -- JSON -- Get our objects
	
	//Read
	
	//One taking in responses / response data 
	//Sending out status Codes
	
	
	@GetMapping("/getCats")
	public ResponseEntity<List<Cat>> getCats() {
		List<Cat> catData = this.service.readAllCats();
		
		return new ResponseEntity<List<Cat>>(catData, HttpStatus.OK);
	}
	
	
	//Create
	@PostMapping("/createCat")
	public ResponseEntity<Cat> createCat(@RequestBody Cat cat) {
		Cat createCat = this.service.addCat(cat);
		
		return new ResponseEntity<Cat>(createCat, HttpStatus.CREATED);
	}
	
	// Put/Patch - Update 
	// Put -- is a complete replacement
	// Patch -- some replacements
	
	@PutMapping("/updateCat/{id}") 
	public ResponseEntity<Cat> updateCat(@RequestBody Cat cat, @PathVariable Long id) {
		Cat updateCat = service.updateCat(cat, id);
		
		return new ResponseEntity<Cat>(updateCat, HttpStatus.I_AM_A_TEAPOT);
	}
	
	@DeleteMapping("/deleteCat/{id}")
	public ResponseEntity<Boolean> deleteCat(@PathVariable Long id) {
		
		Boolean deletedCat = service.deleteByCatID(id);
	
		return (deletedCat) ? new ResponseEntity<Boolean>(HttpStatus.NO_CONTENT) 
							: new ResponseEntity<Boolean>(HttpStatus.NOT_FOUND);
		
		
//		return new ResponseEntity<Boolean>(deletedCat, HttpStatus.NO_CONTENT);
	}
}


	//At this point in time we arnt sending any Responses back -- Quite primitive
	//How would we actually put in this reponses
	

	
	//The user will be able to put in any id they would like 
	//And as such they are free to choose through the id how to update
