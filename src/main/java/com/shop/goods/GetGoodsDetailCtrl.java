package com.shop.goods;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.common.GoodsVO;
import com.shop.model.GoodsDAO;


@WebServlet("/GetGoodsDetailCtrl")
public class GetGoodsDetailCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public GetGoodsDetailCtrl() {
        super();
        
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int code = Integer.parseInt(request.getParameter("code"));
		
		GoodsDAO dao = new GoodsDAO();
		GoodsVO vo = dao.getGoods(code); 
		
		request.setAttribute("vo", vo);  //요청 저장소에 담기
		RequestDispatcher view = request.getRequestDispatcher("./goods/getGoodsDetail.jsp");  //보내질 곳 지정
		view.forward(request, response);   //지정된 곳에 저장된 요청데이터를 전송하기
	}

}
