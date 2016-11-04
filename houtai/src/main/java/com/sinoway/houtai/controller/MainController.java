package com.sinoway.houtai.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/main")
public class MainController {
	protected static Logger logger=Logger.getLogger("controller");
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String getLoginPage(){
		logger.debug("Received request to show common page");
		return "login";  
	}
	 
	/** 
     * 跳转到commonpage页面 
     *  
     * @return 
     */  
    @RequestMapping(value = "/common", method = RequestMethod.GET)  
    public String getCommonPage() {  
        logger.debug("Received request to show common page");  
        return "q0";  
    }  
  
    /** 
     * 跳转到adminpage页面 
     *  
     * @return 
     */  
    @RequestMapping(value = "/admin", method = RequestMethod.GET)  
    public String getAadminPage() {  
        logger.debug("Received request to show admin page");  
        return "q1";  
  
    }  
    @RequestMapping(value = "/error", method = RequestMethod.GET)  
    public String geterrorPage() {  
        logger.debug("Received request to show common page");  
        return "error";  
    }  
}
