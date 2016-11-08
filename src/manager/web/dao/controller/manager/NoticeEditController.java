package manager.web.dao.controller.manager;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import manager.web.dao.ReviewDao;
import manager.web.dao.entity.Review;
import movie.web.dao.mybatis.manager.MyBatisReviewDao;



@WebServlet("/manger/notice-edit")
public class NoticeEditController extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String code = request.getParameter("code");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		ReviewDao noticeDao = new MyBatisReviewDao();
		
		Review n = new Review();
		n.setCode(code);
		n.setTitle(title);
		n.setcontent(content);
		
		noticeDao.update(n);
		
		response.sendRedirect("notice-detail?code="+code);
		
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String _code = request.getParameter("code");

		ReviewDao noticeDao = new MyBatisReviewDao();//분리:재사용,분업화
		Review notice;
			
		notice = noticeDao.get(_code);
		request.setAttribute("n", notice);
		
		request.getRequestDispatcher("/WEB-INF/views/manger/notice-edit.jsp")
		   .forward(request, response);
	}
}






