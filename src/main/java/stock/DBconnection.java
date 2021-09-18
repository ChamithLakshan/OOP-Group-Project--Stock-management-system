/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stock;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Niros
 */
public class DBconnection {
    private Connection con;
    private static DBconnection dbConnection;
    
    private DBconnection(){
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventory","root","");
        } catch (SQLException ex) {
            Logger.getLogger(DBconnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static DBconnection getDBconnection(){
        if(null == dbConnection){
            dbConnection = new DBconnection();
        }
        return dbConnection;
    }
    
    
    public Connection getConnection(){
        return this.con;
    }
    
    public void close(){
        if(con != null){
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(DBconnection.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
