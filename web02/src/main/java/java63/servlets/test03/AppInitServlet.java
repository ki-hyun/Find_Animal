package java63.servlets.test03;

import java.io.IOException;
import java.io.InputStream;
import java63.servlets.test03.dao.ProductDao;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


/*  <servlet>
    <servlet-name>Hello</servlet-name>
    <servlet-class>java63.servlets.Hello</servlet-class>
  <load-on-startup>1</load-on-startup>
  </servlet>
 */
@WebServlet(
   loadOnStartup = 1
    )
public class AppInitServlet extends GenericServlet {
  /**
   * 
   */
  private static final long serialVersionUID = 1L;
  public static ProductDao productDao;
  
  public AppInitServlet() {
      System.out.println("AppInitServlet 생성됨.");
  }
  
  /*
<servlet>
<servlet-name>...</servlet-name>
<servlet-class> ...</servlert-class>
<init-param>
<param-name>키</param-name>
<param-vlaue> 값</param-value>
</init-param>
</servlet>


설정값을 꺼내는 방법
ServletComfig 의 getInitParameter("키")
   *
   */
  
  @Override
  public void init() throws ServletException {
    try {
      InputStream inputStream = 
          Resources.getResourceAsStream(this.getInitParameter("mybatisConfig"));
      SqlSessionFactory sqlSessionFactory = 
          new SqlSessionFactoryBuilder().build(inputStream);
      
      productDao = new ProductDao();
      productDao.setSqlSessionFactory(sqlSessionFactory);
      
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  
  @Override
  public void service(ServletRequest req, ServletResponse res)
      throws ServletException, IOException {}
}


















