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
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import tung.dto.ArticleDTO;
import tung.utils.Utils;

/**
 *
 * @author hoanh
 */
public class ArticleDAO {

    private final int SUBMITED = 1;
    private final int REVIEWING = 2;
    private final int VIEWDEFAULT = 0;

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
                    + "CreatorId,ModifyTime,StatusId,NumOfView)"
                    + " values(?,?,?,?,?,?,?,?)";
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, article.getTitle());
            preStm.setString(2, article.getContent());
            preStm.setString(3, article.getCoverImage());
            preStm.setTimestamp(4, Utils.getTimeSystem());
            preStm.setInt(5, article.getCreatorID());
            preStm.setTimestamp(6, Utils.getTimeSystem());
            preStm.setInt(7, SUBMITED);
            preStm.setInt(8, VIEWDEFAULT);
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
            if (temp == tagIDList.size()) {
                result = true;
            }
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
        ArrayList<ArticleDTO> result = new ArrayList<>();
        try {
            conn = MyConnection.getConnection();
            String sql = "select ID, Title, CreateTime from Article"
                    + " where Title like ? and (StatusId = ? or StatusId = ?)";
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, "%" + title + "%");
            preStm.setInt(2, SUBMITED);
            preStm.setInt(3, REVIEWING);
            rs = preStm.executeQuery();
            ArticleDTO article;
            while (rs.next()) {
                article = new ArticleDTO();
                article.setID(rs.getInt("ID"));
                article.setTitle(rs.getString("Title"));
                article.setTxtCreateTime(Utils.convertToDateV3(rs.getTimestamp("CreateTime")));
                result.add(article);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return result;
    }

    //duyệt bài khi trạng thái còn chưa được post lên
    public ArrayList<ArticleDTO> findByTitleOrTag(String title, String[] tagsID) {
        ArrayList<ArticleDTO> result = new ArrayList<>();
        try {
            conn = MyConnection.getConnection();
            String sql = "select distinct a.ID, a.Title, a.CreateTime, s.Name "
                    + "from (Article a inner join ArticleTag at on a.Id = at.ArticleID) "
                    + "inner join Status s on StatusId = s.Id"
                    + " where Title like ? and StatusId in (?,?) and at.TagId in (?,?,?)";
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, "%" + title + "%");
            preStm.setInt(2, SUBMITED);
            preStm.setInt(3, REVIEWING);
            switch (tagsID.length) {
                case 1:
                    preStm.setString(4, tagsID[0]);
                    preStm.setString(5, null);
                    preStm.setString(6, null);
                    break;
                case 2:
                    preStm.setString(4, tagsID[0]);
                    preStm.setString(5, tagsID[1]);
                    preStm.setString(6, null);
                    break;
                case 3:
                    preStm.setString(4, tagsID[0]);
                    preStm.setString(5, tagsID[1]);
                    preStm.setString(6, tagsID[2]);
                    break;
            }
            rs = preStm.executeQuery();
            ArticleDTO article;
            while (rs.next()) {
                article = new ArticleDTO();
                article.setID(rs.getInt("ID"));
                article.setTitle(rs.getString("Title"));
                article.setTxtCreateTime(Utils.convertToDateV3(rs.getTimestamp("CreateTime")));
                article.setStatus(rs.getString("Name"));
                result.add(article);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return result;
    }
public int getAmountOfUncheckArticle() {
        int number = 0;
        try {
            conn = MyConnection.getConnection();
            String sql = "select count(ID) as Number from Article"
                    + " where StatusId = ?";
            preStm = conn.prepareStatement(sql);
            preStm.setInt(1, SUBMITED);
            rs = preStm.executeQuery();
            if (rs.next()) {
                number = rs.getInt("Number");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return number;
    }


}
