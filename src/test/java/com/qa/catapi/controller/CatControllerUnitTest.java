package com.qa.catapi.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.catapi.models.Cat;
import com.qa.catapi.service.CatService;

@ExtendWith(SpringExtension.class)
@WebMvcTest
public class CatControllerUnitTest {
	
	@Autowired
	private MockMvc mvc;
	
	@Autowired
	private ObjectMapper mapper;

	@MockBean
	private CatService service;
	
	@Test
	public void createCatsTest() throws Exception {
		//This is essentially what Im going to be parsing in
		//Doing the same thing Ive done so far with PostMan
		Cat testCat = new Cat("Bobby Brown", 12);
		//Cat expectedCat = new Cat(1L,"Bobby Brown", 12);
		String testCatAsJSON = this.mapper.writeValueAsString(testCat);
		
		//Mimic my behaviour -- the actual a save 
		//Service 
		Mockito.when(this.service.addCat(testCat)).thenReturn(testCat);
		
	
		//Mimic the behaviour of our Postman actitivity
		//User -- On  the internet
		mvc.perform(post("/home/createCat")
				.content(testCatAsJSON)
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isCreated())
				.andExpect(content().json(testCatAsJSON));
		
		Mockito.verify(this.service, Mockito.times(1)).addCat(testCat);	
		
	}
	
	// Task I want you to do is write this into your own code and then 
	// Start creating another test in this class
}
