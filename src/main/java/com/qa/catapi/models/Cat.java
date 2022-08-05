package com.qa.catapi.models;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
//@Data
//@AllArgsConstructor
public class Cat {
	
	
	//Entitiies -- Repo will be responsible for inserting into the database
	//Id therefore does not need managment from us 
	//
	
	// Id -- Managed by javax 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long catID;
	
	//Name that is not null
	@NotNull
	private String name;
	
	//Age -- Min age = 0, Max = ...
	@Min(0)
	@Max(30)
	private int age;
	
	// This can be optional
	
	public Cat() {
		
	}
	
	
	public Cat (String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	
	public Cat(Long catID, String name, int age) {
		//What does super do?
		//Super() --- If constructor previously defined - variable will use 
		//Whats the second case? 
		
		this.catID = catID;
		this.name = name;
		this.age = age;
	}

	public Long getCatID() {
		return catID;
	}

	public void setCatID(Long catID) {
		this.catID = catID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public int hashCode() {
		return Objects.hash(age, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cat other = (Cat) obj;
		return age == other.age && Objects.equals(name, other.name);
	}

	@Override
	public String toString() {
		return "Cat [catID=" + catID + ", name=" + name + ", age=" + age + "]";
	}
	
	


	
	
	
	//Boiler Plate
	
	
	

	
	
}
