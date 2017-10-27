/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trung.actions;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import trung.dao.ArticleDAO;
import trung.dto.ArticleDTO;

/**
 *
 * @author Trung
 */
public class getArticleForUpdate extends ActionSupport{
    
    private int articleId;
    private ArticleDTO article;
    
    public getArticleForUpdate() {
    }
    
    @Action(value = "/getArticleForUpdate", results = {
        @Result(name = "success", location = "/editarticle.jsp")
    })
    public String execute() throws Exception {
        
        ArticleDAO aDao = new ArticleDAO();
        article = aDao.viewArticleForUpdate(articleId);
        
        return "success";
    }

    public void setArticleId(int articleId) {
        this.articleId = articleId;
    }

    public int getArticleId() {
        return articleId;
    }
    
    

    public ArticleDTO getArticle() {
        return article;
    }
    
    
    
}
