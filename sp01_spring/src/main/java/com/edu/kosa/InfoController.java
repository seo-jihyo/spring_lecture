package com.edu.kosa;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class InfoController {

	@RequestMapping(value= "/info")
	public String info(Model model) {
		//�̸�, �ּ�, ����ó ������ ����ϱ�
		String name = "����ȿ";
		String phone = "010-7119-0000";
		String addr = "��⵵";
		
		model.addAttribute("name",name);
		model.addAttribute("phone",phone);
		model.addAttribute("addr",addr);
		return "info";
	}
}
