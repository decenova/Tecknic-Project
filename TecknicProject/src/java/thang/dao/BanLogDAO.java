/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thang.dao;

import db.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;

/**
 *
 * @author Decen
 */
public class BanLogDAO {

    private Connection con;
    private PreparedStatement prestmt;
    private ResultSet rs;

    public BanLogDAO() {
    }

    private void closeConnection() {
        try {
            if (rs != null) {
                rs.close();
            }
            if (prestmt != null) {
                prestmt.close();
            }
            if (con != null) {
                con.close();
            }
        } catch (Exception e) {
        }
    }

    public boolean addBanLog(String reason, int userID, int oldRoleID, int modId, Timestamp banTime) {
        boolean result = false;
        try {
            con = MyConnection.getConnection();
            String sql = "insert into BanLog(BannedUserId,ExRole,ModId,BanTime,Reason) "
                    + "values(?,?,?,?,?)";
            prestmt = con.prepareStatement(sql);
            prestmt.setInt(1, userID);
            prestmt.setInt(2, oldRoleID);
            prestmt.setInt(3, modId);
            prestmt.setTimestamp(4, banTime);
            prestmt.setString(5, reason);
            if (prestmt.executeUpdate() > 0) {
                result = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return result;
    }
}
