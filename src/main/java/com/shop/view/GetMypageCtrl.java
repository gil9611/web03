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

import com.shop.common.MemberVO;
import com.shop.model.MemberDAO;

@WebServlet("/GetMypageCtrl")
public class GetMypageCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public GetMypageCtrl() {
        super();
      
    }


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String sid = (String) session.getAttribute("sid");
		
		MemberDAO dao = new MemberDAO();
		MemberVO vo = dao.JSONMember(sid);
		
		request.setAttribute("vo", vo);
		RequestDispatcher view = request.getRequestDispatcher("./member/mypage.jsp");  //보내질 곳 지정
		view.forward(request, response); 
	}

}
