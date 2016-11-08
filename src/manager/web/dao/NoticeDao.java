package manager.web.dao;

import java.util.List;

import manager.web.dao.entity.Notice;
import manager.web.dao.model.NoticeModel;


public interface NoticeDao {
	Notice get(String code);
	List<NoticeModel> getList(int page, String field, String query);
	List<NoticeModel> getList(int page);
	List<NoticeModel> getList();
	int insert(Notice review);
	int update(Notice review);
	int delete(String code);
	int getCount(String field, String query);
}
