package manager.web.dao;

import java.util.List;

import manager.web.dao.entity.Review;
import manager.web.dao.model.ReviewModel;

public interface ReviewDao {
	Review get(String code);
	List<ReviewModel> getList(int page, String field, String query);
	List<ReviewModel> getList(int page);
	List<ReviewModel> getList();
	int insert(Review notice);
	int update(Review notice);
	int delete(String code);
	int getCount(String field, String query);
}
