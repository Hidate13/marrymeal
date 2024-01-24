package com.lithan.ac.Marry_Meal.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lithan.ac.Marry_Meal.controller.LoginController;
import com.lithan.ac.Marry_Meal.daos.DonationRepository;
import com.lithan.ac.Marry_Meal.entities.Donation;

@Service
@Transactional
public class DonationService {
	@SuppressWarnings("unused")
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private DonationRepository donationRepo;

    //Constructor
	public DonationService(DonationRepository donation_repo) {
		// TODO Auto-generated constructor stub
		this.donationRepo=donation_repo;
	}


	public List<Donation> getAllDonation() {
		System.out.println("In get call mall service");
        return donationRepo.findAll();
    }
    
    //used for both update and Save donation
    public void saveDonation(Donation donation) {
    	donationRepo.save(donation);
    }
    
	public Donation get(Long id) {
		return donationRepo.findById(id).get();
	}

	
	public void delete(Long id) {
		donationRepo.deleteById(id);
	}
	



}
