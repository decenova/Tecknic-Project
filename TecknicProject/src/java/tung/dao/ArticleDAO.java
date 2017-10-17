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
import java.util.ArrayList;
import tung.dto.ArticleDTO;

/**
 *
 * @author hoanh
 */
public class ArticleDAO {

    private Connection conn;
    private PreparedStatement preStm;
    private ResultSet rs;

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

    public boolean addArticle(ArticleDTO article) {
        boolean result = false;
        try {
            conn = MyConnection.getConnection();
            String sql = "insert into Article(Id,Title,Content,CoverImage,CreateTime,"
                    + "CreatorId,StatusId,NumOfView)"
                    + " values(?,?,?,?,?,?,?,?)";
            preStm = conn.prepareStatement(sql);
            preStm.setInt(1, article.getID());
            preStm.setString(2, article.getTitle());
            preStm.setString(3, article.getContent());
            preStm.setString(4, article.getCoverImage());
            preStm.setTimestamp(5, article.getCreateTime());
            preStm.setInt(6, article.getCreatorID());
            preStm.setInt(7, 1);
            preStm.setInt(8, 0);
            if(preStm.executeUpdate() > 0)
                result = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return result;
    }

    public ArrayList<ArticleDTO> findByLikeTitle(String title) {
        
        return null;
    }

    public ArrayList<ArticleDTO> findByTag(int tagID) {
        return null;
    }

}
