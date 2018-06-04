package cn.share2u.t1.dao.impl;

import cn.share2u.t1.dao.StduentDao;
import cn.share2u.t1.pojo.Student;
import org.junit.Test;

import static org.junit.Assert.*;

public class StudentDaoImplTest {

    @Test
    public void select() {
        StduentDao studentDao = new StudentDaoImpl();
        Student s = new Student();
        s.setId(1);
        Student s1 = studentDao.select(s);
        System.out.println(s1.getName());

    }
}