package manager.web.dao.controller.manager;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import manager.web.dao.ReviewDao;
import manager.web.dao.model.ReviewModel;
import movie.web.dao.mybatis.manager.MyBatisReviewDao;




@WebServlet("/manger/notice")
public class NoticeController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//http://.../customer/notice 		==> t ? null
		//http://.../customer/notice?t=  	==> t ? ""
		
		String p = request.getParameter("p");
		String t = request.getParameter("t");
		String q = request.getParameter("q");
		
		int page = 1;
		String field = "TITLE";
		String query = "";
		
		if(p != null && !p.equals(""))
			page = Integer.parseInt(p);
			
		if(t != null && !t.equals(""))
			field = t;
		
		if(q != null)
			query = q;
		
		ReviewDao noticeDao = new MyBatisReviewDao();
		List<ReviewModel> list = noticeDao.getList(page, field, query);
		int count = noticeDao.getCount(field, query);
				
		request.setAttribute("list", list);
		request.setAttribute("count", count);
			
		// 1. 그냥 부르기 : 네가 새로 햇!
		//response.sendRedirect("notice.jsp");
		
		// 2. 자원을 공유하면서 부르기 : 일을 이어서 계속햇!
		request.getRequestDispatcher("/WEB-INF/views/manger/notice.jsp")
			   .forward(request, response);
	}
}




