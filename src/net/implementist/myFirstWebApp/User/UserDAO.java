package net.implementist.myFirstWebApp.User;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import net.implementist.myFirstWebApp.DBmanager;
public class UserDAO {

    public static User queryUser(String userName) {
        //获得数据库的连接对象
        Connection connection = DBmanager.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        //生成SQL代码
        StringBuilder sqlStatement = new StringBuilder();
        sqlStatement.append("SELECT * FROM user WHERE UserName=?");
        //设置数据库的字段值
        try {
            preparedStatement = connection.prepareStatement(sqlStatement.toString());
            preparedStatement.setString(1, userName);
            resultSet = preparedStatement.executeQuery();
            User user = new User();

            if (resultSet.next()) {
                user.setUserName(resultSet.getString("UserName"));
                user.setPassword(resultSet.getString("password"));
                user.setUserId(resultSet.getInt("Id"));
                return user;
            } else {
                return null;
            }
        } catch (SQLException ex) {
            //Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } finally {
            DBmanager.closeAll(connection, preparedStatement, resultSet);
        }
    }
    public static boolean insertUser(String userName,String password){
        Connection connection = DBmanager.getConnection();
        PreparedStatement preparedStatement = null;
        int resultSet = 0;
        //生成SQL代码
        StringBuilder sqlStatement = new StringBuilder();
        sqlStatement.append("insert into user(UserName,password) value(?,?)");
        try {
            preparedStatement = connection.prepareStatement(sqlStatement.toString());
            preparedStatement.setString(1, userName);
            preparedStatement.setString(2, password);
            resultSet = preparedStatement.executeUpdate();

            if (resultSet==1) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException ex) {
            //Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            DBmanager.closeAll(connection, preparedStatement, null);
        }
    }
}
