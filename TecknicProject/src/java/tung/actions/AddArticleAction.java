/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tung.actions;

import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;
import java.util.Map;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;

import org.apache.struts2.convention.annotation.Result;
import tung.dao.ArticleDAO;
import tung.dto.ArticleDTO;

/**
 *
 * @author hoanh
 */
public class AddArticleAction extends ActionSupport {

    private String txtTitle;
    private String txtImage;
    private String txtContent;
    private ArrayList<Integer> cbxTag;

    public AddArticleAction() {
    }

    @Action(value = "/addArticle", results = {
        @Result(name = "success", location = "/editarticle.jsp")

    })
    public String execute() throws Exception {
        ArticleDAO dao = new ArticleDAO();
        ArticleDTO article = new ArticleDTO();
        article.setTitle(txtTitle);
        article.setCoverImage(txtImage);
        article.setContent(txtContent);
        Map session = ServletActionContext.getContext().getSession();
        article.setCreatorID((int) session.get("ID"));
        dao.addArticle(article);
        dao.addTagToArticle(dao.getCurrentArticleID(), cbxTag);

        return SUCCESS;
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

}
