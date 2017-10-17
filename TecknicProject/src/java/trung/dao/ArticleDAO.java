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
    //Lấy Title, [Content], CoverImage, Taglist
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
                
                //Lấy TagList
                sql = "select TagId from ArticleTag where ArticleId = ?";
                pre = conn.prepareStatement(sql);
                pre.setInt(1, articleID);
                rs = pre.executeQuery();
                //Tạo đối tượng TagList khi đã query đc.
                result.setTagList(new ArrayList<Integer>());
                while (rs.next()) {
                    result.getTagList().add(rs.getInt("TagId"));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        
        return result;
    }
    
//    Member muốn sửa các bài post đang ở trạng thái draf, remove, reject
//    Sửa article dựa vào ArticleID
//    Lấy ra
//    Trả về giá trị boolean
    public boolean updateArticle(ArticleDTO dto) {
        boolean result = false;
        
        try {
            conn = MyConnection.getConnection();
            
            //Update bảng Article
            String sql = "update Article set Title  = ?, [Content] = ?, CoverImage = ? where Id = ?";
            pre = conn.prepareStatement(sql);
            pre.setString(1, dto.getTitle());
            pre.setString(2, dto.getContent());
            pre.setString(3, dto.getCoverImage());
            pre.setInt(4, dto.getId());
            pre.executeUpdate();
            
            //Update bảng ArticleTag
            //Xóa hết tất cả các ArticleTag r sau đó add vào lại
            sql = "delete from ArticleTag where ArticleId = ?";
            pre = conn.prepareStatement(sql);
            pre.setInt(1, dto.getId());
            pre.executeUpdate();
            for (int tagId : dto.getTagList()) {
                sql = "insert into ArticleTag (ArticleId, TagId) values (?,?)";
                pre = conn.prepareStatement(sql);
                pre.setInt(1, dto.getId());
                pre.setInt(2, tagId);
                pre.execute();
            }
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
                
        return result;
    }
    
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
