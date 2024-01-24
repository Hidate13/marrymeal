package com.lithan.ac.Marry_Meal.services;


import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lithan.ac.Marry_Meal.daos.MemberRepository;
import com.lithan.ac.Marry_Meal.daos.RoleRepository;
import com.lithan.ac.Marry_Meal.daos.UserRepository;
import com.lithan.ac.Marry_Meal.entities.Member;
import com.lithan.ac.Marry_Meal.entities.Registration;
import com.lithan.ac.Marry_Meal.entities.User;

import java.util.HashSet;

@Service
@Transactional
public class UserService {
	@Autowired
	UserRepository repo;
	
	@Autowired
	MemberRepository memberRepo;

	@Autowired
	private RoleRepository roleRepository;

	public void save(Registration registration) {
		User user = registration.getUser();
		Member member = registration.getMember();
		
		
		//set the roles
		user.setRoles(new HashSet<>(roleRepository.findBySpecificRoles(user.getAct())));
		
		System.out.println("before write in MEMBER ====================> " + user.getAct());
		if(user.getAct() == "Member" || "Member".equals(user.getAct())) {
			//fill the member.user_id with user.id
			System.out.println("This is Update User ID => " + user.getId());	
			if(user.getId() != null) {
				Member updateMember = memberRepo.findByUserId(user);
				System.out.println("This is Update update ID => " + updateMember.getMember_id());	
				updateMember.setIllness(member.getIllness());	
				updateMember.setAddress(member.getAddress());	
				updateMember.setFoodref(member.getFoodref());
				System.out.println("This is Update getFoodref => " + updateMember.getFoodref());
				
				memberRepo.save(updateMember);
			} else {
				member.setUser_id(user);
				memberRepo.save(member);
				
			}

			//save the record for user
			
		}else if(user.getAct() == "Partner") {
			System.out.println("This is create for PARTNER ====================> " + user.getAct());	
			
		}else if(user.getAct() == "Volunteer") {
			System.out.println("This is create for VOLUNTEER ====================> " + user.getAct());	
			
		}
		
		//save the record for user
		repo.save(user);
	}

	
	public List<User> listAll() {
		return (List<User>) repo.findAll();
	}

	public User get(Long id) {
		return repo.findById(id).get();
	}
	
	public Member getMemberUserID(User users) {
		
		return memberRepo.findByUserId(users);
	}

	public void delete(Long id) {
		repo.deleteById(id);
	}
	
	
//	  public void deleteByUserID(Long user) { 
//		  repo.deleteByUserID(user);
//	  }
	 

	public User getUserByName(String username) {
		return repo.findByUserName(username);
	}


	public Member deleteByMember(User user) {
		// TODO Auto-generated method stub
		return memberRepo.deleteIdfromMember(user);
	}


	/*
	 * public User deleteByRole(User user) { // TODO Auto-generated method stub
	 * return roleRepository.deleteByUserID(user);
	 * 
	 * }
	 */


}