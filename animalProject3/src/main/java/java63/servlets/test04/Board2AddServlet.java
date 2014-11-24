package java63.servlets.test04;

import java.io.IOException;
import java.util.Date;

import java63.servlets.test04.dao.BoardDao;
import java63.servlets.test04.domain.Board;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/test04/board/Badd")
public class Board2AddServlet extends GenericServlet {
  private static final long serialVersionUID = 1L;

  @Override
  public void service(ServletRequest request, ServletResponse response)
      throws ServletException, IOException {
     request.setCharacterEncoding("UTF-8");
    
//	protected int no;
//	protected String breed;
//	protected String findPlace;
//	protected String findDate;
//	protected String gender;
//	protected String title;
//	protected String content;
//	protected String id;
//	protected String addr;
//	protected String tel;
//	protected String photo;
//	protected Date bDate;
    
    Board board = new Board();
    board.setId(request.getParameter("id"));
    board.setBreed(request.getParameter("breed"));
    board.setFindPlace(request.getParameter("findPlace"));
    board.setFindDate(request.getParameter("findDate"));
    board.setGender(request.getParameter("gender"));
    board.setTitle(request.getParameter("title"));
    board.setContent(request.getParameter("content"));
    board.setId(request.getParameter("id"));
    board.setAddr(request.getParameter("addr"));
    board.setTel(request.getParameter("tel"));
    board.setPhoto(request.getParameter("photo"));
    
    
    //AppInitServlet.boardDao.insert(board);
    //ContextLoaderListener.boardDao.insert(board);
    
    // BoardDao를 ServletContext 보관소에서 꺼내는 방식을 사용
    // => 단점: 위의 방식보다 코드가 늘었다.
    // => 장점: 특정 클래스에 종속되지 않는다. 유지보수에서 더 중요!
    BoardDao boardDao = (BoardDao)this.getServletContext()
                                         .getAttribute("boardDao");
    boardDao.insert(board);
    
    HttpServletResponse orginResponse = (HttpServletResponse)response;
    orginResponse.sendRedirect("list");
  }
  
}












