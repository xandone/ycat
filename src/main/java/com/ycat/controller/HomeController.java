package com.ycat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	@RequestMapping("/")
	public String showIndex() {
		return "html/index.html";
	}

	@RequestMapping("/{page}")
	public String showPage(@PathVariable String page) {
		return page;
	}
	
}
