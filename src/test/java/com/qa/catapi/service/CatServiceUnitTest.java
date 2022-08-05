package com.qa.catapi.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.qa.catapi.models.Cat;
import com.qa.catapi.repo.CatRepo;

@SpringBootTest
public class CatServiceUnitTest {
	
	//Autowired -- We dont have normal control
	//Spring is in control
	
	@Autowired
	private CatService service;
	
	@MockBean
	private CatRepo repo;
	
	//Save a cat into the repo ---
	
	@Test
	public void createCat_ValidCat_SaveCat() {
		
		//When we save the cat -- We dont enter an id
		
		Cat saveCat = new Cat("Bobby", 10);
		Cat repoCat = new Cat(1L, "Bobby", 10);
		
		//Mockito is a mocking tool -- Dependency Injection tool
		//Script some action 
		
		//Automation testing -- 
		Mockito.when(this.service.addCat(saveCat)).thenReturn(repoCat);
		
		assertEquals(repoCat, this.repo.save(saveCat));
		
		
		//Only verify your mocks
		Mockito.verify(this.repo, Mockito.times(1)).save(saveCat);
		
		
	}
	
	@Test
	public void updateCat_ValidId_UpdateCat() {
		
		//Put a cat into the repo and the print it
		Long testId = 1L;
		//Cat saveCat = new Cat("Bobby", 10);
		Cat updateCat = new Cat("Samantha", 20);
		// Id of One -- therefore a cat should exist with this id
		
		Optional<Cat> mockOutputValid =
				Optional.ofNullable(new Cat(1L, "Bobby", 10));
		Cat expectedOutput = new Cat(1L, "Bobby", 10);
		
		Mockito.when(this.repo.findById(testId)).thenReturn(mockOutputValid);
//		Mockito.when(mockOutputValid.get().setAge(updateCat.getAge())).thenReturn(mockOutputValid.get().getAge());
//		Mockito.when(mockOutputValid.get().setName(updateCat.getName())).thenReturn(mockOutputValid.get().getName());
		Mockito.when(this.repo.save(expectedOutput)).thenReturn(expectedOutput);
		
		
		
		//Change the variable -- new cat changes the variables 
		//Mockito
		
		assertEquals(expectedOutput, this.service.updateCat(expectedOutput, 1L));
		
		//Mokito.verifys
		Mockito.verify(this.repo, Mockito.times(1)).save(expectedOutput);
		Mockito.verify(this.repo, Mockito.times(1)).findById(testId);
		
		//Acually update using mockito 
		
		
		
	}
	
	
	
	
	//Do the same to the rest of the methods ==> ReadAll, Update(one or many), Delete

}
