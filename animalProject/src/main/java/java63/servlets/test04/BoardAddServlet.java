package java63.servlets.test04;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;


@WebServlet("/test04/member/boardAdd")
public class BoardAddServlet extends GenericServlet{

	private static final long serialVersionUID = 1L;
	
	
	
	public BoardAddServlet(){
		
	}
	
//    public BoardAddServlet(String addr , String tel){
//		this.addr = addr;
//		this.tel = tel;
//	}
//	
//    
//    public void PramTest(){
//    	System.out.println(addr+tel);
//    }

	@Override
	public void service(ServletRequest request, ServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		
//		request.setCharacterEncoding("UTF-8");
		
		PrintWriter out = response.getWriter();
		
//		CheckServlet checkServlet = new CheckServlet();
		
		String addr;
		String tel;
		
//		addr = CheckServlet.addr;
//		tel = CheckServlet.tel;
		
		addr = request.getParameter("addr");
		
		out.println("");
//		System.out.println(addr);
//		PramTest();
		
		out.println("<html>");
		out.println("<head>");
		out.println("<link rel='stylesheet' href='../../css/bootstrap.min.css'>");
		out.println("<link rel='stylesheet' href='../../css/bootstrap-theme.min.css'>");
		out.println("<link rel='stylesheet' href='../../css/common.css'>");
		out.println("</head>");
		out.println("<body>");
//		out.println(addr);
		
		out.println("<div class='container'>");
		out.println("<h1>게시글 등록</h1>");
		out.println("<form class='form-horizontal' role='form' action='add' method='post'>");

		out.println("<div class='form-group'>");
		out.println("<label for='title' class='col-sm-2 control-label'>제목</label>");
		out.println("<div class='col-sm-10'>");
		out.println("<input type='text' class='form-control' id='title' name='title'");
		out.println("placeholder='제목  예) title'>");
		out.println("</div>");
		out.println("</div>");
		out.println("<div class='form-group'>");
		out.println("<label for='fPlace' class='col-sm-2 control-label'>발견장소</label>");
		out.println("<div class='col-sm-10'>");
		out.println("<input type='text' class='form-control' id='fPlace' name='fPlace'");
		out.println("placeholder='발견장소 예) 경기도 화성시..'>");
		out.println("</div>");
		out.println("</div>");

		out.println("<div class='form-group'>");
		out.println("<label for='fDate' class='col-sm-2 control-label'>발견날짜</label>");
		out.println("<div class='col-sm-10'>");
		out.println("<input type='text' class='form-control' id='fDate' name='fDate'");
		out.println("placeholder='발견날짜 예) 2014-11-23'>");
		out.println("</div>");
		out.println("</div>");

		out.println("<div class='form-group'>");
		out.println("<label for='breed' class='col-sm-2 control-label'>품종</label>");
		out.println("<div class='col-sm-10'>");
		out.println("<select class='form-control' name='breed' id='breed'>");
		out.println("<option value='br01'>페르시안고양이</option>");
		out.println("<option value='br02'>브리티시 숏헤어</option>");
		out.println("<option value='br03'>러시안 블루</option>");
		out.println("<option value='br04'>노르웨이 숲</option>");
		out.println("<option value='br05'>터키쉬 앙골라</option>");
		out.println("<option value='br06'>샴 고양이</option>");
		out.println("<option value='br07'>스코티시 폴드</option>");
		out.println("<option value='br08'>셀커크렉스</option>");
		out.println("<option value='br09'>뱅갈 고양이</option>");
		out.println("<option value='br10'>아메리칸 숏헤어</option>");
		out.println("<option value='br11'>아비시니안</option>");
		out.println("<option value='br12'>먼치킨</option>");
		out.println("<option value='br13'>사바나캣</option>");
		out.println("<option value='br14'>메인쿤</option>");
		out.println("<option value='br15'>코리안 숏헤어(korean shorthair)</option>");
		out.println("<option value='br16'>기타</option>");
		out.println("</select>");
		out.println("</div>");
		out.println("</div>");

		out.println("<div class='form-group'>");
		out.println("<label for='gender' class='col-sm-2 control-label'>품종</label>");
		out.println("<div class='col-sm-10'>");
		out.println("<select class='form-control' name='gender' id='gender'>");
		out.println("<option value='남성'>남성</option>");
		out.println("<option value='여성'>여성</option>");
		out.println("</select>");
		out.println("</div>");
		out.println("</div>");


		out.println("<div class='form-group'>");
		out.println("<label for='content' class='col-sm-2 control-label'>내용</label>");
		out.println("<div class='col-sm-10'>");
		out.println("<textarea class='form-control' rows='3' id='content' name='content'></textarea>");
		out.println("</div>");
		out.println("</div>");


		out.println("<div class='form-group'>");
		out.println("<label for='photo' class='col-sm-2 control-label'>사진</label>");
		out.println("<div class='col-sm-10'>");
		out.println("<input type='text' class='form-control' id='photo' name='photo'>");
		out.println("</div>");
		out.println("</div>");


		out.println("<div class='form-group'>");
		out.println("<label for='tel' class='col-sm-2 control-label'>연락처</label>");
		out.println("<div class='col-sm-10'>");
		out.println("<input type='text' class='form-control' id='tel' name='tel'");
		out.println("value='" +addr + "'>");
		out.println("</div>");
		out.println("</div>");


		out.println("<div class='form-group'>");
		out.println("<label for='addr' class='col-sm-2 control-label'>주소</label>");
		out.println("<div class='col-sm-10'>");
		out.println("<input type='text' class='form-control' id='addr' name='addr'") ;
		out.println("value='" +addr + "'>");
		out.println("</div>");
		out.println("</div>");


		out.println("<div class='form-group'>");
		out.println("<div class='col-sm-offset-2 col-sm-10'>");
		out.println("<button id='btnAdd' type='submit' class='btn btn-primary'>등록</button>");
		out.println("<button id='btnCancel' type='button' class='btn btn-primary'>취소</button>");
		out.println("<button id='btnTest' type='button' class='btn btn-primary'>Test</button>");
		out.println("</div>");
		out.println("</div>");
		out.println("</form>");
		out.println("</div>");
		out.println("<script src='../../js/jquery-1.11.1.js'></script>");
		
	}

}
