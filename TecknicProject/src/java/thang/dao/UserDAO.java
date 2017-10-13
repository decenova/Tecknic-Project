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
            prestmt = con.prepareStatement("select [User].Name, [User].[Password], [User].Avatar, [Role].Name \n"
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
                System.out.println(dto);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return dto;
    }
}
