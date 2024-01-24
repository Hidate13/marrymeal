package com.lithan.ac.Marry_Meal.entities;

import javax.persistence.*;



@Entity
@Table(name="meal")
public class Meal {
    @Id
    @Column(name="meal_id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long meal_id;


	@Column(name="name")
    private String name;

    

	private String foodReference;
   
    private String mealphoto;

    
    /* getter and setter */
    public Long getMeal_id() {
    	return meal_id;
    }
    
    public void setMeal_id(Long meal_id) {
    	this.meal_id = meal_id;
    }

    public String getName() {
		return name;
	}

	public void setName(String make) {
		this.name = make;
	}


	public String getFoodReference() {
		return foodReference;
	}
	
	public void setFoodReference(String foodReference) {
		this.foodReference = foodReference;
	}
	
	public String getMealphoto() {
		return mealphoto;
	}

	public void setMealphoto(String mealphoto) {
		this.mealphoto = mealphoto;
	}

}
