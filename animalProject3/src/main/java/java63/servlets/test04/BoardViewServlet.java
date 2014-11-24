package java63.servlets.test04;

import java.io.IOException;
import java63.servlets.test04.dao.BoardDao;
import java63.servlets.test04.dao.MemberDao;
import java63.servlets.test04.domain.Board;
import java63.servlets.test04.domain.Member;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/test04/board/view")
public class BoardViewServlet extends GenericServlet{
	private static final long serialVersionUID = 1L;

	@Override
	public void service(ServletRequest request, ServletResponse response)
			throws ServletException, IOException {

		int no = Integer.parseInt(request.getParameter("no"));
		 //Board board = AppInitServlet.boardDao.selectOne(no);
		//Board board = ContextLoaderListener.boardDao.selectOne(no);

		// BoardDao를 ServletContext 보관소에서 꺼내는 방식을 사용
		// => 단점: 위의 방식보다 코드가 늘었다.
		// => 장점: 특정 클래스에 종속되지 않는다. 유지보수에서 더 중요!
		BoardDao boardDao = (BoardDao)this.getServletContext()
				.getAttribute("boardDao");
		
		MemberDao memberDao = (MemberDao)this.getServletContext()
				.getAttribute("memberDao");

		Board board = boardDao.selectOne(no);
		Member member = memberDao.selectOne(board.getId());
		
		request.setAttribute("board", board);
		request.setAttribute("member", member);
		
		// include를 수행할 때는 여기에서 콘텐츠 타입을 설정해야 한다.
				response.setContentType("text/html;charset=UTF-8");
				
				// 결과를 출력하기 위해 JSP에게 위임한다.
				
				// 다른 서블릿을 실행 => 실행 후 되돌아 제어권이 되돌아 온다.
				RequestDispatcher rd = 
						request.getRequestDispatcher("/test04/board/BoardView.jsp");
				rd.include(request, response);

		
	}

}
