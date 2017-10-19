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
import tung.utils.Utils;

/**
 *
 * @author hoanh
 */
public class ArticleDAO {

    private final int REVIEWING = 2;
    private final int VIEWDEFAUL = 0;

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
            String sql = "insert into Article(Title,Content,CoverImage,CreateTime,"
                    + "CreatorId,StatusId,NumOfView)"
                    + " values(?,?,?,?,?,?,?)";
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, article.getTitle());
            preStm.setString(2, article.getContent());
            preStm.setString(3, article.getCoverImage());
            preStm.setTimestamp(4, Utils.getTimeSystem());
            preStm.setInt(5, article.getCreatorID());
            preStm.setInt(6, REVIEWING);
            preStm.setInt(7, VIEWDEFAUL);
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

    public boolean addTagToArticle(int articleID, ArrayList<Integer> tagIDList) {
        boolean result = false;
        int temp = 0;
        try {
            conn = MyConnection.getConnection();
            String sql = "insert into ArticleTag(ArticleId,TagId) values(?,?)";
            for (int i = 0; i < tagIDList.size(); i++) {
                preStm = conn.prepareStatement(sql);
                preStm.setInt(1, articleID);
                preStm.setInt(2, tagIDList.get(i));
                temp += preStm.executeUpdate();   
            }
            if (temp == tagIDList.size())
                result = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return result;
    }

    public int getCurrentArticleID() {
        int currentID = 0;
        try {
            conn = MyConnection.getConnection();
            String sql = "select MAX(ID) as [Max ID] from Article";
            preStm = conn.prepareStatement(sql);
            rs = preStm.executeQuery();
            if (rs.next()) {
                currentID = rs.getInt("Max ID");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return currentID;
    }

    public ArrayList<ArticleDTO> findByLikeTitle(String title) {

        return null;
    }

    public ArrayList<ArticleDTO> findByTag(int tagID) {
        return null;
    }

}
