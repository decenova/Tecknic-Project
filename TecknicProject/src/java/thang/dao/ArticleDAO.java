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
import java.util.ArrayList;
import thang.dto.ArticleDTO;

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

    public ArrayList findAllBySubmitedOrCheckingArticle() {
        ArrayList list = new ArrayList();
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
            if (row > 0)
                result = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }       
        return result;
    }
}
