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
import thang.dto.UserDTO;

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

    public UserDTO checkLogin(String username, String password) {
        UserDTO dto = new UserDTO();
        dto.setRole("false");
        try {
            con = MyConnection.getConnection();
            prestmt = con.prepareStatement("select [User].Name, [User].[Password], [User].Avatar, [Role].Name,[User].Id \n"
                    + "from [User] inner join [Role] on [User].RoleId = [Role].Id \n"
                    + "where Username = ? and [Password] = ?");
            prestmt.setString(1, username);
            prestmt.setString(2, password);
            rs = prestmt.executeQuery();
            if (rs.next() && password.equals(rs.getString("Password"))) {
                dto.setUsername(username);
                dto.setName(rs.getString(1));
                if (rs.getString(3) != null)
                    dto.setAvatar(rs.getString(3));
                dto.setRole(rs.getString(4));
                dto.setId(rs.getInt(5));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return dto;
    }
    public boolean createUser(UserDTO user) {
        boolean result = false;
        try {
            con = MyConnection.getConnection();
            String sql = "insert into [User](Username,[Password],Name,Gender,DateOfBirth,"
                    + "DateOfJoin,Email,PhoneNum,Address,RoleId) values (?,?,?,?,?,?,?,?,?,?)";
            prestmt = con.prepareStatement(sql);
            prestmt.setString(1, user.getUsername());
            prestmt.setString(2, user.getPassword());
            prestmt.setString(3, user.getName());
            prestmt.setString(4, String.valueOf(user.getGender()));
            prestmt.setTimestamp(5, user.getDob());
            prestmt.setTimestamp(6, user.getDoj());
            prestmt.setString(7, user.getEmail());
            prestmt.setString(8, user.getPhoneNum());
            prestmt.setString(9, user.getAddress());
            prestmt.setInt(10, user.getRoleId());
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
    public boolean changePassword(String username, String password) {
        boolean result = false;
        try {
            con = MyConnection.getConnection();
            String sql = "update [User] set Password=? where Username=?";
            prestmt = con.prepareStatement(sql);
            prestmt.setString(1, password);
            prestmt.setString(2, username);
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
    public boolean changePassword(int userId, String password) {
        boolean result = false;
        try {
            con = MyConnection.getConnection();
            String sql = "update [User] set Password=? where Id=?";
            prestmt = con.prepareStatement(sql);
            prestmt.setString(1, password);
            prestmt.setInt(2, userId);
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
    public boolean updateRole(int userId, int roleId) {
        boolean result = false;
        try {
            con = MyConnection.getConnection();
            String sql = "update [User] set RoleId=? where Id=?";
            prestmt = con.prepareStatement(sql);
            prestmt.setInt(1, roleId);
            prestmt.setInt(2, userId);
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
    public boolean verifyPassword(String username, String password) {
        boolean check = false;
        try {
            con = MyConnection.getConnection();
            prestmt = con.prepareStatement("select [Password] \n"
                    + "from [User] where Username = ? and [Password] = ?");
            prestmt.setString(1, username);
            prestmt.setString(2, password);
            rs = prestmt.executeQuery();
            if (rs.next() && password.equals(rs.getString("Password"))) {
                check = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return check;
    }
}
