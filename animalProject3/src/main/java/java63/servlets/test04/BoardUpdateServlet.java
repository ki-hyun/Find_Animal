package java63.servlets.test04;

import java.io.IOException;
import java.io.InputStream;

import java63.servlets.test04.dao.BoardDao;
import java63.servlets.test04.domain.Board;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

/* POST 요청 처리
 *  => 한글이 깨지는 문제 해결
 *  => getParameter()를 호출하기 전에
 *     request.setCharacterEncoding("UTF-8") 호출하라!
 *     => 클라이언트가 보내는 데이터의 문자 집합을 알려줘라(지정하라!!!)
 */

@WebServlet("/test04/board/update")
public class BoardUpdateServlet extends GenericServlet{
	private static final long serialVersionUID = 1L;

	@Override
	public void service(ServletRequest request, ServletResponse response)
			throws ServletException, IOException {
		// 다음 코드는 필터로 대체함.
		//request.setCharacterEncoding("UTF-8");

		Board board = new Board();
		board.setNo(Integer.parseInt(request.getParameter("no")));
		board.setName(request.getParameter("name"));
		board.setQuantity(Integer.parseInt(request.getParameter("qty")));
		board.setMakerNo(Integer.parseInt(request.getParameter("mkno")));
		board.setQuantity(Integer.parseInt(request.getParameter("qty")));
		board.setMakerNo(Integer.parseInt(request.getParameter("mkno")));


		//AppInitServlet.boardDao.update(board);
		//ContextLoaderListener.boardDao.update(board);

		// BoardDao를 ServletContext 보관소에서 꺼내는 방식을 사용
		// => 단점: 위의 방식보다 코드가 늘었다.
		// => 장점: 특정 클래스에 종속되지 않는다. 유지보수에서 더 중요!
		//BoardDao boardDao = (BoardDao)this.getServletContext()
		//		.getAttribute("boardDao");
		/*BoardDao boardDao = (BoardDao)ContextLoaderListener.appCtx
				.getBean("boardDao");*/
		
		ApplicationContext appCtx =
				WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());

		BoardDao boardDao = (BoardDao)appCtx.getBean("boardDao");
		
		boardDao.update(board);

		HttpServletResponse originResponse = (HttpServletResponse)response;
		originResponse.sendRedirect("list");
	}

}
