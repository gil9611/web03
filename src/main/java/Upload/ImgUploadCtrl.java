package Upload;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;


@WebServlet("/ImgUploadCtrl")
public class ImgUploadCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ServletContext context = null;
	
    public ImgUploadCtrl() {
        super();
        
    }
    
    public void init(ServletConfig config) throws ServletException {
    	context = config.getServletContext();
	}

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		String imgUpload = context.getInitParameter("imgUpload");
		
		String uploadPath = imgUpload;
		int size = 10*1024*1024;
		String name = "";
		String subject = "";
		String filename1 = "";
		String filename2 = "";
		
		try {
			MultipartRequest multi = new MultipartRequest(request, uploadPath, size, "UTF-8"); //파일 덮어쓰기
			name = multi.getParameter("name");
			subject = multi.getParameter("subject");
			Enumeration files = multi.getFileNames();		//여러 파일일경우 나영혈을 선언하여 활용
			String file1 = (String)files.nextElement();
			filename1 = multi.getFilesystemName(file1);		//1번째 파일 업로드
			String file = multi.getParameter("fileName1");
			
			String filen = imgUpload+"\\"+filename1;
			
			out.println("<p>이름 : " +name +"</p>");
			out.println("<p>제목 : " +subject +"</p>");
			out.println("<p>이미지1 : " +filename1 +"</p>");
			out.println("<p>이미지1 : " +imgUpload +"</p>");
			out.println("<p>이미지1 : " +filen +"</p>");
			out.println("<p>리퀘스트 : " +request.getSession().getServletContext().getRealPath("/") +"</p>");
			out.println("<p>리퀘스트 : " + "https://gojoo.tistory.com/60" +"</p>");
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
