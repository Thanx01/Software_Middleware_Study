package utils;
import JdbcUtils.JdbcUtils;

import java.sql.*;

public class TestDelete{
    public static void main(String[] args) throws SQLException {
        Connection conn=null;
        PreparedStatement st=null;
        try{
            conn=JdbcUtils.getConnection();
            //区别
            //使用？占位符代替参数
            String sql="delete from student where";
            st=conn.prepareStatement(sql);//预编译sql,先写sql,然后不执行

            //手动给参数赋值，前者为下标，后者为value


            //执行
            int i=st.executeUpdate();
            if (i>0){
                System.out.println("delete sucess! i="+i);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
