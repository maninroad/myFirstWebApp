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
                personalInfo.setPullUp(resultSet.getInt("pullUp"));
                personalInfo.setAge(resultSet.getInt("age"));
                personalInfo.setGender(resultSet.getInt("gender"));
                personalInfo.setHeartBeat(resultSet.getInt("heartBeat"));
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

    public static boolean updatePersonalInfo(int id,double height,double weight,int blood,int sitUpNumber,int pushUpNumber,int pullUp,int gender,int age,int heartBeat) {
        //获得数据库的连接对象
        Connection connection = DBmanager.getConnection();
        PreparedStatement preparedStatement = null;
        int resultSet = 0;

        //生成SQL代码
        StringBuilder sqlStatement = new StringBuilder();
        sqlStatement.append("update PersonInfo set height=?,weight=?,blood=?,sitUpNumber=?,pushUpNumber=?,pullUp=?,age=?,gender=?,heartBeat=? where Id=?");
        //设置数据库的字段值
        try {
            preparedStatement = connection.prepareStatement(sqlStatement.toString());
            preparedStatement.setDouble(1,height );
            preparedStatement.setDouble(2,weight );
            preparedStatement.setInt(3,blood );
            preparedStatement.setInt(4,sitUpNumber );
            preparedStatement.setInt(5,pushUpNumber);
            preparedStatement.setInt(6,pullUp);
            preparedStatement.setInt(7,age);
            preparedStatement.setInt(8,gender);
            preparedStatement.setInt(9,heartBeat);
            preparedStatement.setInt(10,id );
            resultSet = preparedStatement.executeUpdate();
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

    public static boolean InsertPersonalInfo(int id,double height,double weight,int blood,int sitUpNumber,int pushUpNumber,int pullUp,int age,int gender,int heartBeat) {
        //获得数据库的连接对象
        Connection connection = DBmanager.getConnection();
        PreparedStatement preparedStatement = null;
        int resultSet = 0;

        //生成SQL代码
        StringBuilder sqlStatement = new StringBuilder();
        sqlStatement.append("Insert into PersonInfo(Id,height,weight,blood,sitUpNumber,pushUpNumber,pullUp,age,gender,heartBeat) value(?,?,?,?,?,?,?,?,?,?)");
        //设置数据库的字段值
        try {
            preparedStatement = connection.prepareStatement(sqlStatement.toString());
            preparedStatement.setInt(1,id );
            preparedStatement.setDouble(2,height );
            preparedStatement.setDouble(3,weight );
            preparedStatement.setInt(4, blood );
            preparedStatement.setInt(5,sitUpNumber );
            preparedStatement.setInt(6,pushUpNumber);
            preparedStatement.setInt(7,pullUp);
            preparedStatement.setInt(8,age);
            preparedStatement.setInt(9,gender);
            preparedStatement.setInt(10,heartBeat);
            resultSet = preparedStatement.executeUpdate();
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
