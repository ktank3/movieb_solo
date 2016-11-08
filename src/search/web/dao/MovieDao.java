package search.web.dao;

import java.util.List;

import search.web.dao.entity.Movie;

public interface MovieDao 
{
	Movie get(String code);
	List<Movie> getList(int page,String field,String query);
	
	int getCount(String field, String query);

	Movie getPrev(String code);
	Movie getNext(String code);
}
