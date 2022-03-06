package 第二章作业.StudentDAO.dao;
import 第二章作业.StudentDAO.bean.*;
import java.util.*;
public interface StudentDAO{
    public void insert(Student s);
    public void update(Student s);
    public void delete(String id);
    public Student findByID(int iD);
    public List<Student> findAll();
} 

