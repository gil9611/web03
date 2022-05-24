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


@WebServlet("/GetBoardDetailCtrl")
public class GetBoardDetailCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public GetBoardDetailCtrl() {
        super();
    }

	
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int num = Integer.parseInt(request.getParameter("num"));
    	BoardDAO dao = new BoardDAO();
    	BoardVO vo = dao.getBoard(num);
		
		request.setAttribute("vo", vo);  //요청 저장소에 담기
		RequestDispatcher view = request.getRequestDispatcher("./board/getBoardDetail.jsp");  //보내질 곳 지정
		view.forward(request, response);   //지정된 곳에 저장된 요청데이터를 전송하기
		
	}

}
