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


@WebServlet("/MemberEditCtrl")
public class MemberEditCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public MemberEditCtrl() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberVO vo = new MemberVO();
		MemberDAO dao = new MemberDAO();
		
		vo.setMid(request.getParameter("uid"));
		vo.setMname(request.getParameter("uname"));
		vo.setMaddress(request.getParameter("uadd"));

		int cnt = dao.editMember(vo);
		
		if(cnt>0) {
			//변경성공
			HttpSession session = request.getSession();
			String sid = vo.getMid();
			String sname = vo.getMname();
			session.setAttribute("sid", sid);
			session.setAttribute("sname", sname);
			response.sendRedirect("index.jsp");
		}else {
			//변경실패
			response.sendRedirect("GetMypageCtrl");
		}
	}

}
