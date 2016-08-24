package exam.test;

import exam.dao.StudentDao;
import exam.domain.Student;
import org.junit.Test;

/**
 * Created by Administrator on 2016/8/21.
 */
public class StudentDaoTest {

    @Test
    public void testAdd() {
        StudentDao dao = new StudentDao();
        Student s = new Student();
        s.setIdcard("555");
        s.setExamid("555");
        s.setGrade(233);
        s.setLocation("河南");
        s.setName("wuwuw");

        dao.add(s);
    }

}
