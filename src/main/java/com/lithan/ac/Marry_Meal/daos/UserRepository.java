package com.lithan.ac.Marry_Meal.daos;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lithan.ac.Marry_Meal.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
    User findByUserName(String name);
		
//	  @Query("delete from User_role u where u.user_id in :user_id " ) 
//	  User deleteByUserID(@Param("user_id") Long user);
	 
}
