package movie.web.dao.mybatis;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MovieSessionFactoryBuilder extends HttpServlet
{
	static String src = "movie/web/dao/mybatis/config.xml";
	
	static SqlSessionFactory ssf = null;
	
	@Override
	public void init(ServletConfig config) throws ServletException 
	{
		InputStream is = null;
		try{
			is = Resources.getResourceAsStream(src);
		} catch (IOException e){
			e.printStackTrace();
		}
		
		ssf = new SqlSessionFactoryBuilder().build(is);
	}

	public static SqlSessionFactory getSqlsessionFactory()
	{
		return ssf;
	}

}
