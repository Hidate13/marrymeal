package com.lithan.ac.Marry_Meal.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lithan.ac.Marry_Meal.entities.Donation;

public interface DonationRepository extends JpaRepository<Donation, Long> {

}
