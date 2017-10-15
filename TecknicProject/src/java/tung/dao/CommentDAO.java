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
import tung.dto.CommentDTO;

/**
 *
 * @author hoanh
 */
public class CommentDAO {

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

    public boolean addComment(CommentDTO comment) {
        boolean result = false;
        try {
            conn = MyConnection.getConnection();
            String sql = "insert into Comment(Id,UserId,ArticleId,Content,CreateTime,Status) values(?,?,?,?,?,?)";
            preStm = conn.prepareStatement(sql);
            preStm.setInt(1, comment.getID());
            preStm.setInt(2, comment.getUserID());
            preStm.setInt(3, comment.getArticleID());
            preStm.setString(4, comment.getContent());
            preStm.setTimestamp(5, comment.getCreateTime());
            preStm.setBoolean(6, comment.isStatus());
            if(preStm.executeUpdate() > 0)
                result = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return result;
    }

    public boolean removeComment(int commentID) {
        boolean result = false;
        try {
            conn = MyConnection.getConnection();
            String sql = "delete from Comment where Id = ?";
            preStm = conn.prepareStatement(sql);
            preStm.setInt(1, commentID);
            if (preStm.executeUpdate() > 0)
                result = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return result;
    }
}
