package review.web.dao.controller.review;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tiles.TilesContainer;
import org.apache.tiles.access.TilesAccess;


import movie.web.dao.mybatis.review.MyBatisReviewDao;
import review.web.dao.ReviewDao;
import review.web.dao.entity.Review;



@WebServlet("/review/review-reg")
public class ReviewRegController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		TilesContainer container = TilesAccess.getContainer(request.getSession().getServletContext());
		container.render("review.review-reg",request,response);	//이걸 랜더링하라고
		container.endContext(request,response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//request.setCharacterEncoding("UTF-8");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String movie_title = request.getParameter("movie_title");

		
		ReviewDao reviewDao = new MyBatisReviewDao();
		
		Review n = new Review();		
		n.setTitle(title);
		n.setContent(content);
		n.setTitle(movie_title);
		// 현재 로그인 사용자 정보를 얻는 로직
		n.setWriter("kttank3");
		
		reviewDao.insert(n);
		
		response.sendRedirect("review");
	}
}






