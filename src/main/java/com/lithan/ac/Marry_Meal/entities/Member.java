package com.lithan.ac.Marry_Meal.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "member")
public class Member {

	@Id
	@Column(name = "member_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long member_id;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id")
	private User user_id;
	
	private String illness;
	private String foodref;
	private String address;


	/* getter and setter */
	public Long getMember_id() {
		return member_id;
	}

	public void setMember_id(Long member_id) {
		this.member_id = member_id;
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

	public User getUser_id() {
		return user_id;
	}

	public void setUser_id(User user_id) {
		this.user_id = user_id;
	}


	
}
