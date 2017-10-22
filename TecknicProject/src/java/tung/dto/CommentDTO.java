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
    private String txtCreateTime;
    private boolean status;
    private String nameUser;
    private String avatarUser;

    public CommentDTO(int ID, int userID, int articleID, String content, Timestamp createTime, boolean status) {
        this.ID = ID;
        this.userID = userID;
        this.articleID = articleID;
        this.content = content;
        this.createTime = createTime;
        this.status = status;
    }

    public CommentDTO() {
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

    public String getNameUser() {
        return nameUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

    public String getAvatarUser() {
        return avatarUser;
    }

    public void setAvatarUser(String avatarUser) {
        this.avatarUser = avatarUser;
    }

    public String getTxtCreateTime() {
        return txtCreateTime;
    }

    public void setTxtCreateTime(String txtCreateTime) {
        this.txtCreateTime = txtCreateTime;
    }
    
    
    
    
}
