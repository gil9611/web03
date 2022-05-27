package com.shop.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shop.common.MemberVO;
import com.shop.model.MemberDAO;


@WebServlet("/LoginCtrl")
public class LoginCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public LoginCtrl() {
        super();
       
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mid = request.getParameter("mid");
		String mpw = request.getParameter("mpw");
		
		MemberDAO dao = new MemberDAO();
		int cnt = dao.loginMember(mid, mpw);
		
		System.out.println("loginMember");
		MemberVO vo = dao.getMember(mid);
		
		HttpSession session = request.getSession();
		if(cnt>0) {
			//로그인 성공
			session.setAttribute("sid", vo.getMid());
			session.setAttribute("sname", vo.getMname());
			response.sendRedirect("index.jsp");
		}else {
			//로그인 실패
			response.sendRedirect("login.jsp");
		}
		
		
		
	}

}
