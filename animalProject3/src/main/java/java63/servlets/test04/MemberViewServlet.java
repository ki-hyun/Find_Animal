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

@WebServlet("/test04/member/view")
public class MemberViewServlet extends GenericServlet {
  private static final long serialVersionUID = 1L;

  @Override
  public void service(ServletRequest request, ServletResponse response)
      throws ServletException, IOException {
    String id = request.getParameter("id");
    //Member member = AppInitServlet.memberDao.selectOne(no);
     //Member member = ContextLoaderListener.memberDao.selectOne(no);
    
    // MemberDao를 ServletContext 보관소에서 꺼내는 방식을 사용
    // => 단점: 위의 방식보다 코드가 늘었다.
    // => 장점: 특정 클래스에 종속되지 않는다. 유지보수에서 더 중요!
    MemberDao memberDao = (MemberDao)this.getServletContext()
                                         .getAttribute("memberDao");
    Member member = memberDao.selectOne(id);
    
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
    out.println("<h1>회원 정보</h1>");
    
    out.println("<form class='form-horizontal' role='form' "
        + "action='update' method='post'>");
    out.println("<div class='form-group'>");
    out.println("  <label for='id' class='col-sm-2 control-label'>아이디 </label>");
    out.println("  <div class='col-sm-10'>");
    out.println("    <input type='text' class='form-control' readonly ");
    out.println("        id='id' name='id' value='" + member.getId() + "'>");
    out.println("  </div>");
    out.println("</div>");
    
    out.println("<div class='form-group'>");
    out.println("  <label for='name' class='col-sm-2 control-label'>비밀번호 </label>");
    out.println("  <div class='col-sm-10'>");
    out.println("    <input type='text' class='form-control' ");
    out.println("        id='pwd' name='pwd' value='" + member.getPwd() + "'>");
    out.println("  </div>");
    out.println("</div>");
    
    out.println("<div class='form-group'>");
    out.println("  <label for='name' class='col-sm-2 control-label'>이름 </label>");
    out.println("  <div class='col-sm-10'>");
    out.println("    <input type='text' class='form-control' ");
    out.println("        id='name' name='name' value='" + member.getName() + "'>");
    out.println("  </div>");
    out.println("</div>");
    
    out.println("<div class='form-group'>");
    out.println("  <label for='mkno' class='col-sm-2 control-label'>전화번</label>");
    out.println("  <div class='col-sm-10'>");
    out.println("   <input type='text' class='form-control' ");
    out.println("        id='tes' name='tel' value='" + member.getTel() + "'>");
    out.println("  </div>");
    out.println("</div>");
    
    out.println("<div class='form-group'>");
    out.println("  <label for='qty' class='col-sm-2 control-label'>주소 </label>");
    out.println("  <div class='col-sm-10'>");
    out.println("    <input type='text' class='form-control' ");
    out.println("        id='addr' name='addr' value='" + member.getAddr() + "'>");
    out.println("  </div>");
    out.println("</div>");
    
    
    out.println("<div class='form-group'>");
    out.println("  <div class='col-sm-offset-2 col-sm-10'>");
    out.println("    <button id='btnUpdate' type='submit' class='btn btn-primary'>변경</button>");
    out.println("    <button id='btnDelete' type='button' class='btn btn-primary'>삭제</button>");
    out.println("    <button id='btnCancel' type='button' class='btn btn-primary'>취소</button>");
    out.println("  </div>");
    out.println("</div>");
    
    out.println("</form>");
    out.println("</div>");
    
    out.println("<script src='../../js/jquery-1.11.1.js'></script>");
    
    out.println("<script>");
    out.println("  $('#btnCancel').click(function(){");
    out.println("    history.back();");
    out.println("  });");
    
    out.println("  $('#btnDelete').click(function(){");
    out.println("    if (window.confirm('삭제하시겠습니까?')) {");
    out.println("      location.href = 'delete?id=" +  member.getId() + "'");
    out.println("    }");
    out.println("  });");
    
    out.println("  $('#btnUpdate').click(function(){");
    out.println("    if ( $('#pwd').val().length == 0) {");
    out.println("      alert('패스워드는 필수 입력 항목입니');");
    out.println("      return false;");
    out.println("    }");
        
    out.println("    if ( $('#name').val().length == 0) {");
    out.println("      alert('이름는  필수 입력 항목입니다.');");
    out.println("      return false;");
    out.println("    }");
        
    out.println("    if ( $('#tel').val().length == 0) {");
    out.println("      alert('전화번호는  필수 입력 항목입니다.');");
    out.println("      return false;");
    out.println("    }");
    
    out.println("    if ( $('#addr').val().length == 0) {");
    out.println("      alert('주소는 필수 입력 항목입니다.');");
    out.println("      return false;");
    out.println("    }");
    
    out.println("  });");
    
    out.println("</script>");
    
    out.println("</body>");
    out.println("</html>");
  }
  
}












