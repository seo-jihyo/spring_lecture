package kr.edu.kosa;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class WriteController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("title", "�����Դϴ�.");
		mav.addObject("writer", "�۾����Դϴ�.");
		mav.addObject("content", "�����Դϴ�.");
		
		mav.setViewName("write");
		return mav;
	}

}
