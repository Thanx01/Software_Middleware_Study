import java.sql.*;
//我的第一个jdbc程序
public class jdbc {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //加载驱动
        Class.forName("com.mysql.jdbc.Driver");
        //用户信息 url
        String url="jdbc:mysql://localhost:3306/xzz?useUnicode=true&characterEncoding=utf8&useSSL=false";
        String username="root";
        String password="123456";
        //连接成功 数据库对象 Connection代表数据库
        Connection connection= DriverManager.getConnection(url,username,password);
        //执行sql的对象 statement执行sql的对象
        Statement statement=connection.createStatement();

        //执行sql的对象

        String sql="select *from student";
        ResultSet resultSet= statement.executeQuery(sql);
        while(resultSet.next()){
            System.out.println("name:"+resultSet.getObject("name"));
            System.out.println("id:"+resultSet.getObject("id"));
            System.out.println("class:"+resultSet.getObject("class"));
        }
        //释放连接
        resultSet.close();
        statement.close();
        connection.close();
    }

}
