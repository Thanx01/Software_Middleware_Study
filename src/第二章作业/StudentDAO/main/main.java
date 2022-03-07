package 第二章作业.StudentDAO.main;

import 第二章作业.StudentDAO.bean.Student;
import 第二章作业.StudentDAO.daoIMP.StudentDAOIMP;

import java.sql.SQLException;
import java.util.List;

public class main {
    public static void main(String[] args) throws SQLException {
        StudentDAOIMP studentDAOIMP=new StudentDAOIMP();
        studentDAOIMP.findAll();
        Student s=new Student();
        s.setName("XZZ09");
        s.setID(404);
        List<Student> l = studentDAOIMP.findAll();


        studentDAOIMP.delete(404);
        l = studentDAOIMP.findAll();
        for(Student n:l){
            System.out.println("name:"+n.getName()+" id:"+n.getID());
        }
        studentDAOIMP.findByID(5);
    }
}
