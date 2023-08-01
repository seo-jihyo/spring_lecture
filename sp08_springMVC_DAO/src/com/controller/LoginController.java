package com.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.model.MemberDAO;

@Controller
@RequestMapping("/login.kosa") 
public class LoginController {
	
	@Autowired //자동주입
	private MemberDAO memberDAO;

	@RequestMapping(method=RequestMethod.GET) //login.kosa 중에서 get으로 들어온것들
	public String form() {
		return "loginForm";		// /web-inf/views/ + loginForm +.jsp
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String submit(@RequestParam(value="id") String id,
						 @RequestParam(value="pwd") String pwd,
						//Session 객체를 얻기 (로그인 유지)
						HttpSession session ) throws Exception {
		String viewPage = null;
		boolean isMember = memberDAO.memberCheck(id, pwd);
		
		if (isMember) {
			session.setAttribute("USERID", id);	//data save
			viewPage = "loginSuccess";			
		} else {
			viewPage = "loginForm";
		}
		return viewPage;
	}
}
