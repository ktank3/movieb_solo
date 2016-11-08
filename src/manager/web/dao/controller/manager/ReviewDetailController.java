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




@WebServlet("/manger/review-detail")
public class ReviewDetailController extends HttpServlet {
		@Override
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String _code = request.getParameter("code");

			ReviewDao noticeDao = new MyBatisReviewDao();//분리:재사용,분업화
			Review review;
						
			review = noticeDao.get(_code);
			request.setAttribute("n", review);	
				
			request.getRequestDispatcher("/WEB-INF/views/manger/notice-detail.jsp")
			   .forward(request, response);
		
	}
}
