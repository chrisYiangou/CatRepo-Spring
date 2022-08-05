package com.qa.catapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.catapi.models.Cat;
import com.qa.catapi.repo.CatRepo;

@Service
public class CatService {

	//CRUD
	@Autowired
	private CatRepo repo;
	
	@Autowired
	public CatService(CatRepo repo) {
		this.repo = repo;
	}
	
	//Create 
	public Cat addCat(Cat cat) {
		return repo.save(cat);
	}
	
	//Read
	public Cat readCat(Long id) {
		return repo.findById(id).get();
	}
	
	public List<Cat> readAllCats() {
		return this.repo.findAll();
	}
	
	//Update
	public Cat updateCat(Cat updateCat, Long id) {
		//First we want to get the cat 
		//Builders are a design pattern ---> Homework 
		Optional<Cat> currentCat = this.repo.findById(id);
	
		if (currentCat.get() instanceof Cat) {
			Cat oldCat = currentCat.get();
			
			oldCat.setAge(updateCat.getAge());
			oldCat.setName(updateCat.getName());
			return repo.save(oldCat);
		}
		
		// else {throw ...}
		return null;	
	}
	
	//Delete
	public boolean deleteByCatID(Long id) {
		Optional<Cat> currentCat = this.repo.findById(id);
		
		//Ternary Statement we need to ensure we use it within a variable
		
		boolean isPresent = (currentCat.isPresent()) ?  true : false;
		
		if (isPresent) {
			this.repo.deleteById(id);
			return true;
		} else {
//			throw new Exception();
			return false;
		}
	}
}
