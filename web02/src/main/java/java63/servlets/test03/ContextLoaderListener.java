package java63.servlets.test03;

import java.io.InputStream;

import java63.servlets.test03.dao.ProductDao;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/* 공통으로 사용하는 자원은 보통 Swervletcontext에 보관한다.
 * ServletContext => 웹애플리케이션 시작시 생성됨.종료하면 제거됨.
 * HttpSession => 최소 요청시 생성. 타임아웃 또는 무효화 명령 시 제거됨.\
 * HttpServletRequest => 요청 때마다 생성. 응답 후 제거도미.
 * PageContext => JSP에서 사용됨
 *         각JSP 
 *         
 *
 */

//@WebListener
public class ContextLoaderListener implements ServletContextListener {
  //웹에플리케이션이 시작할때 호출됨
  // 서블릿이 사용할 공통 자원을 준비

  @Override
  public void contextInitialized(ServletContextEvent sce) {
    try {
      ServletContext ctx = sce.getServletContext();
      InputStream inputStream = 
          Resources.getResourceAsStream(ctx.getInitParameter("mybatisConfig"));
      SqlSessionFactory sqlSessionFactory = 
          new SqlSessionFactoryBuilder().build(inputStream);

      ProductDao productDao = new ProductDao();
      productDao.setSqlSessionFactory(sqlSessionFactory);

      //ServletContext보관소에 객체 저장
      ctx.setAttribute("productDao", productDao);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  //웹에플리케시연이 종료할때
  //서블릿이 사용한 자원을 해제할 때

  @Override
  public void contextDestroyed(ServletContextEvent sce) {
  }
}
