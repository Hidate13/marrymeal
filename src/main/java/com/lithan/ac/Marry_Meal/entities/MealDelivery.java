package com.lithan.ac.Marry_Meal.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="meal_delivery")
public class MealDelivery {
    @Id
    @Column(name="delivery_id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long delivery_id;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "meal_id")
    private Meal meal_id;
    
    @Column(name="delivery_date_time")
    private Date delivery_date_time;
    private boolean approval;
    private boolean on_delivery;
    
    private String member_name; // username
    private String illness;
	private String foodref;
	private String address;
	private String isfrozen;
    


	public MealDelivery() {
    }

	// getter & setter
	
	
	public Meal getMeal_id() {
		return meal_id;
	}
	
	public void setMeal_id(Meal meal_id) {
		this.meal_id = meal_id;
	}
	
	public Date getDeliver_date_time() {
		return delivery_date_time;
	}
	
	public void setDelivery_date_time(Date delivery_date_time) {
		this.delivery_date_time = delivery_date_time;
	}
	
    public Long getDelivery_id() {
        return delivery_id;
    }

    public void setDelivery_id(Long id) {
        this.delivery_id = id;
    }

	public String getMember_name() {
		return member_name;
	}

	public void setMember_name(String member_name) {
		this.member_name = member_name;
	}


	public String getIllness() {
		return illness;
	}

	public void setIllness(String illness) {
		this.illness = illness;
	}

	public String getFoodref() {
		return foodref;
	}

	public void setFoodref(String foodref) {
		this.foodref = foodref;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public boolean  getApproval() {
		return approval;
	}
	
	public void setApproval(boolean  approval) {
		this.approval = approval;
	}
	
	public boolean isOn_delivery() {
		return on_delivery;
	}

	public void setOn_delivery(boolean on_delivery) {
		this.on_delivery = on_delivery;
	}

	public String getIsfrozen() {
		return isfrozen;
	}

	public void setIsfrozen(String isfrozen) {
		this.isfrozen = isfrozen;
	}


  
	     
}
