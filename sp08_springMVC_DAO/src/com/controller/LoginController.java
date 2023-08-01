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
	
	@Autowired //�ڵ�����
	private MemberDAO memberDAO;

	@RequestMapping(method=RequestMethod.GET) //login.kosa �߿��� get���� ���°͵�
	public String form() {
		return "loginForm";		// /web-inf/views/ + loginForm +.jsp
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String submit(@RequestParam(value="id") String id,
						 @RequestParam(value="pwd") String pwd,
						//Session ��ü�� ��� (�α��� ����)
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
