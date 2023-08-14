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
	ShaEncoder shaEncoder;	//��ȣȭ ��
	UserDAO userDAO;
	
	
	@RequestMapping("/")
	public String home(Model model) {
		
		model.addAttribute("key", "������ ��ť��Ƽ �׽�Ʈ");
		return "home"; 	//home.jsp�� �̵�
	}
	
	//�α��� �������� �̵�
	@RequestMapping("/user/login.do")
	public String login() {
		return "user/login";	//user/login.jsp
	}
 
	//ȸ������ �������� �̵�
	@RequestMapping("/user/join.do")
	public String join() {
		return "user/join";		//user/join.jsp
	}
	//ȸ������ ó��
	@RequestMapping("/user/insertUser.do")
	public String insertUser(@RequestParam String userid,
							@RequestParam String pwd,
							@RequestParam String role
			) {//@RequestParam���� ����(jsp�� �ʵ�name�� �����ش�.)
															
	
		//��й�ȣ ��ȣȭ
		String dbpw = shaEncoder.saltEncoding(pwd, userid);
		Map<String , String> map = new HashMap();
		map.put("userid", userid);
		map.put("passwd", dbpw);
		map.put("authority", role);
	
		int result = userDAO.insertUser(map); //xml���� mapping method�� insert
		
		return "user/login";		//ȸ������ �� �α��� ��������
	}
	//������ ���� ������
	@RequestMapping("/admin/")
	public String admin() {
		return "admin/main";		//user/join.jsp
	}
	
	@RequestMapping("/user/")
	public String user() {
		return "user/userMain";		
	}

}

