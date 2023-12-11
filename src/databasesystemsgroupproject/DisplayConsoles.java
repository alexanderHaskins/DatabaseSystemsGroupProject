package databasesystemsgroupproject;


import java.sql.*;
import java.util.*;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author alexj
 */
public class DisplayConsoles {
    Connection connection;
    public DisplayConsoles(Connection conn){
        connection=conn;
    }
    public void getConsoles(){
        try{
        String getString="SELECT Name,Creator,Price FROM console;";
        PreparedStatement pstmt = connection.prepareStatement(getString);
        ResultSet rs = pstmt.executeQuery();
         while (rs.next()) {
                
               System.out.println("Console Name: " + rs.getString(1));
               System.out.println("Console Creator: " + rs.getString(2));
               System.out.println("Console Price: " + rs.getFloat(3));
            }
        }catch(SQLException e){
            //System.out.println("SQL error with getConsoles method");
        }
    }
}
