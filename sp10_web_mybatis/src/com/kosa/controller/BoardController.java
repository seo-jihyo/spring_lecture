package com.kosa.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kosa.dao.BoardDAO;
import com.kosa.model.BoardVO;

@WebServlet("/board")
public class BoardController extends HttpServlet {	

	public BoardController() {
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		String cmd = request.getParameter("cmd");		//~~~~?cmd=list 
		System.out.println("cmd: " + cmd);
		
		if (cmd.equals("list")) {
			list(request, response);
		} else if (cmd.equals("write")) {
			write(request, response);
		} else if (cmd.equals("writeForm")) {
			writeForm(request, response);
		}
	}//service end


	private void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
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
		
		dao.insert(vo);
		
	}
	private void writeForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.getRequestDispatcher("/WEB-INF/views/writeForm.jsp").forward(request, response);		
	}

}
