package 第二章作业.StudentDAO.dao;
import 第二章作业.StudentDAO.bean.*;

import java.sql.SQLException;
import java.util.*;
public interface StudentDAO{
    public void insert(Student s);
    public void update(Student s);
    public void delete(int id) throws SQLException;
    public Student findByID(int iD) throws SQLException;
    public List<Student> findAll() throws SQLException;
} 

