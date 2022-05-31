package com.shop.basket;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.model.BasketDAO;




@WebServlet("/DelBasketCtrl")
public class DelBasketCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public DelBasketCtrl() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int bno = Integer.parseInt(request.getParameter("bno"));
		BasketDAO dao = new BasketDAO();
		
		int cnt = dao.delBasket(bno);
		
		
		if(cnt>0) {
			//성공
			response.sendRedirect("GetBasketListCtrl");
		}else {
			//실패
			response.sendRedirect("GetBasketListCtrl");
		}
	}

}
