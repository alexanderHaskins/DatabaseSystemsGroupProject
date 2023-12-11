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
public class Admin {
    Connection connection;
    public DisplayPublisher displayPublisher;
    public DisplayConsoles displayConsole;
    public DisplayGamesClass displayGame;
    public Admin(Connection conn){
        connection=conn;
        displayPublisher=new DisplayPublisher(conn);
        displayConsole=new DisplayConsoles(conn);
        displayGame=new DisplayGamesClass(conn);
    }
    public void addGame(){
        String InsertString="INSERT INTO game(GameID,Name,PublisherID,Genere,Rating,Description) VALUES (?,?,?,?,?,?);";
        try{
            Scanner scan = new Scanner(System.in);
            PreparedStatement pstmt = connection.prepareStatement(InsertString);
            //Get user input
            System.out.print("Enter game id:");
            String gameid = scan.nextLine();
            
            System.out.print("Enter game name:");
            String gamename=scan.nextLine();
            
             System.out.print("Enter publisher id:");
            String pubid = scan.nextLine();
            
            System.out.print("Enter game genre:");
            String genre=scan.nextLine();
            
            System.out.print("Enter game rating:");
            String gameRate=scan.nextLine();
            
            System.out.print("Enter game description:");
            String gameDesc=scan.nextLine();
            //Add input to statement
            pstmt.setInt(1, Integer.parseInt(gameid));
            pstmt.setString(2, gamename);
            pstmt.setInt(3, Integer.parseInt(pubid));
            pstmt.setString(4, genre);
            pstmt.setString(5,gameRate);
            pstmt.setString(6, gameDesc);
            
            //Execute query
            pstmt.executeQuery();
        }catch(SQLException e){
            System.out.println("SQL error with addGame method");
        }
    }
    
    public void addConsole(){
        try{
            String insertString="INSERT INTO console(consoleID,Name,Creator,Price) VALUES(?,?,?,?);";
            Scanner scan = new Scanner(System.in);
            PreparedStatement pstmt = connection.prepareStatement(insertString);
            //Get user input
            System.out.print("Enter console id:");
            String conid = scan.nextLine();
            System.out.print("Enter console name:");
            String conname = scan.nextLine();
            System.out.print("Enter console creator:");
            String concreate = scan.nextLine();
            System.out.print("Enter console price:");
            String conprice = scan.nextLine();
            //Add input to statement
            pstmt.setInt(1, Integer.parseInt(conid));
            pstmt.setString(2, conname);
            pstmt.setString(3, concreate);
            pstmt.setFloat(4, Float.parseFloat(conprice));
            //Execute query
            pstmt.executeQuery();
        }catch(SQLException e){
            System.out.println("SQL error with addGame method");
        }
    }
    public void changeGameDescription(){
        try{
            Scanner scan = new Scanner(System.in);
            String updateString="Update Console SET Description=? Where GameID=?;";
            PreparedStatement pstmt = connection.prepareStatement(updateString);
            System.out.print("Enter game id:");
            String gameid = scan.nextLine();
            System.out.print("Enter the new value for the description:");
            String gamedesc = scan.nextLine();
            pstmt.setString(1, gamedesc);
            pstmt.setInt(2, Integer.parseInt(gameid));
            pstmt.executeQuery();
        }catch(SQLException e){
            System.out.println("SQL error with addGame method");
        }
    }
    public void changeGameName(){
        try{
            Scanner scan = new Scanner(System.in);
            String updateString="Update Console SET Name=? Where GameID=?;";
            PreparedStatement pstmt = connection.prepareStatement(updateString);
            System.out.print("Enter game id:");
            String gameid = scan.nextLine();
            System.out.print("Enter the new value for the name:");
            String gamename = scan.nextLine();
            pstmt.setString(1, gamename);
            pstmt.setInt(2, Integer.parseInt(gameid));
            pstmt.executeQuery();
        }catch(SQLException e){
            System.out.println("SQL error with addGame method");
        }
    }
    public void changeGamePrice(){
        try{
            Scanner scan = new Scanner(System.in);
            String updateString="Update Console SET Price=? Where GameID=?;";
            PreparedStatement pstmt = connection.prepareStatement(updateString);
            System.out.print("Enter game id:");
            String gameid = scan.nextLine();
            System.out.print("Enter the new value for the price:");
            String gameprice = scan.nextLine();
            pstmt.setFloat(1, Float.parseFloat(gameprice));
            pstmt.setInt(2, Integer.parseInt(gameid));
            pstmt.executeQuery();
        }catch(SQLException e){
            System.out.println("SQL error with addGame method");
        }
    }
    public void changeGameRating(){
        try{
            Scanner scan = new Scanner(System.in);
            String updateString="Update Console SET Rating=? Where GameID=?;";
            PreparedStatement pstmt = connection.prepareStatement(updateString);
            System.out.print("Enter game id:");
            String gameid = scan.nextLine();
            System.out.print("Enter the new value for the rating:");
            String gamerate = scan.nextLine();
            pstmt.setString(1, gamerate);
            pstmt.setInt(2, Integer.parseInt(gameid));
            pstmt.executeQuery();
        }catch(SQLException e){
            System.out.println("SQL error with addGame method");
        }
    }
    public void changeConsoleName(){
        try{
            Scanner scan = new Scanner(System.in);
            String updateString="Update console SET Name=? where consoleID=?;";
            PreparedStatement pstmt = connection.prepareStatement(updateString);
            System.out.print("Enter console id:");
            String conid = scan.nextLine();
            System.out.print("Enter the new value for the name:");
            String conname = scan.nextLine();
            pstmt.setString(1, conname);
            pstmt.setInt(2, Integer.parseInt(conid));
            pstmt.executeQuery();

        }catch(SQLException e){
            System.out.println("SQL error with addGame method");
        }
    }
    public void changeConsoleCreator(){
        try{
            Scanner scan = new Scanner(System.in);
            String updateString="Update console SET Creator=? where consoleID=?;";
            PreparedStatement pstmt = connection.prepareStatement(updateString);
            System.out.print("Enter console id:");
            String conid = scan.nextLine();
            System.out.print("Enter the new value for the creator:");
            String concreate = scan.nextLine();
            pstmt.setString(1, concreate);
            pstmt.setInt(2, Integer.parseInt(conid));
            pstmt.executeQuery();

        }catch(SQLException e){
            System.out.println("SQL error with addGame method");
        }
    }
    public void changeConsolePrice(){
        try{
            Scanner scan = new Scanner(System.in);
            String updateString="Update console SET price=? where consoleID=?;";
            PreparedStatement pstmt = connection.prepareStatement(updateString);
            System.out.print("Enter console id:");
            String conid = scan.nextLine();
            System.out.print("Enter the new value for the price:");
            String conprice = scan.nextLine();
            pstmt.setFloat(1, Float.parseFloat(conprice));
            pstmt.setInt(2, Integer.parseInt(conid));
            pstmt.executeQuery();

        }catch(SQLException e){
            System.out.println("SQL error with addGame method");
        }
    }
    public void deleteGame(){
        try{
            Scanner scan = new Scanner(System.in);
            String deleteString="DELETE from game where GameID=?";
            PreparedStatement pstmt = connection.prepareStatement(deleteString);
            System.out.print("Enter game id:");
            String gameid = scan.nextLine();
            pstmt.setInt(1, Integer.parseInt(gameid));
            pstmt.executeQuery();
        }catch(SQLException e){
            System.out.println("SQL error with addGame method");
        }
    }
    public void deleteConsole(){
        try{
            Scanner scan = new Scanner(System.in);
            String deleteString="DELETE from console where consoleID=?";
            PreparedStatement pstmt = connection.prepareStatement(deleteString);
            System.out.print("Enter console id:");
            String conid = scan.nextLine();
            pstmt.setInt(1, Integer.parseInt(conid));
            pstmt.executeQuery();
        }catch(SQLException e){
            System.out.println("SQL error with addGame method");
        }
    }
}
