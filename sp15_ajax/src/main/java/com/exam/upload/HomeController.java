package com.exam.upload;

import java.io.File;
import java.io.FileInputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.exam.upload.dto.FileInfoModel;


@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	//단일 파일 업로드 폼으로 이동
	@RequestMapping("/fileUploadForm")
	public String fileUploadForm() {
		
		return "fileUploadForm";
	}

	
	//단일 업로드
	//MultipartHttpServletRequest를 이용한 업로드 파일 접근	
	@RequestMapping(value = "/fileUpload1",produces = "application/json") 
	@ResponseBody
	public HashMap<String, Object> fileUpload(MultipartHttpServletRequest request) 
																		throws Exception{
	    
		//Multipart 요청이 들어올때 내부적으로 원본 HttptServletRequest 대신 사용되는 인터페이스.
		//MultipartHttpServletRequest 인터페이스는 
		//HttpServletRequest 인터페이스와 MultipartRequest인터페이스를 상속받고있다.
		//즉 웹 요청 정보를 구하기 위한 getParameter()와 같은 메서드와 Multipart관련 메서드를 모두 사용가능.
		
		//일반 양식은 이전에 사용하던 방식과 같이 데이터를 가져올수있음
		String title = request.getParameter("title");
		String description = request.getParameter("description");
		System.out.println("타이틀:"+title);
		
		HashMap<String, Object> result = new HashMap<String, Object>();

	    //뷰에 출력한 데이터 모델에 저장
	    result.put("title", title);	    
	    result.put("description", description);
	   	   
	    return result;
	}	
}
