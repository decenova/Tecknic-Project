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
    
    //Người dùng xem lại nội dung của Article trước khi chỉnh sửa
    //Lấy ra dựa vào ArticleID
    //Lấy Title, [Content], CoverImage
    //Trả về ArticleDTO
    public ArticleDTO viewArticleForUpdate(int articleID) {
        ArticleDTO result = null;
        
        try {
            conn = MyConnection.getConnection();
            String sql = "select Title, [Content], CoverImage from Article where Id = ?";
            pre = conn.prepareStatement(sql);
            pre.setInt(1, articleID);
            rs = pre.executeQuery();
            
            if (rs.next()) {
                result = new ArticleDTO();
                result.setTitle(rs.getString("Title"));
                result.setContent(rs.getString("Content"));
                result.setCoverImage(rs.getString("CoverImage"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        
        return result;
    }
    
    //Member muốn sửa các bài post đang ở trạng thái draf, remove, reject
    //Sửa article dựa vào ArticleID
    //Lấy ra
    //Trả về giá trị boolean
//    public boolean updateArticle(ArticleDTO dto) {
//        boolean result = false;
//        
//        try {
//            conn = MyConnection.getConnection();
//            String sql = "update Article set Title  = ?, [Content] = ?, CorverImage = ?, , "
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            closeConnection();
//        }
//                
//        return result;
//    }
    
    public void updateNumOfView(int articleID) {
        try {
            conn = MyConnection.getConnection();
            String sql = "select NumOfView from Article where Id = ?";
            pre = conn.prepareStatement(sql);
            pre.setInt(1, articleID);
            rs = pre.executeQuery();
            if (rs.next()) {
                sql = "update Article set NumOfView = ? where Id = ?";
                pre = conn.prepareStatement(sql);
                pre.setInt(1, rs.getInt("NumOfView") + 1);
                pre.setInt(2, articleID);
                pre.execute();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
    }
}
