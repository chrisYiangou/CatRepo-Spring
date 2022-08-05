package com.qa.catapi.controller;

import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

@SpringBootTest
@AutoConfigureMockMvc
@Sql(scripts = {"classpath:cat-schema.sql", "classpath:cat-data.sql"}) 

@ActiveProfiles("test")
public class CatControllerIntegrationTest {
	
	//The @SQL Tag for integration testing will allow us to use a script
	
	//Integration test is -- A test that tests an entire system 
	//Functionality of just the single method --
	// What we are trying to attempt is to actually retrive/view persisted data
	
	
	

}
