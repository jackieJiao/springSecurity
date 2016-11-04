package com.sinoway.houtai.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


import com.sinoway.houtai.service.LoginService;


@Controller
@RequestMapping("/auth")
public class LoginController {
	@Autowired
	private LoginService loginService;
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String getLoginPage(
			@RequestParam(value = "error", required = false) boolean error, 
			ModelMap model) {

		/*logger.debug("Received request to show login page");*/

		if (error == true) {
			// Assign an error message
			model.put("error", "You have entered an invalid username or password!");
			System.out.println("error为 true");
		} else {
			model.put("error", "");
		}
		return "login";
	}
	
	@RequestMapping(value = "/denied", method = RequestMethod.GET)  
    public String getDeniedPage() {  
  
  /*      logger.debug("Received request to show denied page");  */
  
        return "denied";  
  
    }  
}
