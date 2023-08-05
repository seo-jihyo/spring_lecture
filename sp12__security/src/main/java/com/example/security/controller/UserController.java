package com.example.security.controller;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.security.model.dao.UserDAO;
import com.example.security.service.ShaEncoder;

@Controller
public class UserController {

	@Autowired
	ShaEncoder shaEncoder;	//암호화 빈
	
	@Inject
	UserDAO userDAO;
	
	@RequestMapping("/")
	public String home(Model model) {
		
		model.addAttribute("key", "스프링 시큐리티 테스트");
		return "home"; 	//home.jsp로 이동
	}
}

