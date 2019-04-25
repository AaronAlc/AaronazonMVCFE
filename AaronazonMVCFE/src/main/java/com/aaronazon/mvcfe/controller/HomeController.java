package com.aaronazon.mvcfe.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {

	final static Logger logger = org.apache.log4j.Logger.getLogger(HomeController.class);

	// home page
	@RequestMapping
	public String getHomePage() {
		logger.debug("Getting home page");
		return "home/home";
	}

	// item management page
	@RequestMapping("items")
	public String getItemMangementPage() {
		logger.debug("Getting controller item Page");
		return "item/item_management";
	}

}