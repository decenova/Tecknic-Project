/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thang.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Decen
 */
public class UserDAO {
    private Connection con;
    private PreparedStatement prestmt;
    private ResultSet rs;

    public UserDAO() {
    }
    private void closeConnection(){
        try {
            if (rs != null)
                rs.close();
            if (prestmt != null)
                prestmt.close();
            if (con != null)
                con.close();
        } catch (Exception e) {
        }
    }
}
