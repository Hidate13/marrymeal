package com.lithan.ac.Marry_Meal.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.lithan.ac.Marry_Meal.entities.MealDelivery;

@Repository
public interface MealDeliveryRepository extends JpaRepository<MealDelivery, Long> {
	
	
	  @Query("SELECT c FROM MealDelivery c WHERE c.member_name LIKE CONCAT('%', :keyword, '%') OR c.meal_id LIKE CONCAT('%', :keyword, '%')"
	  ) public List<MealDelivery> search(@Param("keyword") String keyword);
	  
	 
}
