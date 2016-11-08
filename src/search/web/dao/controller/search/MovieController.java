package search.web.dao.controller.search;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tiles.TilesContainer;
import org.apache.tiles.access.TilesAccess;

import movie.web.dao.mybatis.search.MyBatisMovieDao;
import search.web.dao.MovieDao;
import search.web.dao.entity.Movie;



@WebServlet("/search/search")
public class MovieController extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String _page= request.getParameter("page");
		String type= request.getParameter("type");
		String query= request.getParameter("query");
		
		int page =1;
		String field = "TITLE";
		String sQuery= "";
		
		if(_page !=null && !_page.equals(""))
		{
			page=Integer.parseInt(_page);
		}
		if(type !=null && !type.equals(""))
		{
			field =type;
		}
		if(query !=null)
		{
			sQuery = query;
		}
		
		MovieDao movieDao = new MyBatisMovieDao();
		
		int count = movieDao.getCount(field, sQuery);
		List<Movie> movies = movieDao.getList(page, field, query);
		
		request.setAttribute("movies", movies);
		request.setAttribute("count", count);
		
		TilesContainer container = TilesAccess.getContainer(request.getSession().getServletContext());
		container.render("search.search", request, response);
		container.endContext(request, response);
		
		//request.getRequestDispatcher("/WEB-INF/views/search/search.jsp").forward(request,response);
	}
}
