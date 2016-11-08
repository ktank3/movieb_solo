package review.web.dao;

import java.util.List;

import review.web.dao.entity.Movie;
import review.web.dao.model.MovieModel;

public interface MovieDao 
{
	Movie get(String code);
	
	List<MovieModel> getList(int page, String field,String query);
	List<MovieModel> getList(int page);
	List<MovieModel> getList();

	int getCount(String field, String query);
}
