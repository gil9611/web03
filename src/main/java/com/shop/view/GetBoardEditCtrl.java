package com.shop.view;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.common.BoardVO;
import com.shop.model.BoardDAO;


@WebServlet("/GetBoardEditCtrl")
public class GetBoardEditCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public GetBoardEditCtrl() {
        super();
    }


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int num = Integer.parseInt(request.getParameter("num"));
    	BoardDAO dao = new BoardDAO();
    	BoardVO vo = dao.getBoard(num);
		
		request.setAttribute("vo", vo); 
		RequestDispatcher view = request.getRequestDispatcher("./board/getBoardEdit.jsp");
		view.forward(request, response);   
	}

}
