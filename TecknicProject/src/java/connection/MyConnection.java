/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connection;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author hoanh
 */
public class MyConnection {
    public static Connection getConnection() {
        try {
           Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
           Connection cnn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Tecknic", "sa", "password");
           return cnn;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
