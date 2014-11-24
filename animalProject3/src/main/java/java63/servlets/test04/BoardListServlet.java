package java63.servlets.test04;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.List;

import java63.servlets.test04.dao.BoardDao;
import java63.servlets.test04.domain.Board;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

@WebServlet("/test04/board/list")
public class BoardListServlet extends GenericServlet{
	private static final long serialVersionUID = 1L;
	static final int PAGE_DEFAULT_SIZE = 5;
	@Override
	public void service(ServletRequest request, ServletResponse response)
			throws ServletException, IOException {

		System.out.println("service() 실행 시작");

		int pageNo = 1;
		int pageSize = 5;
		if (request.getParameter("pageNo") != null) {
			pageNo = Integer.parseInt(request.getParameter("pageNo"));
			pageSize = PAGE_DEFAULT_SIZE;
		}

		if (request.getParameter("pageSize") != null) {
			pageSize = Integer.parseInt(request.getParameter("pageSize"));
		}


		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();


		BoardDao boardDao = (BoardDao)this.getServletContext()
				.getAttribute("boardDao");
		/*for (int i = boardDao.selectList(pageNo, pageSize).size(); i > 0; i--) {
	Board board = boardDao.selectList(pageNo, pageSize).get(i-1);*/
		List<Board> boards = null;
		try{
			boards = boardDao.selectList(pageNo, pageSize);
		} catch (Exception e) {
			/* Forward로 다른 서블릿에게 제어권 위임하기
			 * => 제어권이 넘어가면 돌아오지 않는다.
			 */
			// 다른 서블릿을 실행 => 실행 후 되돌아 제어권이 되돌아 온다.
			RequestDispatcher rd = 
					request.getRequestDispatcher("list?pageNo=1");
			request.setAttribute("error", e);
			rd.forward(request, response);
			
			
		}
		request.setAttribute("boards", boards);
		request.setAttribute("pageNo", pageNo);

		// include를 수행할 때는 여기에서 콘텐츠 타입을 설정해야 한다.
		response.setContentType("text/html;charset=UTF-8");

		// 결과를 출력하기 위해 JSP에게 위임한다.

		// 다른 서블릿을 실행 => 실행 후 되돌아 제어권이 되돌아 온다.
		RequestDispatcher rd = 
				request.getRequestDispatcher("/test04/board/BoardList.jsp");
		rd.include(request, response);



		/*out.println("$('.pageClass').click(function(){");
		out.println("	$(this).parent().attr('class', 'active');");
		out.println("});");*/
		// 다른 서블릿을 실행 => 실행 후 되돌아 제어권이 되돌아 온다.
		/*rd = 
				request.getRequestDispatcher("/common/footer");
		rd.include(request, response);*/

	}

}
