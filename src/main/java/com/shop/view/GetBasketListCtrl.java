package com.shop.view;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shop.common.BasketVO;
import com.shop.model.BasketDAO;


@WebServlet("/GetBasketListCtrl")
public class GetBasketListCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public GetBasketListCtrl() {
        super();
        
    }

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String sid = (String)session.getAttribute("sid");
		
		BasketDAO dao = new BasketDAO();
		
		ArrayList<BasketVO> list = dao.getGoodsList(sid);
		
		request.setAttribute("list", list);
		RequestDispatcher view = request.getRequestDispatcher("./basket/getBasketList.jsp");  //보내질 곳 지정
		view.forward(request, response); 
	}

}
