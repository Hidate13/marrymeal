package com.lithan.ac.Marry_Meal.daos;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.lithan.ac.Marry_Meal.entities.Meal;

import java.util.List;

@Repository
public interface MealRepository extends JpaRepository<Meal, Long> {
    
	@Query("SELECT c FROM Meal c WHERE c.name LIKE CONCAT('%', :keyword, '%') OR c.meal_id LIKE CONCAT('%', :keyword, '%')")
	public List<Meal> search(@Param("keyword") String keyword);
    
}
