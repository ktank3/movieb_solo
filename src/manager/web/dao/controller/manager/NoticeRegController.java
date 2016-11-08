package manager.web.dao.controller.manager;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import manager.web.dao.ReviewDao;
import manager.web.dao.entity.Review;
import movie.web.dao.mybatis.manager.MyBatisReviewDao;




@WebServlet("/manger/notice-reg")
public class NoticeRegController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("/WEB-INF/views/manger/notice-reg.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String regdate = request.getParameter("regdate");
		
		ReviewDao noticeDao = new MyBatisReviewDao();
		
		Review n = new Review();		
		n.setTitle(title);
		n.setcontent(content);
		// 현재 로그인 사용자 정보를 얻는 로직
		n.setWriter("newlec");
		
		noticeDao.insert(n);
		
		response.sendRedirect("notice");
	}
}






