package com.qa.catapi.models;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import nl.jqno.equalsverifier.EqualsVerifier;

public class CatModelUnitTest {

	// Equals Verifier -- Because we cant be bothered to test our boiler plate code
	// Hash and equals -- If you have an @Id it will fail

	static Cat testCat;

	@BeforeAll
	public static void buildCat() {
		System.out.println("Builidng Cat");
		testCat = new Cat(1L, "billy", 10);
	}

	@Test
	public void testEquals() {
		EqualsVerifier.simple().forClass(Cat.class).verify();
	}

	@Test
	public void constructors_Cat_Cat() {
		// Create Cat
		Cat catOne = new Cat();

		assertTrue(catOne instanceof Cat == true);

		Cat catTwo = new Cat("Steve", 10);

		assertTrue(catTwo instanceof Cat == true);
		assertEquals("Steve", catTwo.getName());
		assertEquals(10, catTwo.getAge());
		
//		Cat catOne = new Cat();
//
//		assertTrue(catOne instanceof Cat == true);

	}

	// Unit testing we are testing the functions in seldom
	@Test
	public void toString_String_CatInstance() {
		String expecting = "Cat [catID=" + testCat.getCatID() + ", name=" + testCat.getName() + ", age="
				+ testCat.getAge() + "]";

		assertEquals(expecting, testCat.toString());
	}

	// Test some getters and setters and test your constructor

	// Try and make your tests first -- TDD -- Code work for your tests

}
