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
	
	//�ϳ��� �׼� "join.kosa"�� 2���� �Լ� ���۹������ �и�
//	@RequestMapping(value="join.kosa", method = RequestMethod.GET)	//get ���۹�� ó�� - ui
	@RequestMapping(method=RequestMethod.GET)
	public String form() {	
		
		return "joinForm";	//views/joinform.jsp
	}
	
	
//	@RequestMapping(value="join.kosa", method=RequestMethod.POST)	//post ���۹�� ó�� - db ���� ó��
	@RequestMapping(method=RequestMethod.POST)
	//form�� name�� �̸� ��ġ��Ű��, �̸��� �ٸ� �� value�� name ���߱� /
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
