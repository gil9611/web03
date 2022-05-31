package com.shop.goods;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.shop.common.GoodsVO;
import com.shop.model.GoodsDAO;


@WebServlet("/InsertGoodsCtrl")
public class InsertGoodsCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ServletContext context = null;
    public InsertGoodsCtrl() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public void init(ServletConfig config) throws ServletException {
    	context = config.getServletContext();
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String imgUpload = context.getInitParameter("imgUpload");
		String uploadPath = imgUpload;
		int msize = 10*1024*1024;
		
		GoodsVO vo = new GoodsVO();
		GoodsDAO dao = new GoodsDAO();
		
		try {
			MultipartRequest multi = new MultipartRequest(request, uploadPath, msize, "UTF-8", new DefaultFileRenamePolicy());
			String gname = multi.getParameter("gname");
			int gprice = Integer.parseInt(multi.getParameter("gprice"));
			out.println(gprice);
			String gcategory = multi.getParameter("gcategory");
			String gcolor = multi.getParameter("gcolor");
			String gsize = multi.getParameter("gsize");
			String gmeterial = multi.getParameter("gmeterial");
			String gcomment = multi.getParameter("gcomment");
			String gimg = multi.getFilesystemName("gimg");
			
			out.println("불러오기 완료");
			
			vo.setGname(gname);
			vo.setGprice(gprice);
			vo.setGcategory(gcategory);
			vo.setGcolor(gcolor);
			vo.setGsize(gsize);
			vo.setGmeterial(gmeterial);
			vo.setGcomment(gcomment);
			vo.setGimg(".\\imgUpload\\"+gimg);
			int cnt = dao.insertGoods(vo);
			
			if(cnt>0) {
				//성공
				response.sendRedirect("GetGoodsListCtrl");
			}else {
				//실패
				response.sendRedirect("./goods/addGoodsForm.jsp");
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
