package net.implementist.myFirstWebApp;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

public class DBmanager extends HttpServlet {

    ServletConfig config;                             //定义一个ServletConfig对象
    private static String username="root";                   //定义的数据库用户名
    private static String password="199925";                   //定义的数据库连接密码
    private static String url= "jdbc:mysql://localhost:3306/myfisrtwebapp?useunicuee=true&characterEncoding=utf8&serverTimezone=UTC";                        //定义数据库连接URL
    private static String driver= "com.mysql.cj.jdbc.Driver";
    private static Connection connection;             //定义连接

    @Override
    public void init(ServletConfig config) throws ServletException {

    }

    public static Connection getConnection() {
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException | SQLException ex) {
            //Logger.getLogger(DBmanager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return connection;
    }

    public static void closeAll(Connection connection, Statement statement,
                                ResultSet resultSet) {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException ex) {
            //Logger.getLogger(DBmanager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
