package com.example.security.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

public class UserLoginFailureHandler 
	implements AuthenticationFailureHandler {
//�α����� �������� ���� ó��
	@Override
	public void onAuthenticationFailure(	HttpServletRequest request, 
									HttpServletResponse response,
									AuthenticationException exception) 
											throws IOException, ServletException {
		//request ������ ���� ����
		request.setAttribute("errMsg", "���̵� �Ǵ� ��й�ȣ�� ��ġ���� �ʽ��ϴ�.");
		//forward
		request.getRequestDispatcher("/WEB-INF/views/user/login.jsp").forward(request, response);
	}
}



