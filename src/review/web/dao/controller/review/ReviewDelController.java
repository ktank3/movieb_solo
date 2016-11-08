package review.web.dao.controller.review;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import movie.web.dao.mybatis.review.MyBatisReviewDao;
import review.web.dao.ReviewDao;




@WebServlet("/review/review-del")
public class ReviewDelController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

	   String code = request.getParameter("code");
	   ReviewDao reviewDao = new MyBatisReviewDao();
	   reviewDao.delete(code);
		
	   
	   //--->${n.컬럼}  or   ${n["컬럼"]}

		//1. 그냥부르기
		response.sendRedirect("review");
		//2. 자원을 공유하면서 부르기: 일을계속하거라
	
		
		

	}

}

