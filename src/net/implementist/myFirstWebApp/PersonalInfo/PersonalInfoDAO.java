package net.implementist.myFirstWebApp.PersonalInfo;

import net.implementist.myFirstWebApp.DBmanager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonalInfoDAO {
    public static PersonalInfo queryPersonalInfo(int id) {
        //获得数据库的连接对象
        Connection connection = DBmanager.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        //生成SQL代码
        StringBuilder sqlStatement = new StringBuilder();
        sqlStatement.append("SELECT * FROM PersonInfo WHERE Id=?");
        //设置数据库的字段值
        try {
            preparedStatement = connection.prepareStatement(sqlStatement.toString());
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            PersonalInfo personalInfo=new PersonalInfo();

            if (resultSet.next()) {
                personalInfo.setHeight(resultSet.getDouble("height"));
                personalInfo.setWeight(resultSet.getDouble("weight"));
                personalInfo.setBlood(resultSet.getInt("blood"));
                personalInfo.setSitupNumber(resultSet.getInt("sitUpNumber"));
                personalInfo.setPushupNumber(resultSet.getInt("pushUpNumber"));
                return personalInfo;
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

    public static boolean updatePersonalInfo(int id,double height,double weight,int blood,int sitUpNumber,int pushUpNumber) {
        //获得数据库的连接对象
        Connection connection = DBmanager.getConnection();
        PreparedStatement preparedStatement = null;
        int resultSet = 0;

        //生成SQL代码
        StringBuilder sqlStatement = new StringBuilder();
        sqlStatement.append("update PersonInfo set height=?,weight=?,blood=?,sitUpNumber=?,pushUpNumber=? where Id=?");
        //设置数据库的字段值
        try {
            preparedStatement = connection.prepareStatement(sqlStatement.toString());
            preparedStatement.setDouble(1,height );
            preparedStatement.setDouble(1,weight );
            preparedStatement.setInt(1,blood );
            preparedStatement.setInt(1,sitUpNumber );
            preparedStatement.setInt(1,pushUpNumber);
            preparedStatement.setInt(1,id );
            resultSet = preparedStatement.executeUpdate();
            PersonalInfo personalInfo=new PersonalInfo();

            if (resultSet!=0) {
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
