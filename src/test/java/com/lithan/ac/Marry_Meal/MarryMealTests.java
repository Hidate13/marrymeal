package com.lithan.ac.Marry_Meal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.lithan.ac.Marry_Meal.daos.MealRepository;
import com.lithan.ac.Marry_Meal.entities.Meal;
import com.lithan.ac.Marry_Meal.services.MealService;

@SpringBootTest
class MarryMealTests {

	@Test
	void contextLoads() {
	}
	
	@Mock
	private MealRepository meal_repo;
	
	private MealService meal_service;
	
	@BeforeEach
	void setup() {
		this.meal_service=new MealService(this.meal_repo);
		
	}
	
	//Unit Testing for meal Service
	@Test
	void TestGetAllMeals() {
		meal_service.getAllMeals();
		verify(meal_repo).findAll();
	}
	
	
	@Test
	void TestGetAllMeals_count() {
		List<Meal> listmeals=meal_service.getAllMeals();
		int meals=listmeals.size();
		System.out.println("Meal count is "+meals);
		assertEquals(1, meals);
		
	}
	
	
	
	
	
	


}
