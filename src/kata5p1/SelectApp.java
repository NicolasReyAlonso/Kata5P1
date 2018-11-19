/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kata5p1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author hiper
 */
public class SelectApp {
    private String URL;
    private Connection con;
    private boolean work;
    
    public SelectApp(String URL){
        this.URL = URL;
        connect();
        
    }
    private void connect(){
        try {
            con = DriverManager.getConnection("jdbc:sqlite:"+URL);
            work = true;
        } catch (SQLException e) {
            System.out.println(e.getMessage()); 
            work = false;
        }
    }
    
    public void SelectAll(String sql){
        if (work){
            try (Statement stmt = con.createStatement(); 
                 ResultSet rs = stmt.executeQuery(sql);
                ){
                ResultSetMetaData rsm;
                rsm = rs.getMetaData();
                while (rs.next()) {
                    for (int i = 1; i<=rsm.getColumnCount(); i++){
                        System.out.print(rs.getObject(i));
                        System.out.print("\t");
                    }
                    System.out.println();
                   
                } 

            } catch (SQLException e) { 
                System.out.println(e.getMessage()); 
            }
        }
    }
    public void insert(String data, String sql) {
        //String sql = "INSERT INTO direcc_email(direccion) VALUES(?)";
        try (
            PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setString(1, data);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    
}
