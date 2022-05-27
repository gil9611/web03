package com.shop.goods;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.common.GoodsVO;
import com.shop.model.GoodsDAO;



@WebServlet("/GetGoodsListCtrl")
public class GetGoodsListCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public GetGoodsListCtrl() {
        super();
        
    }


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		GoodsDAO dao = new GoodsDAO();
		ArrayList<GoodsVO> list = dao.getGoodsList();
		
		request.setAttribute("list", list);  //요청 저장소에 담기
		RequestDispatcher view = request.getRequestDispatcher("./goods/getGoodsList.jsp");  //보내질 곳 지정
		view.forward(request, response);   //지정된 곳에 저장된 요청데이터를 전송하기
	}

}
