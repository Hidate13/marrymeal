package com.lithan.ac.Marry_Meal.services;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lithan.ac.Marry_Meal.controller.MealController;
import com.lithan.ac.Marry_Meal.daos.MealDeliveryRepository;
import com.lithan.ac.Marry_Meal.entities.MealDelivery;

@Service
@Transactional
public class MealDeliveryService {

	@SuppressWarnings("unused")
	private static final Logger logger = LoggerFactory.getLogger(MealController.class);

    @Autowired
    private MealDeliveryRepository mealdelRepository;

    //Constructor
	public MealDeliveryService(MealDeliveryRepository mealdel_repo) {
		// TODO Auto-generated constructor stub
		this.mealdelRepository=mealdel_repo;
	}



	public List<MealDelivery> getAllMealDeliveries() {
		System.out.println("In get call all Deliveries");
        return mealdelRepository.findAll();
    }
    
    //used for both update and Save Meal Delivery
    public void saveMealDel(MealDelivery mealdel) {
    	mealdelRepository.save(mealdel);
    }
    
	public MealDelivery get(Long id) {
		return mealdelRepository.findById(id).get();
	}

	
	public void delete(Long id) {
		mealdelRepository.deleteById(id);
	}
	
	
	  public List<MealDelivery> search(String keyword) { return
	  mealdelRepository.search(keyword);
	  
	  }
	 
}
