package com.kosa;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UpdateController {
	
//	@RequestMapping("/update.bo")		//불러오는 방법 1
	@RequestMapping(value="/update.bo",method = RequestMethod.GET)		//불러오는 방법 2
	
	public String update(Model model) {
		String name = "강감찬";
		model.addAttribute("name", name);
		model.addAttribute("update", "Update Page입니다.");
		
		return "update";		// /WEB-INF/views/update.jsp
	}
	
	/*	
	modelAndView 방법

@RequestMapping(value="/update.bo",method = RequestMethod.GET)		//불러오는 방법 2
	
	public ModelAndView update(Model model) {
	
	ModelAndView mav = new ModelAndView();
	
		String name = "강감찬";
		mav.addObject("name", name);
		mav.addObject("update", "Update Page333입니다.");
		
		mav.setViewName("update");
		
		return mav;
				// /WEB-INF/views/update.jsp
	}
	*/
}
