/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trung.dto;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Map;

/**
 *
 * @author Trung
 */
public class ArticleDTO {
    private int id;
    private String title;
    private String content;
    private String coverImage;
    private String createTime;
    private int creatorId;
    private String modifyTime;
    private int modifierId;
    private String status;
    private String reason;
    private int numOfView;
    private Map<Integer, Integer> tagList;
    
    public ArticleDTO() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public void setCoverImage(String CoverImage) {
        this.coverImage = CoverImage;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String CreateTime) {
        this.createTime = CreateTime;
    }

    public int getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(int CreatorId) {
        this.creatorId = CreatorId;
    }

    public String getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(String ModifyTime) {
        this.modifyTime = ModifyTime;
    }

    public int getModifierId() {
        return modifierId;
    }

    public void setModifierId(int ModifierId) {
        this.modifierId = ModifierId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String statusId) {
        this.status = statusId;
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

    public Map<Integer, Integer> getTagList() {
        return tagList;
    }

    public void setTagList(Map<Integer, Integer> tagList) {
        this.tagList = tagList;
    }

    @Override
    public String toString() {
        return "ArticleDTO{" + "id=" + id + ", title=" + title + ", content=" + content + ", CoverImage=" + coverImage + ", CreateTime=" + createTime + ", CreatorId=" + creatorId + ", ModifyTime=" + modifyTime + ", ModifierId=" + modifierId + ", statusId=" + status + ", reason=" + reason + ", numOfView=" + numOfView + ", tagList=" + tagList + '}';
    }
    
    
}