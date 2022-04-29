package com.spring;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SampleController {

	private static List<User> users = new ArrayList<User>();
	static {
		users.add(new User("Tom", "New York"));
		users.add(new User("Jerry", "Washington"));
		users.add(new User("Ivan", "London"));
	}
	
	// http://localhost:8080/contactus
	
	@GetMapping(value="contactus")
	public String contactUs(Model model) {
		model.addAttribute("users", users);
		return "contactus";// logical name of the view contactus.html
	}
}

