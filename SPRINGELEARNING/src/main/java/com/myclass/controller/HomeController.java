package com.myclass.controller;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("home")
@Scope("prototype")
public class HomeController {

	@GetMapping()
	public String index() {
		return "home/index";
	}
	@GetMapping("/details")
	public String details() {
		return "home/details";
	}
}
