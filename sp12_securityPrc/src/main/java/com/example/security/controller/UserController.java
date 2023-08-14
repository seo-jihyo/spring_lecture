package com.example.security.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.security.model.dao.UserDAO;
import com.example.security.service.ShaEncoder;

@Controller
public class UserController {

	@Autowired
	ShaEncoder shaEncoder;	//암호화 빈
	UserDAO userDAO;
	
	
	@RequestMapping("/")
	public String home(Model model) {
		
		model.addAttribute("key", "스프링 시큐리티 테스트");
		return "home"; 	//home.jsp로 이동
	}
	
	//로그인 페이지로 이동
	@RequestMapping("/user/login.do")
	public String login() {
		return "user/login";	//user/login.jsp
	}
 
	//회원가입 페이지로 이동
	@RequestMapping("/user/join.do")
	public String join() {
		return "user/join";		//user/join.jsp
	}
	//회원가입 처리
	@RequestMapping("/user/insertUser.do")
	public String insertUser(@RequestParam String userid,
							@RequestParam String pwd,
							@RequestParam String role
			) {//@RequestParam으로 받음(jsp의 필드name과 맞춰준다.)
															
	
		//비밀번호 암호화
		String dbpw = shaEncoder.saltEncoding(pwd, userid);
		Map<String , String> map = new HashMap();
		map.put("userid", userid);
		map.put("passwd", dbpw);
		map.put("authority", role);
	
		int result = userDAO.insertUser(map); //xml에서 mapping method가 insert
		
		return "user/login";		//회원가입 후 로그인 페이지로
	}
	//관리자 영역 페이지
	@RequestMapping("/admin/")
	public String admin() {
		return "admin/main";		//user/join.jsp
	}
	
	@RequestMapping("/user/")
	public String user() {
		return "user/userMain";		
	}

}

