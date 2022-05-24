package com.shop.ctrl;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.common.BoardVO;
import com.shop.model.BoardDAO;

@WebServlet("/EditBordCtrl")
public class EditBordCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public EditBordCtrl() {
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
		
    	if(cnt<0) {
    		
    	}
	}

}
