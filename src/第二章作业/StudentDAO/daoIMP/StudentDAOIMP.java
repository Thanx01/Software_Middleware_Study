package 第二章作业.StudentDAO.daoIMP;
import 第二章作业.StudentDAO.bean.Student;
import 第二章作业.StudentDAO.dao.StudentDAO;
import java.sql.*;

import connection.DataBaseConnection;

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

	public void update(Student s）{   作业   }

	public void delete(String iD){  作业    }

	public List findAll(){   作业  }

	public Student findByID(long iD){   作业  }

}
