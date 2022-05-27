package com.shop.ctrl;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.common.BoardVO;
import com.shop.model.BoardDAO;

@WebServlet("/EditBoardCtrl")
public class EditBoardCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public EditBoardCtrl() {
        super();
       
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int seq = Integer.parseInt(request.getParameter("seq"));
		String title = request.getParameter("title");
		String note = request.getParameter("note");
		
		BoardDAO dao = new BoardDAO();
		BoardVO vo = dao.getBoard(seq);
		vo.setTitle(title);
		vo.setNote(note);
		
    	int cnt = dao.editBoard(vo);

    	if(cnt>0) {
    		//성공
    		response.sendRedirect("GetBoardDetailCtrl?num=" +vo.getSeq());
    	} else {
    		//실패
    		response.sendRedirect("GetBoardEditCtrl?num=" +vo.getSeq());
    	}
	}

}
