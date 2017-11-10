/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thang.dao;

import db.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import thang.dto.ArticleDTO;
import thang.dto.UserDTO;

/**
 *
 * @author Decen
 */
public class ArticleDAO {

    private Connection con;
    private PreparedStatement prestmt;
    private ResultSet rs;

    public ArticleDAO() {
    }

    private void closeConnection() {
        try {
            if (rs != null) {
                rs.close();
            }
            if (prestmt != null) {
                prestmt.close();
            }
            if (con != null) {
                con.close();
            }
        } catch (Exception e) {
        }
    }

    public ArrayList<ArrayList> loadIndexArticle(int size, int pos) {
        ArrayList<ArrayList> list = new ArrayList<>();
        ArrayList sublist;
        ArticleDTO articleDto;
        UserDTO userDto;
        try {
            con = MyConnection.getConnection();
            prestmt = con.prepareStatement("select a.Id, a.Title, SUBSTRING(a.Content,0,1000), a.CoverImage, a.ModifyTime, a.NumOfView, u.Id, u.Name, u.Avatar \n"
                    + " from  Article a inner join [User] u on a.CreatorId = u.Id \n"
                    + " where a.StatusId = (Select Id from [Status] where name = 'posted')\n"
                    + " order by ModifyTime desc\n"
                    + " OFFSET ? ROWS\n"
                    + " FETCH NEXT ? ROWS ONLY;");
            prestmt.setInt(1, pos);
            prestmt.setInt(2, size);
            rs = prestmt.executeQuery();
            while (rs.next()) {
                articleDto = new ArticleDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getTimestamp(5), rs.getInt(6));
                userDto = new UserDTO(rs.getInt(7), rs.getString(8), rs.getString(9));
                sublist = new ArrayList();
                sublist.add(articleDto);
                sublist.add(userDto);
                list.add(sublist);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return list;
    }

    public ArrayList<ArrayList> loadIndexArticle(int size, int pos, int tagId) {
        ArrayList<ArrayList> list = new ArrayList<>();
        ArrayList sublist;
        ArticleDTO articleDto;
        UserDTO userDto;
        try {
            con = MyConnection.getConnection();
            prestmt = con.prepareStatement("select a.Id, a.Title, SUBSTRING(a.Content,0,1000), a.CoverImage, a.ModifyTime, a.NumOfView, u.Id, u.Name, u.Avatar"
                    + " from  Article a inner join [User] u on a.CreatorId = u.Id"
                    + " where a.StatusId = (Select Id from [Status] where name = 'posted')"
                    + " and a.Id in (select ArticleId from ArticleTag where TagId = ?)"
                    + " order by ModifyTime desc"
                    + " OFFSET ? ROWS"
                    + " FETCH NEXT ? ROWS ONLY;");
            prestmt.setInt(2, pos);
            prestmt.setInt(3, size);
            prestmt.setInt(1, tagId);
            rs = prestmt.executeQuery();
            while (rs.next()) {
                articleDto = new ArticleDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getTimestamp(5), rs.getInt(6));
                userDto = new UserDTO(rs.getInt(7), rs.getString(8), rs.getString(9));
                sublist = new ArrayList();
                sublist.add(articleDto);
                sublist.add(userDto);
                list.add(sublist);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return list;
    }

    public ArrayList<ArrayList> loadIndexArticle(int size, int pos, String search) {
        ArrayList<ArrayList> list = new ArrayList<>();
        ArrayList sublist;
        ArticleDTO articleDto;
        UserDTO userDto;
        try {
            con = MyConnection.getConnection();
            prestmt = con.prepareStatement("select a.Id, a.Title, SUBSTRING(a.Content,0,1000), a.CoverImage, a.ModifyTime, a.NumOfView, u.Id, u.Name, u.Avatar"
                    + " from  Article a inner join [User] u on a.CreatorId = u.Id"
                    + " where a.StatusId = (Select Id from [Status] where name = 'posted')"
                    + " and a.Title like ?"
                    + " order by ModifyTime desc"
                    + " OFFSET ? ROWS"
                    + " FETCH NEXT ? ROWS ONLY;");
            prestmt.setInt(2, pos);
            prestmt.setInt(3, size);
            prestmt.setString(1, search);
            rs = prestmt.executeQuery();
            while (rs.next()) {
                articleDto = new ArticleDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getTimestamp(5), rs.getInt(6));
                userDto = new UserDTO(rs.getInt(7), rs.getString(8), rs.getString(9));
                sublist = new ArrayList();
                sublist.add(articleDto);
                sublist.add(userDto);
                list.add(sublist);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return list;
    }

    public ArrayList<ArrayList> loadIndexArticle(int size, int pos, int tagId, String search) {
        ArrayList<ArrayList> list = new ArrayList<>();
        ArrayList sublist;
        ArticleDTO articleDto;
        UserDTO userDto;
        try {
            con = MyConnection.getConnection();
            prestmt = con.prepareStatement("select a.Id, a.Title, SUBSTRING(a.Content,0,1000), a.CoverImage, a.ModifyTime, a.NumOfView, u.Id, u.Name, u.Avatar"
                    + " from  Article a inner join [User] u on a.CreatorId = u.Id"
                    + " where a.StatusId = (Select Id from [Status] where name = 'posted')"
                    + " and a.Id in (select ArticleId from ArticleTag where TagId = ?)"
                    + " and a.Title like ?"
                    + " order by ModifyTime desc"
                    + " OFFSET ? ROWS"
                    + " FETCH NEXT ? ROWS ONLY;");
            prestmt.setInt(3, pos);
            prestmt.setInt(4, size);
            prestmt.setInt(1, tagId);
            prestmt.setString(2, '%' + search + '%');
            rs = prestmt.executeQuery();
            while (rs.next()) {
                articleDto = new ArticleDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getTimestamp(5), rs.getInt(6));
                userDto = new UserDTO(rs.getInt(7), rs.getString(8), rs.getString(9));
                sublist = new ArrayList();
                sublist.add(articleDto);
                sublist.add(userDto);
                list.add(sublist);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return list;
    }

    public ArrayList<ArticleDTO> findAllBySubmitedOrCheckingArticle() {
        ArrayList<ArticleDTO> list = new ArrayList<>();
        ArticleDTO dto;
        try {
            con = MyConnection.getConnection();
            prestmt = con.prepareStatement("select A.Id, A.Title, A.CreateTime, S.Id, S.Name \n"
                    + "from Article A inner join [Status] S on A.StatusId = S.Id \n"
                    + "where S.Name = 'submited' or S.Name = 'reviewing'");
            rs = prestmt.executeQuery();
            while (rs.next()) {
                dto = new ArticleDTO(rs.getInt(1), rs.getString(2), rs.getTimestamp(3), rs.getInt(4), rs.getString(5));
                list.add(dto);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return list;
    }

    public boolean changeStatus(int articleId, int statusId) {
        boolean result = false;
        try {
            con = MyConnection.getConnection();
            String sql = "update Article set StatusId  = ? where Id = ?";
            prestmt = con.prepareStatement(sql);
            prestmt.setInt(1, statusId);
            prestmt.setInt(2, articleId);
            int row = prestmt.executeUpdate();
            if (row > 0) {
                result = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return result;
    }

    public ArrayList<ArticleDTO> loadBestArticle(Timestamp startTime, Timestamp endTime) {
        ArrayList<ArticleDTO> list = new ArrayList<>();
        try {
            con = MyConnection.getConnection();
            prestmt = con.prepareStatement("select top 5 Id, Title, CoverImage \n"
                    + " from article where ModifyTime between ? and ?\n"
                    + " order by NumOfView desc, ModifyTime asc");
            prestmt.setTimestamp(2, endTime);
            prestmt.setTimestamp(1, startTime);
            rs = prestmt.executeQuery();
            while (rs.next()) {
                list.add(new ArticleDTO(rs.getInt(1), rs.getString(2), rs.getString(3)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return list;
    }
}
