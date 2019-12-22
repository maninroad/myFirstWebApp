package net.implementist.myFirstWebApp.Step;

import net.implementist.myFirstWebApp.DBmanager;

import java.sql.*;
import java.util.ArrayList;

public class StepDAO {
    public static ArrayList<Step> queryStep(int id){
        Connection connection = DBmanager.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        //生成SQL代码
        StringBuilder sqlStatement = new StringBuilder();
        sqlStatement.append("SELECT * FROM Step WHERE Id=?");
        try {
            preparedStatement = connection.prepareStatement(sqlStatement.toString());
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            ArrayList<Step> steps=new ArrayList<>();
            while(resultSet.next()) {
                Step step=new Step();
                step.setDate(resultSet.getDate("Date"));
                step.setStepCount(resultSet.getInt("stepCount"));
                steps.add(step);
            }
            return steps;
        } catch (SQLException ex) {
            //Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } finally {
            DBmanager.closeAll(connection, preparedStatement, resultSet);
        }
    }

    public static Step querySomeDayStep(int id,String date){
        Connection connection = DBmanager.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        //生成SQL代码
        StringBuilder sqlStatement = new StringBuilder();
        sqlStatement.append("SELECT * FROM Step WHERE Id=? and Date=?");
        try {
            preparedStatement = connection.prepareStatement(sqlStatement.toString());
            preparedStatement.setInt(1, id);
            preparedStatement.setString(2,date);
            resultSet = preparedStatement.executeQuery();
            Step step=new Step();
            if(resultSet.next()) {
                step.setDate(resultSet.getDate("Date"));
                step.setStepCount(resultSet.getInt("StepCount"));
                return step;
            }
            else{
                return null;
            }
        } catch (SQLException ex) {
            //Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } finally {
            DBmanager.closeAll(connection, preparedStatement, resultSet);
        }
    }

    public static boolean InsertStep(int id,String date,int stepCount){
        Connection connection = DBmanager.getConnection();
        PreparedStatement preparedStatement = null;
        int resultSet = 0;

        //生成SQL代码
        StringBuilder sqlStatement = new StringBuilder();
        sqlStatement.append("Insert into Step (Id,Date,StepCount) value(?,?,?)");
        try {
            preparedStatement = connection.prepareStatement(sqlStatement.toString());
            preparedStatement.setInt(1, id);
            preparedStatement.setString(2,date);
            preparedStatement.setInt(3,stepCount);
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

    public static boolean UpdateStep(int id,String date,int stepCount){
        Connection connection = DBmanager.getConnection();
        PreparedStatement preparedStatement = null;
        int resultSet = 0;

        //生成SQL代码
        StringBuilder sqlStatement = new StringBuilder();
        sqlStatement.append("Update Step set StepCount=? where Id=? and Date=?");
        try {
            preparedStatement = connection.prepareStatement(sqlStatement.toString());
            preparedStatement.setInt(1,stepCount);
            preparedStatement.setInt(2,id);
            preparedStatement.setString(3,date);
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
