package movie.web.dao.mybatis.search;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import movie.web.dao.mybatis.MovieSessionFactoryBuilder;
import search.web.dao.MovieDao;
import search.web.dao.entity.Movie;

public class MyBatisMovieDao implements MovieDao 
{
	SqlSessionFactory ssf;
	
	public MyBatisMovieDao()
	{
		ssf = MovieSessionFactoryBuilder.getSqlsessionFactory();
	}

	@Override
	public Movie get(String code) {
		SqlSession session = ssf.openSession();
		MovieDao movieDao = session.getMapper(MovieDao.class);
		
		Movie movie = movieDao.get(code);
		session.close();
		return movie;
	}

	
	@Override
	public List<Movie> getList(int page, String field, String query) 
	{
		SqlSession session = ssf.openSession();
		MovieDao movieDao = session.getMapper(MovieDao.class);
		
		List<Movie> movies = movieDao.getList(page, field, query);
		session.close();
		return movies;
	}

	@Override
	public int getCount(String field, String query) {
		SqlSession session = ssf.openSession();
		MovieDao movieDao = session.getMapper(MovieDao.class);
		
		int count = movieDao.getCount(field, query);
		session.close();
		return count;
	}


	@Override
	public Movie getPrev(String code) {
		SqlSession session = ssf.openSession();
		MovieDao movieDao = session.getMapper(MovieDao.class);
		Movie getPrev = movieDao.getPrev(code);
		session.close();
				
		return getPrev;
	}

	@Override
	public Movie getNext(String code) {
		SqlSession session = ssf.openSession();
		MovieDao movieDao = session.getMapper(MovieDao.class);
		Movie getNext = movieDao.getNext(code);
		session.close();
				
		return getNext;
	}

}
