/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tung.dao;

import db.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import tung.dto.UserDTO;

/**
 *
 * @author hoanh
 */
public class UserDAO {

    private Connection conn;
    private PreparedStatement preStm;
    private ResultSet rs;

    public UserDAO() {
    }

    public void closeConnection() {
        try {
            if (rs != null) {
                rs.close();
            }
            if (preStm != null) {
                preStm.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean updateUser(UserDTO user) {
        boolean result = false;
        try {
            conn = MyConnection.getConnection();
            String sql = "update User set Name=?,Gender=?,DateOfBirth=?,"
                    + "Email=?,PhoneNum=?,Address=?,AvatarLink=?";
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, user.getName());
            preStm.setNull(2, user.getGender());
            preStm.setTimestamp(3, user.getDob());
            preStm.setString(4, user.getEmail());
            preStm.setString(5, user.getPhoneNum());
            preStm.setString(6, user.getAddress());
            preStm.setString(7, user.getAvatar());
            if (preStm.executeUpdate() > 0) {
                result = true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }

        return result;
    }

    public UserDTO findByLikeUserID(int UserID) {
        UserDTO user = null;
        try {
            conn = MyConnection.getConnection();
            String sql = "select u.Username,u.Name,u.Gender,u.DateOfBirth,"
                    + "u.Email,u.PhoneNum,u.Address,r.Name as RoleName"
                    + "from User u inner join Role r on u.RoleId = r.Id where Id = ?";
            preStm = conn.prepareStatement(sql);
            rs = preStm.executeQuery();

            if (rs.next()) {
                String username = rs.getString("Username");
                String name = rs.getString("u.Name");
                char gender = rs.getString("Gender").charAt(0);
                Timestamp dob = rs.getTimestamp("DateOfBirth");
                String email = rs.getString("Email");
                String phone = rs.getString("PhoneNum");
                String address = rs.getString("Address");
                String role = rs.getString("RoleName");
                user = new UserDTO(username, name, gender, dob, email, phone, address, role);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return user;
    }
}
