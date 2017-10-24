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
import java.util.ArrayList;
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

    public UserDTO loadUser(int userID) {
        UserDTO user = new UserDTO();
        try {
            conn = MyConnection.getConnection();
            String sql = "select u.Username,u.Name,u.Avatar,u.Gender,u.DateOfBirth,"
                    + "u.Email,u.PhoneNum,u.Address,u.DateOfJoin,r.Name as [RoleName]"
                    + "from [User] u inner join Role r on u.RoleId = r.Id where u.ID = ?";
            preStm = conn.prepareStatement(sql);
            preStm.setInt(1, userID);
            rs = preStm.executeQuery();
            if (rs.next()) {
                user.setUsername(rs.getString("Username"));
                user.setName(rs.getString("Name"));
                String avatar = rs.getString("Avatar");
                if (avatar != null) //nếu không rỗng thì lấy avatar trong db. ngược lại thì lấy avatar default
                {
                    user.setAvatar(avatar);
                }
                user.setGender(rs.getString("Gender").charAt(0));
                user.setDob(rs.getTimestamp("DateOfBirth"));
                user.setEmail(rs.getString("Email"));
                user.setPhoneNum(rs.getString("PhoneNum"));
                user.setAddress(rs.getString("Address"));
                user.setDoj(rs.getTimestamp("DateOfJoin"));
                user.setRole(rs.getString("RoleName"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return user;
    }

    public ArrayList<UserDTO> getAllUser() { //trừ thằng admin và moderator
        ArrayList<UserDTO> result = new ArrayList<>();
        try {
            conn = MyConnection.getConnection();
            String sql = "select u.ID, u.Username,u.Name,u.Email,r.Name as [RoleName]"
                    + "from [User] u inner join Role r on u.RoleId = r.Id";
            preStm = conn.prepareStatement(sql);
            rs = preStm.executeQuery();
            UserDTO user;
            while (rs.next()) {
                user = new UserDTO();
                user.setId(rs.getInt("ID"));
                user.setUsername(rs.getString("Username"));
                user.setName(rs.getString("Name"));
                user.setEmail(rs.getString("Email"));
                user.setRole(rs.getString("RoleName"));
                result.add(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return result;

    }

    public boolean updateUser(UserDTO user) {
        boolean result = false;
        try {
            conn = MyConnection.getConnection();
            String sql = "update [User] set Name=?,Gender=?,DateOfBirth=?,"
                    + "Email=?,PhoneNum=?,Address=?,Avatar=? where Username=?";
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, user.getName());
            preStm.setString(2, String.valueOf(user.getGender()));
            preStm.setTimestamp(3, user.getDob());
            preStm.setString(4, user.getEmail());
            preStm.setString(5, user.getPhoneNum());
            preStm.setString(6, user.getAddress());
            preStm.setString(7, user.getAvatar());
            preStm.setString(8, user.getUsername());
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

    public ArrayList<UserDTO> findByLikeName(String searchName) {
        ArrayList<UserDTO> result = new ArrayList<>();
        try {
            conn = MyConnection.getConnection();
            String sql = "select u.ID, u.Username, u.Name, u.Email, r.Name as RoleName "
                    + "from [User] u inner join Role r on u.RoleId = r.Id where u.Name like ?";
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, "%" + searchName + "%");
            rs = preStm.executeQuery();
            UserDTO user;
            while (rs.next()) {
                user = new UserDTO();
                user.setId(rs.getInt("ID"));
                user.setUsername(rs.getString("Username"));
                user.setName(rs.getString("Name"));
                user.setEmail(rs.getString("Email"));
                user.setRole(rs.getString("RoleName"));
                result.add(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return result;
    }
}
