/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trung.actions;

import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import trung.dao.ArticleDAO;
import trung.dto.ArticleDTO;

/**
 *
 * @author Trung
 */

public class UpdateArticle extends ActionSupport{
    
    private int txtId;
    private String txtTitle;
    private String txtImage;
    private String txtContent;
    private ArrayList<Integer> cbxTag;
    private boolean result = false;
    
    public UpdateArticle() {
    }
    
    @Action(value = "/updateArticle", results = {
        @Result(name = "success", location = "/index.jsp")
    })
    public String execute() throws Exception {       
        
        ArticleDAO aDao = new ArticleDAO();
        ArticleDTO aDto = new ArticleDTO();
        
        aDto.setId(txtId);
        aDto.setTitle(txtTitle);
        aDto.setCoverImage(txtImage);
        aDto.setContent(txtContent);
        Map<Integer,Integer> tagList = new HashMap<>();
        
        
        
        for (int i = 0; i < cbxTag.size(); i++) {
            tagList.put(cbxTag.get(i), 1);
        }
        
        aDto.setTagList(tagList);
        
        if (aDao.updateArticle(aDto)) {
            thang.dao.ArticleDAO tDao = new thang.dao.ArticleDAO();
            result = tDao.changeStatus(aDto.getId(), 1);
        }
        
        
        return "success";
    }

    public void setTxtId(int txtId) {
        this.txtId = txtId;
    }
    
    

    public String getTxtTitle() {
        return txtTitle;
    }

    public void setTxtTitle(String txtTitle) {
        this.txtTitle = txtTitle;
    }

    public String getTxtImage() {
        return txtImage;
    }

    public void setTxtImage(String txtImage) {
        this.txtImage = txtImage;
    }

    public String getTxtContent() {
        return txtContent;
    }

    public void setTxtContent(String txtContent) {
        this.txtContent = txtContent;
    }

    public ArrayList<Integer> getCbxTag() {
        return cbxTag;
    }

    public void setCbxTag(ArrayList<Integer> cbxTag) {
        this.cbxTag = cbxTag;
    }

    public boolean isResult() {
        return result;
    }
    
    
    
}
