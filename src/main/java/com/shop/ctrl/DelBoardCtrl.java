package com.shop.ctrl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.model.BoardDAO;


@WebServlet("/DelBoardCtrl")
public class DelBoardCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public DelBoardCtrl() {
        super();
        
    }

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int seq = Integer.parseInt(request.getParameter("num"));
		
		BoardDAO dao = new BoardDAO();
		int cnt = dao.delBoard(seq);
		
		if(cnt>0) {
    		//성공
    		response.sendRedirect("GetBoardListCtrl");
    	} else {
    		//실패
    		response.sendRedirect("/GetBoardDetailCtrl?num="+seq);
    	}
	}

}
