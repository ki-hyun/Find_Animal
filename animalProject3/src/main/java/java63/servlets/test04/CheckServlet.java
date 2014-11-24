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


@WebServlet("/test04/member/check2")
public class CheckServlet extends GenericServlet{

	private static final long serialVersionUID = 1L;
	static String addr;
	static String tel;

	@Override
	public void service(ServletRequest request, ServletResponse response)
			throws ServletException, IOException {
		 // TODO Auto-generated method stub
		HttpServletResponse orginResponse = (HttpServletResponse)response;
		
		try{
 		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		
		
		
		MemberDao memberDao = (MemberDao)this.getServletContext()
                                             .getAttribute("memberDao");
		
		Member member = memberDao.checkIn(id, pwd);
		
		
		System.out.println(member.getAddr() + "getAddr");
		
		
		 addr = member.getAddr();
		 tel = member.getTel();
		
//		BoardAddServlet boardAddServlet = new BoardAddServlet(addr,tel);
		
		orginResponse.sendRedirect("boardAddF?addr="+addr+"&tel="+tel+"&id="+id);
		
		}catch(NullPointerException e){
			orginResponse.sendRedirect("list");	
		}
		
		
		
//		if(member.getId()!=null){
//	    orginResponse.sendRedirect("board-form.html");
//		}else{
//		orginResponse.sendRedirect("list");	
//		}
		
	}

}
