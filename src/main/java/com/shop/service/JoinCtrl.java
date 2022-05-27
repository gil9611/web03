package com.shop.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.common.MemberVO;
import com.shop.model.MemberDAO;


@WebServlet("/JoinCtrl")
public class JoinCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public JoinCtrl() {
        super();
        
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberVO vo = new MemberVO();
		vo.setMid(request.getParameter("jid"));
		vo.setMpw(request.getParameter("jpw"));
		vo.setMname(request.getParameter("jname"));
		vo.setMaddress(request.getParameter("jadd"));
		
		MemberDAO dao = new MemberDAO();
		int cnt = dao.addMember(vo);
		
		if(cnt>0) {
			//가입성공
			response.sendRedirect("index.jsp");
		}else {
			//가입실패
			response.sendRedirect("join.jsp");
		}
		
	}

}
