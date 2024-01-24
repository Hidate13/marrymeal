package com.lithan.ac.Marry_Meal.daos;



import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import com.lithan.ac.Marry_Meal.entities.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long>{
	
	@Query( "select r from Role r where r.name in :roles" )
	Set<Role> findBySpecificRoles(@Param("roles") String role);
	
	
	
	
	/*
	 * @Query("DELETE FROM User_role m WHERE user_id in :user_id " ) User
	 * deleteByUserID(@Param("user_id") User user);
	 */
	  
	  
	 
}