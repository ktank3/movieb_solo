package review.web.dao.controller.review;

import java.io.IOException;
import java.sql.SQLException;

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





@WebServlet("/review/review-edit")
public class ReviewEditController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  String code = request.getParameter("code");
		  String content= request.getParameter("content");
		  String title= request.getParameter("title");
		  String movie_title= request.getParameter("movie_title");
		  
		  ReviewDao reviewDao = new MyBatisReviewDao();
		  Review n = new Review();
		  
		n.setMovie_title(movie_title);
		  n.setTitle(title);
		  n.setCode(code);
		  n.setContent(content);	 
		  
		  reviewDao.update(n);
		  
		  response.sendRedirect("review-detail?code="+code);
	
	}
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String _code = request.getParameter("code");

	      ReviewDao reviewDao = new MyBatisReviewDao();
	      Review review;
	      
	      review = reviewDao.get(_code);
	      request.setAttribute("n", review);
	      
	      TilesContainer container = TilesAccess.getContainer(request.getSession().getServletContext());
			container.render("review.review-edit",request,response);	//이걸 랜더링하라고
			container.endContext(request,response);
	}
	

}






