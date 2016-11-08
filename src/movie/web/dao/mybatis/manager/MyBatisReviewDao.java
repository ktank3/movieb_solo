package movie.web.dao.mybatis.manager;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import manager.web.dao.ReviewDao;
import manager.web.dao.entity.Review;
import manager.web.dao.model.ReviewModel;
import movie.web.dao.mybatis.MovieSessionFactoryBuilder;


public class MyBatisReviewDao implements ReviewDao {
	
	SqlSessionFactory ssf;
	
	public MyBatisReviewDao() {
		ssf = MovieSessionFactoryBuilder.getSqlsessionFactory();
	}
	
	@Override
	public Review get(String code) {
		SqlSession session = ssf.openSession();
		ReviewDao reviewDao = session.getMapper(ReviewDao.class);		
		
		return reviewDao.get(code);
	}

	@Override
	public List<ReviewModel> getList(int page, String field, String query) {
		SqlSession session = ssf.openSession();
		ReviewDao reviewDao = session.getMapper(ReviewDao.class);		
		
		return reviewDao.getList(page, field, query);
	}

	@Override
	public List<ReviewModel> getList(int page) {
		
		return getList(page, "TITLE", "");
	}
	
	@Override
	public List<ReviewModel> getList(){
		
		return getList(1, "TITLE", "");
	}

	@Override
	public int insert(Review review) {
		SqlSession session = ssf.openSession();
		ReviewDao reviewDao = session.getMapper(ReviewDao.class);		
		
		int result = reviewDao.insert(review);
		
		session.commit();
		session.close();
		
		return result;
	}

	@Override
	public int update(Review review) {
		SqlSession session = ssf.openSession();
		ReviewDao reviewDao = session.getMapper(ReviewDao.class);		
		
		int result = reviewDao.update(review);
		
		session.commit();
		session.close();
		
		return result;
	}

	@Override
	public int delete(String code) {
		SqlSession session = ssf.openSession();
		ReviewDao reviewDao = session.getMapper(ReviewDao.class);		
		
		int result = reviewDao.delete(code);
		
		session.commit();
		session.close();
		
		return result;
	}

	@Override
	public int getCount(String field, String query) {
		SqlSession session = ssf.openSession();
		ReviewDao reviewDao = session.getMapper(ReviewDao.class);		
		
		int count =  reviewDao.getCount(field, query);
		
		session.close();
		
		return count;				
	}
	
}






