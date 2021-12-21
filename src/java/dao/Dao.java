package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import myservlet.Questions;

public class Dao {
    private static Connection conn=null;
    private static PreparedStatement ps=null;
 static
 {
  try{
      Class.forName("org.postgresql.Driver");
      conn=DriverManager.getConnection("jdbc:postgresql://ec2-3-214-226-101.compute-1.amazonaws.com:5432/d5op0rh8kadv5f",
                 "pfvkayqgubdjwk","4e8c0a45d825a97f420261daef2ff304df8ab5ac4f1e44e918e2584e9f3f69c9");
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
     public static void saveUserEmailId(String name,String emailid,int score){
        try {
            ps=conn.prepareStatement("insert into login values (?,?,?)");
            String newName=name.toLowerCase();
            ps.setString(1,newName);
            ps.setString(2,emailid);
            ps.setInt(3,score);
            boolean rs=ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(Dao.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
     public static ArrayList fetchResults(){
         try {
             ArrayList<String> arrList=new ArrayList<>();
            ps=conn.prepareStatement("Select * from login order by score desc");
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                String temp=rs.getString(1)+","+rs.getInt(3);
                arrList.add(temp);
            }
            for(String s:arrList){
                System.out.println(s);
            }
            return arrList;
        } catch (SQLException ex) {
           ex.printStackTrace();
        }
         return null;
     }
 }
