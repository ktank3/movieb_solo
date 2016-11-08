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
		
	   
	   //--->${n.�÷�}  or   ${n["�÷�"]}

		//1. �׳ɺθ���
		response.sendRedirect("review");
		//2. �ڿ��� �����ϸ鼭 �θ���: ��������ϰŶ�
	
		
		

	}

}

