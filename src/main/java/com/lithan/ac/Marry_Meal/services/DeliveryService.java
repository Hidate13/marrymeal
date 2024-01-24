package com.lithan.ac.Marry_Meal.services;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lithan.ac.Marry_Meal.daos.DeliveryRepository;
import com.lithan.ac.Marry_Meal.entities.Meal;
import com.lithan.ac.Marry_Meal.entities.MealDelivery;


@Service
@Transactional
public class DeliveryService {
	@Autowired
	DeliveryRepository repo;

	public MealDelivery save(MealDelivery mealdelivery) {		
        return repo.save(mealdelivery);	
	}

	public List<MealDelivery> listAll() {
		return (List<MealDelivery>) repo.findAll();
	}

	public List<MealDelivery> listDeliveryInfo(Meal meal) {
		return (List<MealDelivery>) repo.findByMealid(meal);
	}

}
