package kr.edu.kosa;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;


public class HelloController implements Controller {
	
	private static final Logger logger = LoggerFactory.getLogger(HelloController.class);
	@Override 
//	ModelAndView : 데이터 저장 역할, 이동할 뷰페이지 등록
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		logger.info("Welcome home! hello.jsp page move");
		
		//1.
		ModelAndView mav = new ModelAndView();
		mav.addObject("nickname","망고");			// data 저장
//		mav.setViewName("/WEB-INF/views/hello.jsp");	// 이동할 페이지
		
		//2.
		mav.setViewName("hello"); ///WEB-INF/views/ + hello
		return mav;
	}

}
