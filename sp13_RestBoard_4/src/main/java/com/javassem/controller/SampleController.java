package com.javassem.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.javassem.domain.SampleVO;

//@Controller
@RestController
public class SampleController {

    //1. 문자열 반환
//    @ResponseBody
    @GetMapping(value="/getText", produces = "text/plain; charset=UTF-8")
    public String getTest() {
        return "컨트롤러에서 보냈어요!";
    }

    //2. 객체 반환
    @GetMapping("/getObject")
    public SampleVO getObject(Model model){
        SampleVO vo = new SampleVO("김연아", 33, "우리는 지금 레스트 테스트");
        model.addAttribute("vo",vo);
        return vo;
    }

    //3. 리스트 객체 반환
    @GetMapping("/getList")
    public List<SampleVO> getList(){
        List<SampleVO> list = new ArrayList<>();
        list.add(new SampleVO("김연아", 33, "우리는 지금 레스트 테스트"));
        list.add(new SampleVO("박태환", 22, "수영선수"));
        list.add(new SampleVO("세종대왕", 7, "한글창제"));
        return list;
    }

    //4. URL 에서 정보 얻기 /sample/{cate}/{no}
    @GetMapping(value="/sample/{cate}/{cno}")
//    public String[] getPath(String cate, Integer cno){
        public String[] getPath(@PathVariable String cate, @PathVariable Integer cno){
        return new String[]{"카테고리 : "+cate, "번호:" + cno};
    }
    
    @PostMapping(value = "/sample/data")
    public SampleVO post(@RequestBody SampleVO vo) {
    	System.out.println(vo);
    	System.out.println("[확인]");
    	return vo;
    }
    
    @PostMapping("/post")
    public void postSample(@RequestBody Map<String, Object> map) {
    	//map.entrySet().forEach(objEntry ->{
    	//	System.out.println("key : " + objEntry.getKey());
    	//	System.out.println("value : " + objEntry.getValue());
    	//});
    	
    	map.forEach((key, value) ->{
        	System.out.println("key : " + key);
        	System.out.println("value : " + value);
        });
    }
    
    @GetMapping(path = "/query-param")
    public String queryParam2(SampleVO dto) {
    	System.out.println(dto.getName());
    	System.out.println(dto.getMessage());
    	System.out.println(dto.getAge());
    	
    	return dto.toString();
    }
    
    @DeleteMapping("/sample/delete/{name}")
    public void delete(@PathVariable String name) {
    	System.out.println(name);
    }
}