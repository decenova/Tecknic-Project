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
import tung.utils.Utils;

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
        UserDTO result = null;

        try {
            conn = MyConnection.getConnection();
            String sql = "select [User].Username, [User].Name, [User].Avatar, [Role].Name as [Role], [Role].Id as [RoleId], [User].Gender, [User].Email, [User].DateOfJoin \n"
                    + "from [User] inner join [Role] on [User].RoleId = [Role].Id \n"
                    + "where [User].Id = ?";
            pre = conn.prepareStatement(sql);
            pre.setInt(1, userId);
            rs = pre.executeQuery();

            if (rs.next()) {
                Utils util = new Utils();
                result = new UserDTO();

                result.setId(userId);
                result.setUsername(rs.getString("Username"));
                result.setName(rs.getString("Name"));
                result.setAvatar(rs.getString("Avatar"));
                result.setRole(rs.getString("Role"));
                result.setRoleId(rs.getInt("RoleId"));
                result.setGender(rs.getString("Gender"));
                result.setEmail(rs.getString("Email"));
                result.setDOJ(Utils.convertToDateV2(rs.getTimestamp("DateOfJoin")));
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

    //update role của 1 user
    public boolean updateRole(int userId, int roleId) {
        boolean result = false;

        try {
            conn = MyConnection.getConnection();
            String sql = "update [User] set RoleId = ? where Id = ?";
            pre = conn.prepareStatement(sql);
            pre.setInt(1, roleId);
            pre.setInt(2, userId);
            if (pre.executeUpdate() == 1) {
                result = true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }

        return result;
    }

    public boolean banUser(int userId, int modId, String reason) {
        boolean result = false;

        try {
            UserDTO user = findOtherProfileByUserID(userId);
            int exRole = getUserRoleId(userId);
            
            conn = MyConnection.getConnection();
            String sql = "insert into BanLog (BannedUserId, ExRole, ModId, BanTime, Reason) values (?,?,?,?,?)";
            pre = conn.prepareStatement(sql);
            pre.setInt(1, userId);
            pre.setInt(2, exRole);
            pre.setInt(3, modId);
            pre.setTimestamp(4, Utils.getTimeSystem());
            pre.setString(5, reason);
            if (pre.executeUpdate() == 1) {
                updateRole(userId, 5);
                result = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }

        return result;
    }

    public int getUserRoleId(int userId) {
        int result = 0;

        try {
            conn = MyConnection.getConnection();
            String sql = "select RoleId from [User] where Id = ?";
            pre = conn.prepareStatement(sql);
            pre.setInt(1, userId);
            rs = pre.executeQuery();
            if (rs.next()) {
                result = rs.getInt("RoleId");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }

        return result;
    }
}
