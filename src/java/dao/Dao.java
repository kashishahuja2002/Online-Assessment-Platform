package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import myservlet.Questions;

public class Dao {
    private static Connection conn=null;
    private static PreparedStatement ps=null;
 static
 {
  try{
      Class.forName("org.postgresql.Driver");
      conn=DriverManager.getConnection("jdbc:postgresql://ec2-18-209-153-180.compute-1.amazonaws.com:5432/dch2gf0ipap4sd",
                 "lwqysbtmwwbjer","400d2cdd257e4ccb81c34c87447ca950cfb7c6cf489112f90047907b1fb03869");
      System.out.println("Connection opened successfully");
  }
  catch(ClassNotFoundException | SQLException ex)
  {
      System.out.println("Error in contextInitialized:"+ex);
  } 
 }
 
 public static HashSet getQuestions(){
        try {
            ps=conn.prepareStatement("select * from questions");
            HashSet arrList=new HashSet();
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                Questions ques=new Questions(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6));
                arrList.add(ques);
            }
            return arrList;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
 }
 public static String login(String name,String emailid){
        try {
            ps=conn.prepareStatement("Select * from login where name=? and emailid=?");
            String newName=name.toLowerCase();
            ps.setString(1,newName);
            ps.setString(2,emailid);
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                return rs.getString(1);
            }
            else{
                return null;
            }
        } catch (SQLException ex) {
           ex.printStackTrace();
        }
     return null;
    }
     
 }
