/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trung.dao;

import db.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import trung.dto.UserDTO;

/**
 *
 * @author Trung
 */
public class UserDAO {
    Connection conn;
    PreparedStatement pre;
    ResultSet rs;
    
    //Đóng các kết nối sau khi thực hiện xong 1 hàm
    private void closeConnection() {
        try {
            if (rs != null) {
                rs.close();
            }
            if (pre != null) {
                pre.close();
            }
            if (conn != null) {
                conn.close();
            }
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    //1 Member muốn xem thông tin profile của member khác
    //Lấy thông tin profile bằng ID
    //Thông tin lấy ra gồm Id, Avatar, Name, Role, [Ngày gia nhập], Gender, Email
    //Tra về 1 dto
    public UserDTO findOtherProfileByUserID(int userId) {
        UserDTO result = new UserDTO();
        
        try {
            conn = MyConnection.getConnection();
            String sql = "select [User].Name, [User].Avatar, [Role].Name as [Role], [User].Gender, [User].Email \n"
                    + "from [User] inner join [Role] on [User].RoleId = [Role].Id \n"
                    + "where [User].Id = ?";
            pre = conn.prepareStatement(sql);
            pre.setInt(1, userId);
            rs = pre.executeQuery();
            
            if (rs.next()) {
                result.setId(userId);
                result.setName(rs.getString("Name"));
                result.setRole(rs.getString("Role"));
                result.setGender(rs.getString("Gender").charAt(0));
                result.setEmail(rs.getString("Email"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        
        return result;
    }
    
    //Khi 1 member muốn xem thông tin của 1 member khác trong đó có thông tin số bài viết
    //Lấy tổng số bài viết bằng UserId
    //Thông tin cần lấy gồm tổng số bài viết
    //Trả về tổng số bài viết
    public int getNumberOfArticleByUserID(int userId) {
        int result = 0;
        
        //StatusId của Posted
        final int POSTEDSTATUSID = 3;
        try {
            conn = MyConnection.getConnection();
            String sql = "select count (Id) as Total from Article where CreatorId = ? and StatusId = ?";
            pre = conn.prepareStatement(sql);
            pre.setInt(1, userId);
            pre.setInt(2, POSTEDSTATUSID);
            
            rs = pre.executeQuery();
            
            if (rs.next()) {
                result = rs.getInt("Total");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        
        return result;
    }
}
