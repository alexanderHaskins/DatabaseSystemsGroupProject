/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package databasesystemsgroupproject;
import java.sql.*;
import java.util.*;
/**
 *
 * @author alexj
 */
public class DisplayPublisher {
    Connection connection;
    public DisplayPublisher(Connection conn){
        connection=conn;
    }
    public void getPublisher(boolean DisplayId){
        try{
        String getString="SELECT PublisherID,Name,Description,NetWorth FROM publisher;";
        PreparedStatement pstmt = connection.prepareStatement(getString);
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
            if(DisplayId){
                System.out.println("Publisher ID: " + rs.getInt(1));
            }
               System.out.println("Publisher Name: " + rs.getString(2));
               System.out.println("Publisher Description: " + rs.getString(3));
               System.out.println("Publisher NetWorth: " + rs.getFloat(4));
            }
        }catch(SQLException e){
            System.out.println("SQL error with getConsoles method");
        }
    }
    public void getPublisherGames(){
        try{
            Scanner scan = new Scanner(System.in);
            String getString="SELECT game.Name,publisher.Name FROM game\n" +
                             "INNER JOIN\n" +
                             "publisher\n" +
                             "ON game.PublisherID=publisher.PublisherID\n" +
                             "WHERE game.PublisherID=?;";
            PreparedStatement pstmt = connection.prepareStatement(getString);
            System.out.print("Enter publisher ID:");
            String pubid = scan.nextLine();
            pstmt.setInt(1, Integer.parseInt(pubid));
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                System.out.println("Game Name: " + rs.getString(1));
                System.out.println("Publisher Name: " + rs.getString(2));
            }
        }catch(SQLException e){
            System.out.println("SQL error with getConsoles method");
        }
    }
    public void getPublisherTotal(){
        try{
            Scanner scan = new Scanner(System.in);
            String getString="SELECT Count(*) FROM game\n" +
                             "WHERE PublisherID=?;";
            PreparedStatement pstmt = connection.prepareStatement(getString);
            System.out.print("Enter publisher ID:");
            String pubid = scan.nextLine();
            pstmt.setInt(1, Integer.parseInt(pubid));
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                System.out.println("Count: " + rs.getInt(1));
            }
        }catch(SQLException e){
            System.out.println("SQL error with getConsoles method");
        }
    }
}
