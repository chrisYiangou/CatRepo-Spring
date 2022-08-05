package com.qa.catapi.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.qa.catapi.models.Cat;

@Repository
public interface CatRepo extends JpaRepository<Cat, Long> {
	
	// Custom Queries --
	// Select All from Cat
	@Query(value = "SELECT * FROM cat", nativeQuery = true) 
	public List<Cat> allFromCat();
	
	@Query(value = "SELECT * FROM cat WHERE name = ?1", nativeQuery = true) 
	public List<Cat> sameNameSelect(String name);

}
