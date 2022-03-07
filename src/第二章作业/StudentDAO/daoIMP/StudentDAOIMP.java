package 第二章作业.StudentDAO.daoIMP;
import 第二章作业.StudentDAO.bean.Student;
import 第二章作业.StudentDAO.dao.StudentDAO;
import java.sql.*;
import java.util.ArrayList;
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

			int i=pstmt.executeUpdate();
			if (i>0){
				System.out.println("Insert Sucessfully!");
			}
			pstmt.close();
			conn.close();
		}
		catch(Exception e){  }
	}

	public void update(Student s){
		String sql="update student set id =? where name=?";
		PreparedStatement pstmt = null;
		DataBaseConnection conn = null;

		try{
			conn=new DataBaseConnection();
			pstmt = conn.getConnection().prepareStatement(sql);
			pstmt.setObject(2,s.getName());
			pstmt.setObject(1,s.getID());

			int i=pstmt.executeUpdate();
			if (i>0){
				System.out.println("Update Sucessfully!");
			}
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void delete(int id) throws SQLException {
		String sql="delete from student where id=?";
		DataBaseConnection conn=null;
		PreparedStatement pstmt=null;
	try{
		conn = new DataBaseConnection();

		pstmt=conn.getConnection().prepareStatement(sql);
		pstmt.setObject(1,id);
		int i=pstmt.executeUpdate();
		if (i>0){
			System.out.println("Delete Sucessfully!");
		}
		pstmt.close();
		conn.close();
	} catch (SQLException e) {
		e.printStackTrace();
	}

	}

	public List<Student> findAll() throws SQLException {
		String sql = "select * from student";
		DataBaseConnection con = null;
		PreparedStatement pstmt = null;
		ResultSet resultSet = null;

		List<Student> stu = null;
		try {
			con = new DataBaseConnection();

			pstmt = con.getConnection().prepareStatement(sql);
			resultSet = pstmt.executeQuery();
			stu = new ArrayList<Student>(1000);

			while (resultSet.next()) {
				Student s = new Student();
				s.setID((Integer) resultSet.getObject("id"));
				s.setName((String) resultSet.getObject("name"));
				stu.add(s);
			}
			pstmt.close();
			resultSet.close();
			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return stu;
	}

	public Student findByID(int i) throws SQLException {
		String sql = "Select name from student where id=?";
		DataBaseConnection conn = null;
		PreparedStatement pst = null;
		ResultSet resultSet = null;
		Student s = null;
		try {
			conn = new DataBaseConnection();

			pst = conn.getConnection().prepareStatement(sql);
			pst.setObject(1, i);
			resultSet = pst.executeQuery();
			while (resultSet.next()) {
				System.out.println(resultSet.getObject("name"));
			}
			s = new Student();

			pst.close();
			resultSet.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return s;
	}

}
