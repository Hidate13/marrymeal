package com.lithan.ac.Marry_Meal.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lithan.ac.Marry_Meal.entities.Donation;
import com.lithan.ac.Marry_Meal.entities.Member;
import com.lithan.ac.Marry_Meal.entities.Registration;
import com.lithan.ac.Marry_Meal.entities.User;
import com.lithan.ac.Marry_Meal.services.DonationService;
import com.lithan.ac.Marry_Meal.services.UserService;

@Controller
public class LoginController {
	
	@Autowired
	private UserService userService;

	@Autowired
	private DonationService donataionService;
	

	//Load the Login Page
    @GetMapping("cus_login_page")
    public String onLogin() {
        return "login";
    }


    //For Login Error
    @GetMapping("login_error")
    public String onLoginError(Model model) {
        String error_msg = "Incorrect username or password. Try Again.";
        model.addAttribute("error_string", error_msg);
        return "login";
    }
    
    //For Register
    @GetMapping("new")
	public String newUserForm(Map<String, Object> model) {
    	System.out.println("new Login Controller==========>1  ");
		Registration registration = new Registration();
		model.put("registration", registration);
		return "new_user";
	}
    
    //Save register user to database
   	@PostMapping("save")
   	public String saveUser(@ModelAttribute("registration") Registration registration, Model model) {
   		System.out.println("/save Login Controller==> " + registration.getUser().getAct() +"  ==Model==  "+ model);
   		//		userService.saveMember(member, user);
   		userService.save(registration);
   		String register_success = "<h5> Registeration Successful! </h5>";
   		model.addAttribute("register_success", register_success);
   		return "new_user";
   	}
	
   	
   	
    //Update user to database
   	@PostMapping("update")
   	public String updateUser(@ModelAttribute("registration") Registration registration, Model model) {
   		System.out.println("/update Login Controller==> " + registration.getUser().getAct() +"  ==Model==  "+ model);
   		//		userService.saveMember(member, user);
   		userService.save(registration);
   		String register_success = "<h5> Registeration Successful! </h5>";
   		model.addAttribute("register_success", register_success);
   		return "redirect:/users";
   	}
	
	@GetMapping("users")
    public String viewUsers(Model model) {
        List<User> users = userService.listAll();
        if(!CollectionUtils.isEmpty(users)) {
            model.addAttribute("userlists", users);
        }
        return "all_user";
    }
	
    
    // To display update FORM with old data
 	@GetMapping("edituser")
 	public String editUserForm(@RequestParam long id, Model model) {
 		System.out.println("=================== Update users ============" + id);
 		User users = userService.get(id);
 		Member member ;
 		
 		System.out.println("users's data " +users + " ID from user is table ==> "+users.getId());
 		
 		// Create a Registration object and set the retrieved user
 	    Registration registration = new Registration();
 	    registration.setUser(users);
 	    
 	   System.out.println("<============= Test role in the users table ==========> "+ users.getAct());
		  if(users.getAct().equalsIgnoreCase("Member")){
		  System.out.println("<============= Test ID in the users table ==========> "+ users.getId());
		  
		  member = userService.getMemberUserID(users);		 
 	      registration.setMember(member);
		  }
	 			
 		System.out.println("Registration Users table " + registration.getUser().getId());
 	    // Add the Registration object to the model
 	    model.addAttribute("registration", registration);
 		return "edit_user";
 	}
    
 	
 	// Delete process
 	@GetMapping("deleteuser")
 	public String deleteUser(@RequestParam long id) {	 
 		User user = userService.get(id);
 		
 		
 		if(user.getAct().equalsIgnoreCase("Member")){
 			  System.out.println("<============= Test ID in the users table ==========> "+ user.getId());
 			  //userService.deleteByRole(user);
 			  	
 			   userService.deleteByMember(user);
 			  }
 		userService.delete(id);
 		return "redirect:/new_user";
 	}
 	
	//go to donation page
 	@GetMapping("donation")
	public String donation( Map<String, Object> model) {
    	Donation donation = new Donation();
    	System.out.println("new donation ==========>1  " + donation);
		model.put("donation", donation);
		return "donation";
	}
	
	//Save donation from donor to database
	@PostMapping("donate")
	public String donate(@ModelAttribute("donation")  Donation donation, Model model) {
		System.out.println("/save the data==> " + donation.getDonation_id() + donation.getDonorName() +"  ==Model==  "+ model);
		donation.setDonate_date_time(new Date());
		donataionService.saveDonation(donation);
		String donation_success = "<h5> Donation Successful! </h5>";
		model.addAttribute("donation_success", donation_success);
		return "donation";
	}
 	
 	
    @GetMapping("about")
    public String about() {
        return "aboutUs";
    }
    
    @GetMapping("welcome")
    public String welcome() {
        return "welcome";
    }
    
    
    @GetMapping("contact")
    public String contact() {
        return "contactUs";
    }
}
