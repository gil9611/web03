package com.shop.ctrl;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.common.BoardVO;
import com.shop.model.BoardDAO;


@WebServlet("/AddBoardCtrl")
public class AddBoardCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AddBoardCtrl() {
        super();
        
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title = request.getParameter("title");
		String note = request.getParameter("note");
		
		
		BoardVO vo = new BoardVO();
		vo.setTitle(title);
		vo.setNickname("관리자");
		vo.setNote(note);
		
		BoardDAO dao = new BoardDAO();
		int cnt = dao.addBoard(vo);

    	if(cnt>0) {
    		//성공
    		response.sendRedirect("GetBoardListCtrl");
    	} else {
    		//실패
    		response.sendRedirect("./board/addBoardForm.jsp");
    	}
	}

}
