/**
 *    Copyright ${license.git.copyrightYears} the original author or authors.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package com.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


public class Test {


  @org.junit.Test
  public void testSelect() throws IOException {
    SqlSession sqlSession = getSqlSession("mybatis.xml");
    DemoMapper mapper = sqlSession.getMapper(DemoMapper.class);
    System.out.println(mapper.selectAll("1","test", "name"));
    sqlSession.close();
  }

  @org.junit.Test
  public void testUpdate() throws IOException {
    SqlSession sqlSession = getSqlSession("mybatis.xml");
    DemoMapper mapper = sqlSession.getMapper(DemoMapper.class);
    mapper.update(2, 1000);
    sqlSession.commit();
    sqlSession.close();
  }

  @org.junit.Test
  public void testInsert() throws IOException {
    SqlSession sqlSession = getSqlSession("mybatis.xml");
    DemoMapper mapper = sqlSession.getMapper(DemoMapper.class);
    TestResultMap testResultMap = new TestResultMap();
    testResultMap.setAge(11);
    testResultMap.setName("zz");
    mapper.insert(testResultMap);
    sqlSession.commit();
    sqlSession.close();
  }

  @org.junit.Test
  public void testSelect2() throws IOException {
    SqlSession sqlSession = getSqlSession("mybatis.xml");
    DemoMapper mapper = sqlSession.getMapper(DemoMapper.class);
    System.out.println(mapper.selectByCondition("zz"));
    sqlSession.close();
  }

  private SqlSession getSqlSession(String resource) throws IOException {
    InputStream inputStream = Resources.getResourceAsStream(resource);
    //xml解析完成
    //其实我们mybatis初始化方法 除了XML意外 其实也可以0xml完成
//   new SqlSessionFactoryBuilder().b
    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    //使用者可以随时使用或者销毁缓存
    //从SqlSession对象打开开始 缓存就已经存在
//    java.sql.Connection connection = new java.sql.Connection() {
//    };
//    PreparedStatement preparedStatement = connection.prepareStatement();
//    Connection connection = Connection();
//    connection.ro
    //从调用者角度来讲 与数据库打交道的对象 SqlSession
    return sqlSessionFactory.openSession();
  }
}
