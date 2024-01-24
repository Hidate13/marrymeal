package com.lithan.ac.Marry_Meal.services;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lithan.ac.Marry_Meal.controller.MealController;
import com.lithan.ac.Marry_Meal.daos.MealRepository;
import com.lithan.ac.Marry_Meal.entities.Meal;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class MealService {
  
	@SuppressWarnings("unused")
	private static final Logger logger = LoggerFactory.getLogger(MealController.class);

    @Autowired
    private MealRepository mealRepository;

    //Constructor
	public MealService(MealRepository meal_repo) {
		// TODO Auto-generated constructor stub
		this.mealRepository=meal_repo;
	}



	public List<Meal> getAllMeals() {
		System.out.println("In get call mall service");
        return mealRepository.findAll();
    }
    
    //used for both update and Save Meal
    public void saveMeal(Meal meal) {
       mealRepository.save(meal);
    }
    
	public Meal get(Long id) {
		return mealRepository.findById(id).get();
	}

	
	public void delete(Long id) {
		mealRepository.deleteById(id);
	}
	
	public List<Meal> search(String keyword) {
		return mealRepository.search(keyword);
		
	}


}
