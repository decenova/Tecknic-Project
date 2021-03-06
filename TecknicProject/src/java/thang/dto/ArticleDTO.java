/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thang.dto;

import java.sql.Timestamp;

/**
 *
 * @author hoanh
 */
public class ArticleDTO {
    private int ID;
    private String title;
    private String content;
    private String coverImage;
    private Timestamp createTime;
    private int creatorID;
    private Timestamp modifyTime;
    private int statusID;
    private String status;
    private String reason;
    private int numOfView;

    public ArticleDTO(int ID, String title, String content, String coverImage, Timestamp createTime, int creatorID, Timestamp modifyTime, int statusID, String reason, int numOfView) {
        this.ID = ID;
        this.title = title;
        this.content = content;
        this.coverImage = coverImage;
        this.createTime = createTime;
        this.creatorID = creatorID;
        this.modifyTime = modifyTime;
        this.statusID = statusID;
        this.reason = reason;
        this.numOfView = numOfView;
    }

    public ArticleDTO(int ID, String title, String content, String coverImage, Timestamp modifyTime, int numOfView) {
        this.ID = ID;
        this.title = title;
        this.content = content;
        this.coverImage = coverImage;
        this.modifyTime = modifyTime;
        this.numOfView = numOfView;
    }
    
    public ArticleDTO(int ID, String title, Timestamp createTime,int statusId, String status) {
        this.ID = ID;
        this.title = title;
        this.createTime = createTime;
        this.statusID = statusId;
        this.status = status;
    }
    
    public ArticleDTO(int ID, String title, String coverImage) {
        this.ID = ID;
        this.title = title;
        this.coverImage = coverImage;
    }

    public ArticleDTO() {
    }
    

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCoverImage() {
        return coverImage;
    }

    public void setCoverImage(String coverImage) {
        this.coverImage = coverImage;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public int getCreatorID() {
        return creatorID;
    }

    public void setCreatorID(int creatorID) {
        this.creatorID = creatorID;
    }

    public Timestamp getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Timestamp modifyTime) {
        this.modifyTime = modifyTime;
    }

    public int getStatusID() {
        return statusID;
    }

    public void setStatusID(int statusID) {
        this.statusID = statusID;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public int getNumOfView() {
        return numOfView;
    }

    public void setNumOfView(int numOfView) {
        this.numOfView = numOfView;
    }
    
    
}
