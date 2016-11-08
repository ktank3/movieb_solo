package movie.web.dao.mybatis.review;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import movie.web.dao.mybatis.MovieSessionFactoryBuilder;
import review.web.dao.ReviewDao;
import review.web.dao.entity.Review;
import review.web.dao.model.ReviewModel;




public class MyBatisReviewDao implements ReviewDao {
	
	SqlSessionFactory ssf;
	
	public MyBatisReviewDao() {
		ssf = MovieSessionFactoryBuilder.getSqlsessionFactory();
	}
	
	@Override
	public Review get(String code) {
		SqlSession session = ssf.openSession();
		ReviewDao reviewDao = session.getMapper(ReviewDao.class);		
		Review result = reviewDao.get(code);
		session.close();
		return result;
	}

	@Override
	public List<ReviewModel> getList(int page, String field, String query) {
		SqlSession session = ssf.openSession();
		ReviewDao reviewDao = session.getMapper(ReviewDao.class);
		List<ReviewModel> result = reviewDao.getList(page, field, query);
		session.close();
		
		return result;
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
	public int insert(Review notice) {
		SqlSession session = ssf.openSession();
		ReviewDao reviewDao = session.getMapper(ReviewDao.class);		
		
		int result = reviewDao.insert(notice);
		
		session.commit();
		session.close();
		
		return result;
	}

	@Override
	public int update(Review notice) {
		SqlSession session = ssf.openSession();
		ReviewDao reviewDao = session.getMapper(ReviewDao.class);		
		
		int result = reviewDao.update(notice);
		
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

	@Override
	public int hitUp(String code) {
		SqlSession session = ssf.openSession();
		ReviewDao reviewDao = session.getMapper(ReviewDao.class);
		
		int result = reviewDao.hitUp(code);
		session.commit();
		session.close();
		
		return result;
	}

	@Override
	public Review getPrev(String code) {
		SqlSession session = ssf.openSession();
		ReviewDao reviewDao = session.getMapper(ReviewDao.class);		
		Review result = reviewDao.getPrev(code);
		session.close();
		return result;
	}

	@Override
	public Review getNext(String code) {
		SqlSession session = ssf.openSession();
		ReviewDao reviewDao = session.getMapper(ReviewDao.class);		
		Review result = reviewDao.getNext(code);
		session.close();
		return result;
	}
	
}






