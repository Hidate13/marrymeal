package com.lithan.ac.Marry_Meal.entities;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;;

@Entity
@Table(name="donation")
public class Donation {
	
	@Id
	@Column(name="donation_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long donation_id;
	
	@Column(name="donor_name")
	private String donorName;
	
	private BigDecimal amount;
    private Date donate_date_time;
	

	//Getter and Setter
    public Long getDonation_id() {
    	return donation_id;
    }
    public void setDonation_id(Long donation_id) {
    	this.donation_id = donation_id;
    }
    
    public String getDonorName() {
    	return donorName;
    }
    public void setDonorName(String donorName) {
    	this.donorName = donorName;
    }
   
    public BigDecimal getAmount() {
    	return amount;
    }
    public void setAmount(BigDecimal amount) {
    	this.amount = amount;
    }
    public Date getDonate_date_time() {
    	return donate_date_time;
    }
    public void setDonate_date_time(Date donate_date_time) {
    	this.donate_date_time = donate_date_time;
    }
	
	
}
