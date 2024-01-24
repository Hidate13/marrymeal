package com.lithan.ac.Marry_Meal.daos;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.lithan.ac.Marry_Meal.entities.Meal;
import com.lithan.ac.Marry_Meal.entities.MealDelivery;

import java.util.List;


@Repository
public interface DeliveryRepository extends JpaRepository<MealDelivery, Long> {

	//can develop - Custom query & custom method 
	@Query( "select b from MealDelivery b where meal in :meal_id" )
	List<MealDelivery> findByMealid(@Param("meal_id") Meal meal);
}
