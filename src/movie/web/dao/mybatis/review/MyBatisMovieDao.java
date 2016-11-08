package movie.web.dao.mybatis.review;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import movie.web.dao.mybatis.MovieSessionFactoryBuilder;
import review.web.dao.MovieDao;
import review.web.dao.ReviewDao;
import review.web.dao.entity.Movie;
import review.web.dao.model.MovieModel;
import review.web.dao.model.ReviewModel;


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
				
		return movieDao.get(code);
	}

	@Override
	public List<MovieModel> getList(int page, String field, String query) {
	
		SqlSession session = ssf.openSession();
		MovieDao movieDao = session.getMapper(MovieDao.class);
		List<MovieModel> result = movieDao.getList(page,field,query);
		session.close();
		
		return result;
	}

	@Override
	public List<MovieModel> getList(int page) {
		return getList(page,"title","");
	}

	@Override
	public List<MovieModel> getList() {
		return getList(1,"title","");
	}

	@Override
	public int getCount(String field, String query) 
	{
		SqlSession session = ssf.openSession();
		MovieDao movieDao = session.getMapper(MovieDao.class);
		
		int count = movieDao.getCount(field, query);
		session.close();
		return count;
	}

}
