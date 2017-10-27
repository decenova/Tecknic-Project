/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trung.actions;

import com.opensymphony.xwork2.ActionSupport;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import trung.dao.ArticleDAO;
import trung.dto.ArticleDTO;

/**
 *
 * @author Trung
 */
public class showArticle extends ActionSupport{
    
    private int articleId;
    
    public showArticle() {
    }
    
    @Action(value = "/showArticle", results = {
        @Result(name = "success", location = "/article.jsp")
    })
    public String execute() throws Exception {
        
        ArticleDAO aDao = new ArticleDAO();
        ArticleDTO article = aDao.viewArticleForUpdate(articleId);
        
        HttpServletRequest request = ServletActionContext.getRequest();
        request.setAttribute("Article", article);
        
        return "success";
    }

    public void setArticleId(int articleId) {
        this.articleId = articleId;
    } 
    
    
}
