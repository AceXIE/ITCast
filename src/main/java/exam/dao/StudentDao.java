package exam.dao;

import exam.domain.Student;
import exam.exception.StudentNotExistException;
import exam.utils.XmlUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import sun.security.provider.certpath.SunCertPathBuilderException;

/**
 * Created by Administrator on 2016/8/21.
 */
public class StudentDao {

    public void add(Student s) {
        try {
            Document document = XmlUtils.getDocument();

            //创建标签
            Element student_tag = document.createElement("student");
            student_tag.setAttribute("idcard", s.getIdcard());
            student_tag.setAttribute("examid", s.getExamid());

            //创建用于封装学生姓名，所在地的标签
            Element name = document.createElement("name");
            Element location = document.createElement("location");
            Element grade = document.createElement("grade");

            name.setTextContent(s.getName());
            location.setTextContent(s.getLocation());
            grade.setTextContent(s.getGrade() +"");

            student_tag.appendChild(name);
            student_tag.appendChild(location);
            student_tag.appendChild(grade);

            document.getElementsByTagName("exam").item(0).appendChild(student_tag);

            XmlUtils.write2Xml(document);

        } catch (Exception e) {
            throw new RuntimeException(e);//unchecked exception,运行异常
        }
    }

    public Student find(String examid) {
        try {
            Document document = XmlUtils.getDocument();

            NodeList list = document.getElementsByTagName("student");
            for (int i = 0; i < list.getLength(); i++) {
                Element s = (Element)list.item(i);
                if (s.getAttribute("examid").equals(examid)) {
                    //找到了
                    Student student = new Student();
                    student.setExamid(examid);
                    student.setIdcard(s.getAttribute("idcard"));

                    student.setName(s.getElementsByTagName("name").item(0).getTextContent());
                    student.setLocation(s.getElementsByTagName("location").item(0).getTextContent());
                    student.setGrade(Double.parseDouble(s.getElementsByTagName("grade").item(0).getTextContent()));

                    return student;
                }
            }
            return null;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void delete(String name) throws StudentNotExistException {
        try {
            Document document = XmlUtils.getDocument();

            NodeList list = document.getElementsByTagName("name");
            for (int i = 0; i < list.getLength(); i++) {
                if (list.item(i).getTextContent().equals(name)) {
                    list.item(i).getParentNode().getParentNode().removeChild(list.item(i).getParentNode());
                    XmlUtils.write2Xml(document);
                    return;
                }
            }

            throw new StudentNotExistException(name + "不存在 !!");

        } catch (StudentNotExistException e) {
            throw e;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
