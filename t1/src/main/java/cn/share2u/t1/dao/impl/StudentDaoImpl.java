package cn.share2u.t1.dao.impl;

import cn.share2u.t1.dao.StduentDao;
import cn.share2u.t1.pojo.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

public class StudentDaoImpl implements StduentDao {
    private SqlSession session;
    public Student select(Student student) {
        try {
            //1加载配置文件
            InputStream i = Resources.getResourceAsStream("mybatis-config.xml");
            //2创建sqlsessionfactory对象,重量级的，线程安全的，应该为单例获取的方法
            SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(i);
            //3创建sqlsession对象
            SqlSession session = sessionFactory.openSession();
            //第一个参数是映射sqlid
            Student s = session.selectOne("test.select", student);
            session.commit();
            return s;
        }catch (Exception e){
            System.out.println(e);
        }finally {
            if(session != null){
                session.close();
            }
        }

        return null;
    }
}
