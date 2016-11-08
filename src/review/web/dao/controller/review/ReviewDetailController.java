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



@WebServlet("/review/review-detail")
public class ReviewDetailController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String code = request.getParameter("code");

		ReviewDao reviewDao = new MyBatisReviewDao();
		Review review;

		review = reviewDao.get(code);
		int hitUp = reviewDao.hitUp(code);
		request.setAttribute("n", review);
		request.setAttribute("prev", reviewDao.getPrev(code));
		request.setAttribute("next", reviewDao.getNext(code));

		TilesContainer container = TilesAccess.getContainer(request.getSession().getServletContext());
		container.render("review.review-detail",request,response);	//이걸 랜더링하라고
		container.endContext(request,response);

	}

}
