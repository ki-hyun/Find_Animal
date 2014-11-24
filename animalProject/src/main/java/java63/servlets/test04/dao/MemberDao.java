package java63.servlets.test04.dao;

import java.util.HashMap;
import java.util.List;
import java63.servlets.test04.domain.Member;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberDao {
  @Autowired
  SqlSessionFactory sqlSessionFactory;
  
  public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
    this.sqlSessionFactory = sqlSessionFactory;
  }

  public MemberDao() {}

  public Member selectOne(String id) {
    SqlSession sqlSession = sqlSessionFactory.openSession();
    
    try {
      return sqlSession.selectOne(
        "test04.MemberDao.selectOne", 
        id /* new Integer(no) */);
    } finally {
      sqlSession.close();
    }
  }
  
  public void update(Member member) {
    SqlSession sqlSession = sqlSessionFactory.openSession();
    try {
      sqlSession.update(
        "test04.MemberDao.update", member);
      sqlSession.commit();
    } finally {
      sqlSession.close();
    }
  }
  
  public void delete(String id) {
    SqlSession sqlSession = sqlSessionFactory.openSession();
    try {
      sqlSession.delete(
        "test04.MemberDao.delete", id);
      sqlSession.commit();
    } finally {
      sqlSession.close();
    }
  }
  
  public List<Member> selectList(int pageNo, int pageSize) {
    SqlSession sqlSession = sqlSessionFactory.openSession();
    
    HashMap<String,Object> paramMap = new HashMap<>();
    paramMap.put("startIndex", ((pageNo - 1) * pageSize));
    paramMap.put("pageSize", pageSize);
    
    try {
      return sqlSession.selectList(
        // 네임스페이스 + SQL문 아이디
        "test04.MemberDao.selectList", 
        paramMap /* SQL문을 실행할 때 필요한 값 전달 */);
    } finally {
      sqlSession.close();
    }
  }
  
  public void insert(Member member) {
    SqlSession sqlSession = sqlSessionFactory.openSession();
    try {
      sqlSession.insert(
        "test04.MemberDao.insert", member);
      sqlSession.commit();
    } finally {
      sqlSession.close();
    }
  }
    
    public Member checkIn(String id , String pwd) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        
        HashMap<String,String> paramMap = new HashMap<>();
        paramMap.put("id", id);
        paramMap.put("pwd", pwd);
        
//        System.out.println(paramMap.get("id") + "daoId");
        
        try {
        	return sqlSession.selectOne(
              "test04.MemberDao.checkIn01", paramMap);
          } finally {
            sqlSession.close();
          }
     
  }
}


















