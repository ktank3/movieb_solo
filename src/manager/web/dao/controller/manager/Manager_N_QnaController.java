package manager.web.dao.controller.manager;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/manger/m_notice_qna")
public class Manager_N_QnaController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
			String code = request.getParameter("code");

			NoticeDao noticeDao = new MyBatisNoticeDao();

			noticeDao.delete(code);*/

		request.getRequestDispatcher("/WEB-INF/views/manger/m_notice_qna.jsp")
		.forward(request, response);
	}

}
