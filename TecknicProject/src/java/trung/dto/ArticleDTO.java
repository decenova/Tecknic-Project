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
    private String CoverImage;
    private Timestamp CreateTime;
    private int CreatorId;
    private Timestamp ModifyTime;
    private int ModifierId;
    private int statusId;
    private String reason;
    private int numOfView;
    private Map<Integer, Integer> tagList;
    
    public ArticleDTO() {
    }

    public ArticleDTO(int id, String title, String content, String CoverImage, Timestamp CreateTime, int CreatorId, Timestamp ModifyTime, int ModifierId, int statusId, String reason, int numOfView, Map<Integer, Integer> tagList) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.CoverImage = CoverImage;
        this.CreateTime = CreateTime;
        this.CreatorId = CreatorId;
        this.ModifyTime = ModifyTime;
        this.ModifierId = ModifierId;
        this.statusId = statusId;
        this.reason = reason;
        this.numOfView = numOfView;
        this.tagList = tagList;
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
        return CoverImage;
    }

    public void setCoverImage(String CoverImage) {
        this.CoverImage = CoverImage;
    }

    public Timestamp getCreateTime() {
        return CreateTime;
    }

    public void setCreateTime(Timestamp CreateTime) {
        this.CreateTime = CreateTime;
    }

    public int getCreatorId() {
        return CreatorId;
    }

    public void setCreatorId(int CreatorId) {
        this.CreatorId = CreatorId;
    }

    public Timestamp getModifyTime() {
        return ModifyTime;
    }

    public void setModifyTime(Timestamp ModifyTime) {
        this.ModifyTime = ModifyTime;
    }

    public int getModifierId() {
        return ModifierId;
    }

    public void setModifierId(int ModifierId) {
        this.ModifierId = ModifierId;
    }

    public int getStatusId() {
        return statusId;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
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
        return "ArticleDTO{" + "id=" + id + ", title=" + title + ", content=" + content + ", CoverImage=" + CoverImage + ", CreateTime=" + CreateTime + ", CreatorId=" + CreatorId + ", ModifyTime=" + ModifyTime + ", ModifierId=" + ModifierId + ", statusId=" + statusId + ", reason=" + reason + ", numOfView=" + numOfView + ", tagList=" + tagList + '}';
    }
    
    
}