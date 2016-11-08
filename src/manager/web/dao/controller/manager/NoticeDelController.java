package manager.web.dao.controller.manager;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import manager.web.dao.ReviewDao;
import movie.web.dao.mybatis.manager.MyBatisReviewDao;



@WebServlet("/manger/notice-del")
public class NoticeDelController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String code = request.getParameter("code");
		
		ReviewDao noticeDao = new MyBatisReviewDao();
				
		noticeDao.delete(code);
		
		response.sendRedirect("notice");
	}
}
