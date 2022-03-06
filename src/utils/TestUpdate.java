package utils;
import JdbcUtils.JdbcUtils;

import java.sql.*;

public class TestUpdate{
    public static void main(String[] args) throws SQLException {
        Connection conn=null;
        PreparedStatement st=null;
        try{
            conn=JdbcUtils.getConnection();
            //区别
            //使用？占位符代替参数
            String sql="update student set class=? where name=?";
            st=conn.prepareStatement(sql);

            //手动给参数赋值，前者为下标，后者为value
            st.setObject(1,"02");
            st.setObject(2,"xzz05");
            //执行
            int i=st.executeUpdate();
            if (i>0){
                System.out.println("Update sucess! i="+i);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
