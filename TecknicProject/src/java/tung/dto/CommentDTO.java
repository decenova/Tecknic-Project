/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tung.dto;

import java.sql.Timestamp;

/**
 *
 * @author hoanh
 */
public class CommentDTO {
    private int ID;
    private int userID;
    private int articleID;
    private String content;
    private Timestamp createTime;
    private boolean status;

    public CommentDTO(int ID, int userID, int articleID, String content, Timestamp createTime, boolean status) {
        this.ID = ID;
        this.userID = userID;
        this.articleID = articleID;
        this.content = content;
        this.createTime = createTime;
        this.status = status;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getArticleID() {
        return articleID;
    }

    public void setArticleID(int articleID) {
        this.articleID = articleID;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    
    
}
