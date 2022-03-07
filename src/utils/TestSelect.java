package utils;

import JdbcUtils.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestSelect {
    public static void main(String[] args) throws SQLException {
        Connection connection= null;
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;

        try{
            connection=JdbcUtils.getConnection();

            String sql="select * from student where id=? ";

            preparedStatement=connection.prepareStatement(sql);

            preparedStatement.setObject(1,4);

            resultSet=preparedStatement.executeQuery();

            while (resultSet.next()){
                System.out.println(resultSet.getObject("name"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.release(connection,preparedStatement,resultSet);
        }
    }
}
