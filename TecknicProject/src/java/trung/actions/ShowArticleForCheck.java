/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trung.actions;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import trung.dao.ArticleDAO;
import trung.dao.UserDAO;
import trung.dto.ArticleDTO;
import trung.dto.UserDTO;
import tung.dao.CommentDAO;

/**
 *
 * @author Trung
 */
public class ShowArticleForCheck extends ActionSupport{
    
    private int articleId;
    
    public ShowArticleForCheck() {
    }
    
    @Action(value = "/showArticleForCheck", results = {
        @Result(name = "success", location = "/checkArticle.jsp")
    })
    public String execute() throws Exception {
        
        ArticleDAO aDao = new ArticleDAO();
        UserDAO uDao = new UserDAO();
        
        ArticleDTO article = aDao.viewArticleForUpdate(articleId);
        UserDTO creator = uDao.findOtherProfileByUserID(article.getCreatorId());
        HttpServletRequest request = ServletActionContext.getRequest();
        request.setAttribute("Article", article);
        request.setAttribute("Creator", creator);
        return "success";
    }

    public void setArticleId(int articleId) {
        this.articleId = articleId;
    } 
    
    
}
