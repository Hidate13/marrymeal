package com.lithan.ac.Marry_Meal.daos;




import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.lithan.ac.Marry_Meal.entities.Member;
import com.lithan.ac.Marry_Meal.entities.User;

public interface MemberRepository extends JpaRepository<Member, Long> {
	  //act is variable to handle the user id
	 @Query("select m from Member m where m.user_id in :user_id")
     Member findByUserId(@Param("user_id") User users);

    
	    @Query("DELETE FROM Member m WHERE m.user_id = :user_id")
	    Member deleteIdfromMember(@Param("user_id") User users);

		/*
		 * @Query("DELETE FROM user_role m WHERE (`user_id` = '13') and (`role_id` = '2')"
		 * ) Member deleteByUserID(@Param("user_id") User users);
		 */

}
