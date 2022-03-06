package 第二章作业.StudentDAO.daoIMP;
import 第二章作业.StudentDAO.bean.Student;
import 第二章作业.StudentDAO.dao.StudentDAO;
import java.sql.*;
import java.util.List;

import 第二章作业.StudentDAO.connection.DataBaseConnection;

public class StudentDAOIMP implements StudentDAO{
	// 添加操作
	public void insert(Student s){
		String sql = "INSERT INTO student (id, name) values (?,?)";
		PreparedStatement pstmt = null;
		DataBaseConnection conn = null;
		//针对数据库的具体操作
		try{
			conn = new DataBaseConnection();

			pstmt = conn.getConnection().prepareStatement(sql);
			pstmt.setLong(1,s.getID());
			//pstmt.setString(1,s.getID());
			pstmt.setString(2,s.getName());

			pstmt.executeUpdate();
			pstmt.close();
			conn.close();
		}
		catch(Exception e){  }
	}

	public void update(Student s){
		String sql="select * from student";
		PreparedStatement pstmt = null;
		DataBaseConnection conn = null;

		try{
			conn=new DataBaseConnection();
			pstmt = conn.getConnection().prepareStatement(sql);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void delete(String id){  作业    }

	public List<Student> findAll(){   作业 return null;
	}

	public Student findByID(int id){   作业  }

}
