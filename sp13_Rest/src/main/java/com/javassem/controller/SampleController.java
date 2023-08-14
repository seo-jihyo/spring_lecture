package com.javassem.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
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
		SampleVO vo = new SampleVO("김연아", 33, "우리는 지금 레스트 테스트", "000","1");
		model.addAttribute("vo", vo);
		return vo;
	}
	
	//3. 배열형 반환 - 리스트 객체 반환
	@GetMapping(value="/getList")
	public List<SampleVO> getList() {

		List list = new ArrayList();
		list.add(new SampleVO("김연아", 33, "우리는 지금 레스트 테스트","000","1"));
		list.add(new SampleVO("서지효", 11, "우리는 지금 레스트 테스트 22","000","1"));
		list.add(new SampleVO("망고", 1, "우리는 고양이","000","1"));
		
		return list;
	}
	//4. URL에서 정보 얻기 /sample/{category}/{no}
	@GetMapping(value="/sample/{cate}/{cno}")
	public String[] getPath(@PathVariable String cate, @PathVariable Integer cno){
		return new String[] {"카테고리: " + cate, "번호: " + cno};
	}
//	http://localhost:8080/rest/query-param?name=aa&age=99&message=hello&phoneNumber=01010101010
	@GetMapping(path="query-param") //GetMapping("/query-param")
	public String queryParam(
			@RequestParam String name,
			@RequestParam String age,
			@RequestParam String message,
			@RequestParam String phoneNumber,
			@RequestParam String PINNUMBER
			) {
		System.out.println(name);
		System.out.println(age);
		System.out.println(message);
		System.out.println(phoneNumber);
		System.out.println(PINNUMBER);
		
		return name +", "+ age +", "+ message + ", " + phoneNumber + ", " + PINNUMBER;
	}
//	http://localhost:8080/rest/query-param2?name=aa&age=99&message=hello
	@GetMapping(path="query-param2")
	public String queryParam2(SampleVO dto) {  //객체타입으로 리턴할 때는 @RequestParam 안 씀. 권장하는 방식
		System.out.println(dto.getMessage());
		System.out.println(dto.getName());
		System.out.println(dto.getAge());
		System.out.println(dto.getPhoneNumber());
		System.out.println(dto.getPINNUMBER());
		
		return dto.toString();
	}
	//5. POST 전송
	@PostMapping(value = "/sample/data")
	public SampleVO post(@RequestBody SampleVO vo) {
						//body에 담아옴
		System.out.println(vo);
		
		System.out.println("[확인]");
		return vo;
	}
	
	//post로 받을 때 map 형식 가능
	@PostMapping("/post")
	public void postSample(@RequestBody Map<String, Object> vo) {
		vo.forEach((key,value)->{
			System.out.println("key:" + key);
			System.out.println("value:" + value);
		});
	}
	@DeleteMapping("/sample/delete/{name}")
	//변수처리는 브라켓안에 써서 넘기기 http://localhost:8080/rest/sample/delete/jihyo
	public void delete(@PathVariable String name) {
		System.out.println(name);
		
	}
	@PutMapping("/sample/put-name/{name}")
	public SampleVO put(@RequestBody SampleVO dto, @PathVariable(name= "name")String irum) {
		System.out.println(irum);
		return dto;
	}
}
