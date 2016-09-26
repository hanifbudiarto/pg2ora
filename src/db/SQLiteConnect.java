/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Muhammad Hanif B
 */
public class SQLiteConnect {
    private static SQLiteConnect sqliteInstance = null;
    private Connection connection = null;
    
    private SQLiteConnect () {        
        System.out.println("Creating New Instance on Singleton-Pattern");
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:C:/pg2ora/pg2ora.db");
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(SQLiteConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static SQLiteConnect getInstance () {
        if ( sqliteInstance == null ) {
            System.out.println("No Instance, Ready to Create New");
            sqliteInstance = new SQLiteConnect();
        }
        else {
            System.out.println("Already Created!");
        }
        return sqliteInstance;
    }    
    
    public Connection getConnection() {
        return connection;
    }
    
    public ResultSet query(String query) throws SQLException {
        Statement statement = sqliteInstance.connection.createStatement();
        sqliteInstance = null;
        return statement.executeQuery(query);
    }
}
