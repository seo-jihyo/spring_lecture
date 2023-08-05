package com.kosa.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kosa.dao.BoardDAO;
import com.kosa.model.BoardVO;

@WebServlet("/board")
public class BoardController extends HttpServlet {	

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		String cmd = request.getParameter("cmd");		//~~~~/board?cmd=list 
		System.out.println("cmd: " + cmd);
		
		if (cmd.equals("list")) {
			list(request, response);
		} else if (cmd.equals("write")) {
			write(request, response);
		} else if (cmd.equals("writeForm")) {
			writeForm(request, response);
		} else if (cmd.equals("detail")) {
			detail(request, response);
		} else if (cmd.equals("update")) {
			update(request, response);
		} else if (cmd.equals("search")) {
			search(request, response);
		} else if (cmd.equals("search2")) {
			search2(request, response);
		} else if (cmd.equals("delete")) {
			delete(request, response);
		}
	}//service end

	//search (단일)
	private void search(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException { 
		String column = request.getParameter("column");
		String keyvalue = request.getParameter("keyvalue");
		
		System.out.println("column:"+column + " keyvalue:" +keyvalue);
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("column", column);
		map.put("keyvalue", keyvalue);
		
		BoardDAO dao = new BoardDAO();
		List<BoardVO> list = dao.selectSearchList(map);
		
		if (list != null) {
			request.setAttribute("list", list);
			request.getRequestDispatcher("/WEB-INF/views/searchList.jsp").forward(request, response);		
		} else {
			response.sendRedirect("/WEB-INF/views/error.jsp");
		}
	}
	
	//search2 (다중)
	private void search2(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException { 
		
		String content = request.getParameter("content");
		String writer = request.getParameter("writer");
		String title = request.getParameter("title");
		String keyvalue = request.getParameter("keyvalue");
		
		System.out.println(keyvalue);
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("content", content);
		map.put("writer", writer);
		map.put("title", title);
		map.put("keyvalue", keyvalue);
		
		BoardDAO dao = new BoardDAO();
		List<BoardVO> list = dao.selectSearchList2(map);
		
		if (list != null) {
			request.setAttribute("list", list);
			request.getRequestDispatcher("/WEB-INF/views/searchList.jsp").forward(request, response);		
		} else {
			response.sendRedirect("/WEB-INF/views/error.jsp");
		}
	}

	
	//list
	public void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		BoardDAO  dao = new BoardDAO();
		List<BoardVO> list = dao.selectAll();
		
		if(list != null) {
			request.setAttribute("list", list);//data save
			request.getRequestDispatcher("/WEB-INF/views/list.jsp").forward(request, response);
		}else {
//			response.sendRedirect("index.html");
			response.sendRedirect("/WEB-INF/views/error.jsp");
		}
	}	
	
	public void write(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String title = request.getParameter("title");
		String writer = request.getParameter("writer");
		String content = request.getParameter("content");
		
		BoardDAO dao = new BoardDAO();
		BoardVO vo = new BoardVO(title, writer, content);
		
		int result = dao.insert(vo);
		if (result == 1) {
			try {
				response.sendRedirect("board?cmd=list");
			}catch (Exception e) {
				e.printStackTrace();
			}
		}else {
			try {
				response.sendRedirect("/WEB-INF/views/error.jsp");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	
	}
	public void writeForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.getRequestDispatcher("/WEB-INF/views/writeForm.jsp").forward(request, response);		
	}
	//update
	public void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int seq = Integer.parseInt(request.getParameter("seq"));	
		String writer = request.getParameter("writer");	
		String title = request.getParameter("title");	
		String content = request.getParameter("content");	
		
		BoardDAO dao = new BoardDAO();
		BoardVO vo = new BoardVO(seq, title, writer, content);
		int count = dao.update(vo);
		if (count > 0) {
			
			response.sendRedirect("board?cmd=list");
//			list(request, response);
		}else {
			response.sendRedirect("/WEB-INF/view/error.jsp");

		}
	}
	//detail page
	public void detail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String seq = request.getParameter("seq");	//listpage에서 받아옴
		BoardDAO dao = new BoardDAO();
		BoardVO vo = dao.detailList(Integer.parseInt(seq));
		
		if (vo != null) {
			request.setAttribute("dto", vo); //받아온걸 변수에 저장
			request.getRequestDispatcher("/WEB-INF/views/detail.jsp").forward(request, response);
			
		}else {
			response.sendRedirect("/WEB-INF/view/error.jsp");
		}
		
		}

	//delete
	public void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int seq = Integer.parseInt(request.getParameter("seq"));

		BoardDAO dao = new BoardDAO();
		int count = dao.delete(seq);

		if (count > 0) {
			response.sendRedirect("board?cmd=list");
		} else {
			response.sendRedirect("/WEB-INF/views/error.jsp");
		}
	}
	
}


