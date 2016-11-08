package review.web.dao;

import java.util.List;

import review.web.dao.entity.Review;
import review.web.dao.model.ReviewModel;



public interface ReviewDao 
{
	Review get(String code);
	List<ReviewModel> getList(int page, String field, String query);
	List<ReviewModel> getList(int page);
	List<ReviewModel> getList();
	int insert(Review notice);
	int update(Review notice);
	int delete(String code);
	Review getPrev(String code);
	Review getNext(String code);
	int getCount(String field, String query);
	int hitUp(String code);
}
