package java63.servlets.test04;

import java.io.IOException;
import java.io.PrintWriter;

import java63.servlets.test04.dao.MemberDao;
import java63.servlets.test04.domain.Member;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/test04/member/list")
public class MemberListServlet extends GenericServlet {
  private static final long serialVersionUID = 1L;

  static final int PAGE_DEFAULT_SIZE = 3;
  
  @Override
  public void service(ServletRequest request, ServletResponse response)
      throws ServletException, IOException {
    int pageNo = 0;
    int pageSize = 0;
    
    if (request.getParameter("pageNo") != null) {
      pageNo = Integer.parseInt(request.getParameter("pageNo"));
      pageSize = PAGE_DEFAULT_SIZE;
    }
    
    if (request.getParameter("pageSize") != null) {
      pageSize = Integer.parseInt(request.getParameter("pageSize"));
    }
    
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.println("<html>");
    out.println("<head>");
    out.println("<link rel='stylesheet'"); 
    out.println("      href='../../css/bootstrap.min.css'>");
    out.println("<link rel='stylesheet'"); 
    out.println("      href='../../css/bootstrap-theme.min.css'>");
    out.println("<link rel='stylesheet' href='../../css/common.css'>");
    out.println("</head>");
    out.println("<body>");
    out.println("<div class='container'>");
    out.println("<h1>멤버 목록 </h1>");
    out.println("<p><a href='ember-form.html' class='btn btn-primary'>가입 </a></p>");
    out.println("<p><a href='checkIn01-form.html' class='btn btn-primary'>등록 </a></p>");
    out.println("<table class='table table-hover'>");
    out.println("<tr>");
    out.println("  <th>아이디</th><th>이름</th><th>전화번호</th><th>주소</th>");
    out.println("</tr>");
    
    //for (Member member : AppInitServlet.memberDao.selectList(pageNo, pageSize)) {
    //for (Member member : ContextLoaderListener.memberDao.selectList(pageNo, pageSize)) {
    
     // MemberDao를 ServletContext 보관소에서 꺼내는 방식을 사용
    // => 단점: 위의 방식보다 코드가 늘었다.
    // => 장점: 특정 클래스에 종속되지 않는다. 유지보수에서 더 중요!
    MemberDao memberDao = (MemberDao)this.getServletContext()
                                         .getAttribute("memberDao");
    for (Member member : memberDao.selectList(pageNo, pageSize)) {
      out.println("<tr>");
      out.println("  <td>" + member.getId() + "</td>");
      out.println("  <td><a href='view?id=" + member.getId() + "'>" 
            + member.getName() + "</a></td>");
      out.println("  <td>" + member.getTel() + "</td>");
      out.println("  <td>" + member.getAddr() + "</td>");
      out.println("</tr>");
    }
    out.println("</table>");
    out.println("</div>");
    
    out.println("<script src='../../js/jquery-1.11.1.js'></script>");
    
    out.println("</body>");
    out.println("</html>");
  }
  
}












