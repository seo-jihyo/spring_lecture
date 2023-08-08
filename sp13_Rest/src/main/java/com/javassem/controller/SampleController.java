package com.javassem.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.javassem.domain.SampleVO;

@RestController
public class SampleController {

	//1. 문자열 반환
	@GetMapping(value = "/getText", produces = "text/plain; charset=UTF-8")
//	@ResponseBody (@controller일떄)
	public String getTest() {
		return "컨트롤러에서 보냈음";
	}
	
	//2.객체 반환
	@GetMapping(value="/getObject")
	public SampleVO getObject(Model model) {
		SampleVO vo = new SampleVO("김연아", 33, "우리는 지금 레스트 테스트");
		model.addAttribute("vo", vo);
		return vo;
	}
	
	//3. 배열형 반환 - 리스트 객체 반환
	@GetMapping(value="/getList")
	public List<SampleVO> getList() {

		List list = new ArrayList();
		list.add(new SampleVO("김연아", 33, "우리는 지금 레스트 테스트"));
		list.add(new SampleVO("서지효", 11, "우리는 지금 레스트 테스트 22"));
		list.add(new SampleVO("망고", 1, "우리는 고양이"));
		
		return list;
	}
	//4. URL에서 정보 얻기 /sample/{category}/{no}
	@GetMapping(value="/sample/{cate}/{cno}")
	public String[] getPath(@PathVariable String cate, @PathVariable Integer cno){
		return new String[] {"카테고리: " + cate, "번호: " + cno};
		
	}
	
	//5. POST 전송
	@PostMapping(value = "/sample/data")
	public SampleVO post(@RequestBody SampleVO vo) {
						//body에 담아옴
		System.out.println(vo);
		
		System.out.println("[확인]");
		return vo;
		
		
	}
}
