package review.web.dao.controller.review;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tiles.TilesContainer;
import org.apache.tiles.access.TilesAccess;

import movie.web.dao.mybatis.review.MyBatisMovieDao;
import review.web.dao.MovieDao;
import review.web.dao.ReviewDao;
import review.web.dao.model.MovieModel;
import review.web.dao.model.ReviewModel;

@WebServlet("/review/review-mserch")
public class ReviewMovieSerchController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String t = request.getParameter("t");
		String q = request.getParameter("q");
		String p = request.getParameter("p");

		int page = 1;
		String query = "";
		String field = "TITLE";

		if (p != null && !p.equals('1'))
			page = Integer.parseInt(p);
		if (t != null && !t.equals(""))
			field = t;
		if (q != null)
			query = q;

		MovieDao movieDao = new MyBatisMovieDao();
		List<MovieModel> list = movieDao.getList(page, field, query);

		int count = movieDao.getCount(field, query);

		request.setAttribute("list", list);
		request.setAttribute("count", count);

		TilesContainer container = TilesAccess.getContainer(request.getSession().getServletContext());
		container.render("review.review-mserch", request, response); // 이걸
																		// 랜더링하라고
		container.endContext(request, response);

	}

}
