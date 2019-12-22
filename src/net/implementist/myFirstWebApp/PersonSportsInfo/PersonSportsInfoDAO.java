package net.implementist.myFirstWebApp.PersonSportsInfo;

import net.implementist.myFirstWebApp.DBmanager;
import net.implementist.myFirstWebApp.PersonalInfo.PersonalInfo;
import net.implementist.myFirstWebApp.Step.Step;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PersonSportsInfoDAO {
    public static ArrayList<PersonSportsInfo> queryPersonSportsInfoById(int id) {
        Connection connection = DBmanager.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        //生成SQL代码
        StringBuilder sqlStatement = new StringBuilder();
        sqlStatement.append("SELECT * FROM PersonSportsInfo WHERE Id=?");
        try {
            preparedStatement = connection.prepareStatement(sqlStatement.toString());
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            ArrayList<PersonSportsInfo> personSportsInfos = new ArrayList<>();
            while (resultSet.next()) {
                PersonSportsInfo personSportsInfo = new PersonSportsInfo();
                personSportsInfo.setTime(resultSet.getDate("Time"));
                personSportsInfo.setDuration(resultSet.getInt("Duration"));
                personSportsInfo.setCalorie(resultSet.getDouble("Calorie"));
                personSportsInfo.setType(resultSet.getString("Type"));
                personSportsInfos.add(personSportsInfo);
            }
            return personSportsInfos;
        } catch (SQLException ex) {
            //Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } finally {
            DBmanager.closeAll(connection, preparedStatement, resultSet);
        }
    }

    public static ArrayList<PersonSportsInfo> queryPersonSportsInfoOnSomeDay(int id, String date) {
        Connection connection = DBmanager.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        //生成SQL代码
        StringBuilder sqlStatement = new StringBuilder();
        sqlStatement.append("SELECT * FROM PersonSportsInfo WHERE Id=? and Time=?");
        try {
            preparedStatement = connection.prepareStatement(sqlStatement.toString());
            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, date);
            resultSet = preparedStatement.executeQuery();
            ArrayList<PersonSportsInfo> personSportsInfos = new ArrayList<>();
            while (resultSet.next()) {
                PersonSportsInfo personSportsInfo = new PersonSportsInfo();
                personSportsInfo.setTime(resultSet.getDate("Time"));
                personSportsInfo.setDuration(resultSet.getInt("Duration"));
                personSportsInfo.setCalorie(resultSet.getDouble("Calorie"));
                personSportsInfo.setType(resultSet.getString("Type"));
                personSportsInfo.setSNo(resultSet.getInt("SNo"));
                personSportsInfos.add(personSportsInfo);
            }
            return personSportsInfos;
        } catch (SQLException ex) {
            //Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } finally {
            DBmanager.closeAll(connection, preparedStatement, resultSet);
        }
    }

    public static boolean InsertPersonSportsInfo(int id,String date,double calorie,String type,int duration){
        Connection connection = DBmanager.getConnection();
        PreparedStatement preparedStatement = null;
        int resultSet = 0;

        //生成SQL代码
        StringBuilder sqlStatement = new StringBuilder();
        sqlStatement.append("Insert into PersonSportsInfo(Id,time,calorie,duration,type) value(?,?,?,?,?)");
        try {
            preparedStatement = connection.prepareStatement(sqlStatement.toString());
            preparedStatement.setInt(1, id);
            preparedStatement.setString(2,date);
            preparedStatement.setDouble(3,calorie);
            preparedStatement.setInt(4,duration);
            preparedStatement.setString(5,type);
            resultSet = preparedStatement.executeUpdate();
            if(resultSet!=0) {
                return true;
            }
            else{
                return false;
            }
        } catch (SQLException ex) {
            //Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            DBmanager.closeAll(connection, preparedStatement, null);
        }
    }

    public static boolean UpdatePersonSportsInfo(int sNo,String date,double calorie,String type,int duration){
        Connection connection = DBmanager.getConnection();
        PreparedStatement preparedStatement = null;
        int resultSet = 0;

        //生成SQL代码
        StringBuilder sqlStatement = new StringBuilder();
        sqlStatement.append("Update PersonSportsInfo set time=?,calorie=?,duration=?,type=? where SNo=?");
        try {
            preparedStatement = connection.prepareStatement(sqlStatement.toString());
            preparedStatement.setString(1,date);
            preparedStatement.setDouble(2,calorie);
            preparedStatement.setInt(3,duration);
            preparedStatement.setString(4,type);
            preparedStatement.setInt(5, sNo);
            resultSet = preparedStatement.executeUpdate();
            if(resultSet!=0) {
                return true;
            }
            else{
                return false;
            }
        } catch (SQLException ex) {
            //Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            DBmanager.closeAll(connection, preparedStatement, null);
        }
    }

    public static boolean DeletePersonSportsInfo(int sNo){
        Connection connection = DBmanager.getConnection();
        PreparedStatement preparedStatement = null;
        int resultSet = 0;

        //生成SQL代码
        StringBuilder sqlStatement = new StringBuilder();
        sqlStatement.append("Delete from PersonSportsInfo where SNo=?");
        try {
            preparedStatement = connection.prepareStatement(sqlStatement.toString());
            preparedStatement.setInt(1, sNo);
            resultSet = preparedStatement.executeUpdate();
            if(resultSet!=0) {
                return true;
            }
            else{
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

