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
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import trung.dto.ArticleDTO;
import trung.dto.TagDTO;
import tung.utils.Utils;

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
            String sql = "select a.Id, Title, CreateTime, Name from Article a inner join [Status] s on a.StatusId = s.Id "
                    + "where a.CreatorId = ?";
            pre = conn.prepareStatement(sql);
            pre.setInt(1, userID);
            rs = pre.executeQuery();

            while (rs.next()) {
                Utils util = new Utils();
                ArticleDTO dto = new ArticleDTO();
                dto.setId(rs.getInt("Id"));
                dto.setTitle(rs.getString("Title"));
                dto.setStatus(rs.getString("Name"));

                System.out.println("Status: " + dto.getStatus());

                dto.setCreateTime(util.convertToDateV3(rs.getTimestamp("CreateTime")));

                result.add(dto);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }

        return result;
    }

    //Các member xem bài post của ng khac
    //Dựa vào ID của member lấy ra ArrayList<ArticleDTO>
    //Lấy ra gồm ID, Title, CreateTime, Status
    //Tra về array list các dto
    public ArrayList<ArticleDTO> findOtherArticleByUserID(int userID) {
        ArrayList<ArticleDTO> result = new ArrayList<>();

        try {
            conn = MyConnection.getConnection();
            String sql = "select Id, Title, CreateTime from Article "
                    + "where CreatorId = ? and StatusId = 3";
            pre = conn.prepareStatement(sql);
            pre.setInt(1, userID);
            rs = pre.executeQuery();

            while (rs.next()) {
                Utils util = new Utils();
                ArticleDTO dto = new ArticleDTO();
                dto.setId(rs.getInt("Id"));
                dto.setTitle(rs.getString("Title"));

                dto.setCreateTime(util.convertToDateV3(rs.getTimestamp("CreateTime")));

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
        Utils util = new Utils();

        try {
            conn = MyConnection.getConnection();
            String sql = "select Title, [Content], CoverImage, CreateTime, Name, CreatorId, NumOfView from Article a inner join [Status] s on a.StatusId = s.Id "
                    + "where a.Id = ?";
            pre = conn.prepareStatement(sql);
            pre.setInt(1, articleID);
            rs = pre.executeQuery();

            if (rs.next()) {
                //Khởi tạo đối tượng khi tìm thấy
                result = new ArticleDTO();
                result.setId(articleID);
                result.setTitle(rs.getString("Title"));
                result.setContent(rs.getString("Content"));
                result.setCoverImage(rs.getString("CoverImage"));
                result.setStatus(rs.getString("Name"));
                result.setCreateTime(util.convertToDateV2(rs.getTimestamp("CreateTime")));
                result.setCreatorId(rs.getInt("CreatorId"));
                result.setNumOfView(rs.getInt("NumOfView"));
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
//    Trả về giá trị 
//    Ghi chú: 0(Không sửa), 1(Thêm), 2(Xóa)
    public boolean updateArticle(ArticleDTO dto, Map<Integer, Integer> changeTagList) {
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
            if (pre.executeUpdate() == 1) { //nếu update đúng 1 Article

                //Update bảng ArticleTag
                for (Map.Entry<Integer, Integer> entry : changeTagList.entrySet()) {
                    if (entry.getValue() == 1) { //Nếu giá trị của TagID là 1 ta thêm vào DB
                        sql = "insert into ArticleTag (ArticleId, TagId) values (?,?)";
                        pre = conn.prepareStatement(sql);
                        pre.setInt(1, dto.getId());
                        pre.setInt(2, entry.getKey());
                        pre.execute();
                    } else if (entry.getValue() == 2) { //Nếu giá trị của TagID là 2 ta xóa
                        sql = "delete from ArticleTag where ArticleId  = ? and TagId = ?";
                        pre = conn.prepareStatement(sql);
                        pre.setInt(1, dto.getId());
                        pre.setInt(2, entry.getKey());
                        pre.execute();
                    }
                }
                result = true;

            }
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

    //trả về map các tag của 1 article vs giá trị của tagId k có trong
    //article là 0 và có là 1
    public Map<Integer, Integer> getArticleTag(int articleId) {
        Map<Integer, Integer> result = getAllTag();

        try {
            conn = MyConnection.getConnection();
            String sql = "select TagId from ArticleTag where ArticleId = ? order by TagId ASC";
            pre = conn.prepareStatement(sql);
            pre.setInt(1, articleId);
            rs = pre.executeQuery();

            while (rs.next()) {
                //Nếu có key TagId trong map
                if (result.containsKey(rs.getInt("TagId"))) {
                    result.put(rs.getInt("TagId"), 1);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }

        return result;
    }

    //Lấy ra 1 Map tất cả các tag vs key là tagId và value là 0
    public Map<Integer, Integer> getAllTag() {
        Map<Integer, Integer> result = new HashMap<>();

        try {
            conn = MyConnection.getConnection();
            String sql = "select Id from Tag order by Id ASC";
            pre = conn.prepareStatement(sql);
            rs = pre.executeQuery();
            while (rs.next()) {
                result.put(rs.getInt("Id"), 0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }

        return result;
    }

    public Map<Integer, TagDTO> getAllTagForShow(int articleId) {
        Map<Integer, TagDTO> result = new HashMap<>();

        try {
            Map<Integer, Integer> articleTagList = getArticleTag(articleId);
            conn = MyConnection.getConnection();
            String sql = "Select Id, Name from Tag";
            pre = conn.prepareStatement(sql);
            rs = pre.executeQuery();

            while (rs.next()) {
                result.put(rs.getInt("Id"), new TagDTO(articleTagList.get(rs.getInt("Id")), rs.getString("Name")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }

        return result;
    }
    public Map<Integer, String> getAllTagForNew() {
        Map<Integer, String> result = new HashMap<>();

        try {
            conn = MyConnection.getConnection();
            String sql = "select Id,Name from Tag";
            pre = conn.prepareStatement(sql);
            rs = pre.executeQuery();
            while (rs.next()) {
                result.put(rs.getInt("Id"), rs.getString("Name"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }

        return result;
    }
}
