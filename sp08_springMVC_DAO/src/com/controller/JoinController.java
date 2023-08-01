package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.model.MemberDAO;

@Controller
@RequestMapping("join.kosa")
public class JoinController {
	
	@Autowired
	private MemberDAO memberDAO;	//db
	
	//하나의 액션 "join.kosa"로 2개의 함수 전송방식으로 분리
//	@RequestMapping(value="join.kosa", method = RequestMethod.GET)	//get 전송방식 처리 - ui
	@RequestMapping(method=RequestMethod.GET)
	public String form() {	
		
		return "joinForm";	//views/joinform.jsp
	}
	
	
//	@RequestMapping(value="join.kosa", method=RequestMethod.POST)	//post 전송방식 처리 - db 저장 처리
	@RequestMapping(method=RequestMethod.POST)
	//form의 name과 이름 일치시키기, 이름이 다를 떄 value와 name 맞추기 /
	//String id = request.getParameter("id");
	public String submit(@RequestParam(value="id", required=true) String id, 
						 @RequestParam(value="name", required=true) String name, 
						 @RequestParam(value="pwd", required=true) String pwd, 
						 @RequestParam(value="email", required=true) String email, 
						 @RequestParam(value="age", required=true) int age) throws Exception{
		
		String viewPage = null;
		boolean joinMember = memberDAO.memberInsert(id, name, pwd, email, age);
		
		if (joinMember) viewPage = "redirect:login.kosa";
		else viewPage = "joinForm";
		
		return viewPage;
	}
}
