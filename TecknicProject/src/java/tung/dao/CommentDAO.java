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
import tung.dto.CommentDTO;
import tung.utils.Utils;

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

    //load các comment theo bài viết
    public ArrayList<CommentDTO> loadCommentsByArticleID(int articleID) {
        ArrayList<CommentDTO> result = new ArrayList<>();
        try {
            conn = MyConnection.getConnection();
            String sql = "select c.Id, u.Name, u.Avatar, c.CreateTime, c.Content "
                    + "from Comment c inner join [User] u on c.UserId = u.Id "
                    + "where c.ArticleId=? order by c.CreateTime DESC";
            preStm = conn.prepareStatement(sql);
            preStm.setInt(1, articleID);
            rs = preStm.executeQuery();
            CommentDTO comment;
            while (rs.next()) {
                comment = new CommentDTO();
                comment.setID(rs.getInt("Id"));
                comment.setNameUser(rs.getString("Name"));
                comment.setAvatarUser(rs.getString("Avatar"));
//                comment.setCreateTime(rs.getTimestamp("CreateTime"));
                comment.setTxtCreateTime(Utils.convertToDateV3(rs.getTimestamp("CreateTime")));
                comment.setContent(rs.getString("Content"));
                result.add(comment);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return result;
    }

    public ArrayList<CommentDTO> LoadAutoCmtByArticleID(int articleID, int pos, int size) {
        ArrayList<CommentDTO> result = new ArrayList<>();
        try {
            conn = MyConnection.getConnection();
            String sql = "select c.Id as Id, u.Id as uId, u.Name, u.Avatar, c.CreateTime, c.Content\n"
                    + "from Comment c inner join [User] u on c.UserId = u.Id\n"
                    + "where c.ArticleId=? and c.Status=? order by c.CreateTime DESC\n"
                    + "OFFSET ? ROWS\n"
                    + "FETCH NEXT ? ROWS ONLY";
            preStm = conn.prepareStatement(sql);
            preStm.setInt(1, articleID);
            preStm.setBoolean(2, true);
            preStm.setInt(3, pos);
            preStm.setInt(4, size);
            rs = preStm.executeQuery();
            CommentDTO comment;
            while (rs.next()) {
                comment = new CommentDTO();
                comment.setID(rs.getInt("Id"));
                comment.setNameUser(rs.getString("Name"));
                comment.setAvatarUser(rs.getString("Avatar"));
                comment.setUserID(rs.getInt("uId"));
//                comment.setCreateTime(rs.getTimestamp("CreateTime"));
                comment.setTxtCreateTime(Utils.convertToDateV3(rs.getTimestamp("CreateTime")));
                comment.setContent(rs.getString("Content"));
                result.add(comment);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return result;
    }

    //status sẽ cập nhật sau
    public boolean addComment(int userID, int articleID, String content) {
        boolean result = false;
        try {
            conn = MyConnection.getConnection();
            String sql = "insert into Comment(UserId,ArticleId,Content,CreateTime,Status) values(?,?,?,?,?)";
            preStm = conn.prepareStatement(sql);
            preStm.setInt(1, userID);
            preStm.setInt(2, articleID);
            preStm.setString(3, content);
            preStm.setTimestamp(4, Utils.getTimeSystem());
            preStm.setBoolean(5, true);
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

    public boolean removeComment(int commentID) {
        boolean result = false;
        try {
            conn = MyConnection.getConnection();
            String sql = "update Comment set Status = ? where Id = ?";
            preStm = conn.prepareStatement(sql);
            preStm.setBoolean(1, false);
            preStm.setInt(2, commentID);
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

    public int getAmountOfComment(int articleID) {
        int count = 0;
        try {
            conn = MyConnection.getConnection();
            String sql = "select count(Id) as Amount from Comment where ArticleId = ? and Status = ?";
            preStm = conn.prepareStatement(sql);
            preStm.setInt(1, articleID);
            preStm.setBoolean(2, true);
            rs = preStm.executeQuery();
            if (rs.next()) {
                count = rs.getInt("Amount");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return count;
    }
}
