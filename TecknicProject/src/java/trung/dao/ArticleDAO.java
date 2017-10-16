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
import java.util.ArrayList;
import trung.dto.ArticleDTO;

/**
 *
 * @author Trung
 */
public class ArticleDAO {
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
    
    //Các member xem bài post của chính mình
    //Dựa vào ID của member lấy ra ArrayList<ArticleDTO>
    //Lấy ra gồm ID, Title, CreateTime, Status
    //Tra về array list các dto
    public ArrayList<ArticleDTO> findArticleByUserID(int userID) {
        ArrayList<ArticleDTO> result = new ArrayList<>();
        
        try {
            conn = MyConnection.getConnection();
            String sql = "select Id, Title, CreateTime, StatusId from Article "
                    + "where CreatorId = ?";
            pre = conn.prepareStatement(sql);
            pre.setInt(1, userID);
            rs = pre.executeQuery();
            
            while (rs.next()) {
                ArticleDTO dto = new ArticleDTO();
                dto.setId(rs.getInt("Id"));
                dto.setTitle(rs.getString("Title"));
                dto.setCreateTime(rs.getTimestamp("CreateTime"));
                dto.setStatusId(rs.getInt("StatusId"));
                
                result.add(dto);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        
        return result;
    }
}
