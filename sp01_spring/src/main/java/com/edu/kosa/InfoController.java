package com.edu.kosa;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class InfoController {

	@RequestMapping(value= "/info")
	public String info(Model model) {
		//이름, 주소, 연락처 데이터 출력하기
		String name = "서지효";
		String phone = "010-7119-0000";
		String addr = "경기도";
		
		model.addAttribute("name",name);
		model.addAttribute("phone",phone);
		model.addAttribute("addr",addr);
		return "info";
	}
}
