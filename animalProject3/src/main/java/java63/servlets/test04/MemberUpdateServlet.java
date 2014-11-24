package java63.servlets.test04;

import java.io.IOException;

import java63.servlets.test04.dao.MemberDao;
import java63.servlets.test04.domain.Member;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/test04/member/update")
public class MemberUpdateServlet extends GenericServlet {
  private static final long serialVersionUID = 1L;

  @Override
  public void service(ServletRequest request, ServletResponse response)
      throws ServletException, IOException {
    request.setCharacterEncoding("UTF-8");
    
    Member member = new Member();
    member.setId(request.getParameter("id"));
    member.setPwd(request.getParameter("pwd"));
    member.setName(request.getParameter("name"));
    member.setTel(request.getParameter("tel"));
    member.setAddr(request.getParameter("addr"));
    
     //AppInitServlet.memberDao.update(member);
    //ContextLoaderListener.memberDao.update(member);
    
    // MemberDao를 ServletContext 보관소에서 꺼내는 방식을 사용
    // => 단점: 위의 방식보다 코드가 늘었다.
    // => 장점: 특정 클래스에 종속되지 않는다. 유지보수에서 더 중요!
    MemberDao memberDao = (MemberDao)this.getServletContext()
                                         .getAttribute("memberDao");
    memberDao.update(member);
    
    HttpServletResponse orginResponse = (HttpServletResponse)response;
    orginResponse.sendRedirect("list");
  }
  
}












