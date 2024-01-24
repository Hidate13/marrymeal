package com.lithan.ac.Marry_Meal.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.lithan.ac.Marry_Meal.entities.Meal;
import com.lithan.ac.Marry_Meal.entities.MealDelivery;
import com.lithan.ac.Marry_Meal.entities.Member;
import com.lithan.ac.Marry_Meal.entities.Registration;
import com.lithan.ac.Marry_Meal.entities.User;
import com.lithan.ac.Marry_Meal.services.DeliveryService;
import com.lithan.ac.Marry_Meal.services.MealDeliveryService;
import com.lithan.ac.Marry_Meal.services.MealService;
import com.lithan.ac.Marry_Meal.services.UserService;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

@Controller
public class MealController {

	private static final String UPLOAD_DIRECTORY = "/images";
	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(MealController.class);

	@Autowired
	private MealService mealService;

	@Autowired
	private DeliveryService deliveryService;
	
	@Autowired
	private MealDeliveryService mealdelservice;
	
	@Autowired
	private UserService userService;
	

	@GetMapping("/")
	public String handleRootRequest(Model model) {
		return "redirect:welcome";
	}

	// For Display all meal
	@GetMapping("meals")
	public String viewMeals(Model model) {
		List<Meal> meals = mealService.getAllMeals();
		if (!CollectionUtils.isEmpty(meals)) {
			model.addAttribute("meals", meals);
		}
		return "view_meals";
	}

	// For display new meal FORM
	@GetMapping("new_meal")
	public String newUserForm(Map<String, Object> model) {
		System.out.println("To show add new meal page");
		Meal meal = new Meal();
		model.put("meal", meal);
		return "new_meal";
	}

	// For saving new meal
	@PostMapping("meal")
	public String saveMeal(Meal meal, @RequestParam("file") MultipartFile file, HttpSession session, Model model)
			throws Exception {

		System.out.println("get Meal Name");
		// Get the file name & set the file name
		String mealphotoname = file.getOriginalFilename();
		System.out.println("Meal photo name is " + mealphotoname);

		if (mealphotoname != null && !mealphotoname.trim().isEmpty()) {
			meal.setMealphoto(mealphotoname);

			// Upload Meal Photo
			ServletContext context = session.getServletContext();
			String path = context.getRealPath(UPLOAD_DIRECTORY);
			String filename = file.getOriginalFilename();

			System.out.println(path + " " + filename);
			byte[] bytes = file.getBytes();
			BufferedOutputStream stream = new BufferedOutputStream(
					new FileOutputStream(new File(path + File.separator + filename)));
			stream.write(bytes);
			stream.flush();
			stream.close();

			System.out.println("File successfully saved!");
			// End Upload Meal Photo
		}
		// end of file upload
		

		System.out.println("Save & Update new meal");
		mealService.saveMeal(meal);
		return "redirect:meals";
	}

	// For saving new order by member
	@GetMapping("order")
	public String orderMeal(Meal meal, Registration registration, @RequestParam long id, HttpSession session, Model model) throws Exception {
		meal = mealService.get(id);
		MealDelivery mealdelivery= new MealDelivery();
		Member member;
		User user;
		// Get the currently user from JSP
	    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

	    // Get the username.
	    String currUser = authentication.getName();
	    
	    //setting the Member and User
	    user = userService.getUserByName(currUser);
	    registration.setUser(user);
	    member = userService.getMemberUserID(user);		 
	    registration.setMember(member);
	    
	    
	    String username = registration.getUser().getUserName();
	    System.out.println("user.userName ==============>  " + registration.getUser().getUserName()+" OR " + username);
	    System.out.println("user.userName ==============>  " + registration.getMember().getUser_id()+" OR " + member);
	    
	    
	    System.out.println("Checking member Name========> " + currUser);
	    
	    System.out.println("Checking member ref========> " + username);
	    if(username.equalsIgnoreCase(currUser) || username != "") {
	    	System.out.println("get member ref========> " + username);
	    	mealdelivery.setIllness(registration.getMember().getIllness());
	    	mealdelivery.setFoodref(registration.getMember().getFoodref());
	    	mealdelivery.setAddress(registration.getMember().getAddress());    	
	    }else {
	    	System.out.println("Failed to get member ref========> " + username);
	    	mealdelivery.setIllness("");
	    	mealdelivery.setFoodref("");
	    	mealdelivery.setAddress("");    	
	    	
	    }
	    
	    
	    System.out.println("Authenticated user: " + currUser );
	    mealdelivery.setMeal_id(meal);
	    mealdelivery.setMember_name(currUser);
        mealdelivery.setDelivery_date_time(new Date());
        mealdelivery.setApproval(false);
		//	    System.out.println("get Meal Name: " + meal.getName() + " -> meal id: " + meal.getMeal_id());
		//	    System.out.println("get MealDelivery Name: " + mealdelivery.getMember_name() + " -> MealDelivery id: " + mealdelivery.getMeal_id());
		//	    System.out.println("get Meal Date: " + mealdelivery.getDeliver_date_time());
		//		System.out.println("Save & Update new meal" + mealdelservice );
		mealdelservice.saveMealDel(mealdelivery);
		String order_success = "<h5> Order Successful! </h5>";
		model.addAttribute("order_success", order_success);
		return "redirect:meals";
	}
	
	@GetMapping("approvalMeal")
	public String approveMeal(@RequestParam long id, @RequestParam String isFrozen, Model model) {
	    MealDelivery mealDelivery = mealdelservice.get(id);
	    Boolean approved = mealDelivery.getApproval();
	    String getIsFrozen = isFrozen;
	    System.out.println("1=========> " + getIsFrozen  + " < ============= "+ isFrozen);
	    
	    
	    
	    if(getIsFrozen.isEmpty() || getIsFrozen == null || getIsFrozen.equals("") || getIsFrozen.equals("no")) {
			mealDelivery.setIsfrozen("no");
		}else {
			mealDelivery.setIsfrozen("yes");
		}

		System.out.println("================>1 " + approved );
	    if(approved == false) {
	    	System.out.println("================>2 " + approved );
	    	mealDelivery.setApproval(true);	
	    } else {
	    	System.out.println("================>3	 " + approved );
	    	mealDelivery.setApproval(false);	    	
	    }
	    mealdelservice.saveMealDel(mealDelivery);

	    return "redirect:delivery";
	}
	


	// To display meal detail (not used)
	@GetMapping("meal_detail")
	public ModelAndView viewMeal(@RequestParam long id) {
		ModelAndView mav = new ModelAndView("meal_detail");
		Meal meal = mealService.get(id);
		mav.addObject("meal", meal);
		mav.addObject("deliveryinfo", deliveryService.listDeliveryInfo((meal)));
		return mav;
	}
	
	
	
	@GetMapping("delivery")
    public String delivery(Model model) {
		List<MealDelivery> delivery = mealdelservice.getAllMealDeliveries();
		List<Meal> meal = mealService.getAllMeals();

		System.out.println("===========> "+ delivery.toString());
		System.out.println("===========> "+ meal.toString());
        if(!CollectionUtils.isEmpty(meal) && !CollectionUtils.isEmpty(delivery)) {
        	
        	model.addAttribute("delivery", delivery);
            model.addAttribute("meals", meal);
        }
	
        return "delivery";
    }
	
	@GetMapping("volunteer")
    public String volunteer(Model model) {
		List<MealDelivery> delivery = mealdelservice.getAllMealDeliveries();
		List<Meal> meal = mealService.getAllMeals();

		System.out.println("===========> "+ delivery.toString());
		System.out.println("===========> "+ meal.toString());
        if(!CollectionUtils.isEmpty(meal) && !CollectionUtils.isEmpty(delivery)) {
        	
        	model.addAttribute("delivery", delivery);
            model.addAttribute("meals", meal);
        }
	
        return "volunteer";
    }
	
	
	
	@GetMapping("take_over")
    public String takeover(Meal meal, Registration registration, @RequestParam long id, HttpSession session, Model model) throws Exception {

	    MealDelivery mealDelivery = mealdelservice.get(id);
	    Boolean takeOver = mealDelivery.isOn_delivery();

		Member member;
		User user;
	    
	    // Get the currently user from JSP
	    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

	    // Get the username.
	    String currUser = authentication.getName();
	    
	    //setting the Member and User
	    user = userService.getUserByName(currUser);
	    registration.setUser(user);
	    member = userService.getMemberUserID(user);		 
	    registration.setMember(member);

		System.out.println("================>1 " + takeOver );
	    if(takeOver == false) {
	    	System.out.println("================>2 " + takeOver );
	    	mealDelivery.setOn_delivery(true);	
	    } else {
	    	System.out.println("================>3	 " + takeOver );
	    	mealDelivery.setOn_delivery(false);	    	
	    }
	    
	    
	    mealdelservice.saveMealDel(mealDelivery);	

		return "redirect:volunteer";
    }

	// Save the Rider to meal delivery table
	@PostMapping("meal_detail")
	public String saveDelivery(@RequestParam(value = "id", required = false) Long id,
			@RequestParam("Approved") String approved, Model model) {
				System.out.println("try to load Delivery ");
				return approved;
	}
	

	// To display update FORM with old data
	@GetMapping("edit")
	public String editMealForm(@RequestParam long id, Model model) {
		System.out.println("Update meal controller method");
		Meal meal = mealService.get(id);
		model.addAttribute("meal", meal);
		return "new_meal";
	}

	// Delete process
	@GetMapping("delete")
	public String deleteMeal(@RequestParam long id) {
		mealService.delete(id);
		return "redirect:/meals";
	}

	@GetMapping("search")
	public ModelAndView search(@RequestParam String keyword) {
		System.out.println("test nest search=======> " + keyword);
		List<Meal> result = mealService.search(keyword);
		ModelAndView mav = new ModelAndView("search_meal_results");
		mav.addObject("keyword", keyword);
		mav.addObject("search_meals", result);
		return mav ;
	}

}
