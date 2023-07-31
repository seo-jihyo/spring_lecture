package com.kosa;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UpdateController {
	
//	@RequestMapping("/update.bo")		//�ҷ����� ��� 1
	@RequestMapping(value="/update.bo",method = RequestMethod.GET)		//�ҷ����� ��� 2
	
	public String update(Model model) {
		String name = "������";
		model.addAttribute("name", name);
		model.addAttribute("update", "Update Page�Դϴ�.");
		
		return "update";		// /WEB-INF/views/update.jsp
	}
	
	/*	
	modelAndView ���

@RequestMapping(value="/update.bo",method = RequestMethod.GET)		//�ҷ����� ��� 2
	
	public ModelAndView update(Model model) {
	
	ModelAndView mav = new ModelAndView();
	
		String name = "������";
		mav.addObject("name", name);
		mav.addObject("update", "Update Page333�Դϴ�.");
		
		mav.setViewName("update");
		
		return mav;
				// /WEB-INF/views/update.jsp
	}
	*/
}
