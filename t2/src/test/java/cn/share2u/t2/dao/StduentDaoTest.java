package cn.share2u.t2.dao;


import cn.share2u.model.pojo.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;

public class StduentDaoTest {

    private SqlSession session;
    @Test
    public void select() {
        Student student = new Student();
        student.setId(1);
        try {
            //1加载配置文件
            InputStream i = Resources.getResourceAsStream("mybatis-config.xml");
            //2创建sqlsessionfactory对象,重量级的，线程安全的，应该为单例获取的方法
            SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(i);
            //3创建sqlsession对象
            SqlSession session = sessionFactory.openSession();
            //4动态代理的方法获取Dao接口的实现类
            StduentDao stduentDao = session.getMapper(StduentDao.class);

            Student s = stduentDao.select(student);
            System.out.println(s.getName());
            session.commit();
        }catch (Exception e){
            System.out.println(e);
        }finally {
            if(session != null){
                session.close();
            }
        }
    }
}