package com.shop.basket;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shop.common.BasketVO;
import com.shop.common.GoodsVO;
import com.shop.model.BasketDAO;
import com.shop.model.GoodsDAO;




@WebServlet("/InsertBasketCtrl")
public class InsertBasketCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public InsertBasketCtrl() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String sid = (String) session.getAttribute("sid");
		
		int gcode = Integer.parseInt(request.getParameter("gcode"));
		
		GoodsDAO gdao = new GoodsDAO();
		GoodsVO gvo = gdao.getGoods(gcode);
		BasketDAO bdao = new BasketDAO();
		BasketVO bvo = new BasketVO();
		
		bvo.setBid(sid);
		bvo.setBcode(gvo.getGcode());
		bvo.setBname(gvo.getGname());
		bvo.setBprice(gvo.getGprice());
		bvo.setBcolor(gvo.getGcolor());
		bvo.setBsize(gvo.getGsize());
		bvo.setBmaterial(gvo.getGmeterial());
		bvo.setBorder(1);
		
		int cnt = bdao.insertBasket(bvo);
		
		if(cnt>0) {
			//성공
			response.sendRedirect("GetGoodsListCtrl");
		}else {
			//실패
			response.sendRedirect("GetGoodsDetailCtrl?code="+gcode);
		}
	}


}
