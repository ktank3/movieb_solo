package manager.web.dao.controller.manager;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import manager.web.dao.NoticeDao;
import manager.web.dao.entity.Notice;
import movie.web.dao.mybatis.manager.MyBatisNoticeDao;




@WebServlet("/manger/notice-detail")
public class NoticeDetailController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String _code = request.getParameter("code");

		NoticeDao noticeDao = new MyBatisNoticeDao();//분리:재사용,분업화
		Notice notice;
					
		notice= noticeDao.get(_code);
		request.setAttribute("n", notice);	
			
		request.getRequestDispatcher("/WEB-INF/views/manger/notice-detail.jsp")
		   .forward(request, response);
		
	}
}
