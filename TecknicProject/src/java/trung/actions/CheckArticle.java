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
import org.apache.struts2.convention.annotation.ParentPackage;
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
@ParentPackage("json-default")
public class CheckArticle extends ActionSupport{
    
    private int articleId;
    private int statusId;
    private int modId;
    private String reason;
    private boolean result = false;
    
    public CheckArticle() {
    }
    
    @Action(value = "/checkArticle", results = {
        @Result(name = "success", location = "/article.jsp")
    })
    public String execute() throws Exception {
        ArticleDTO article = new ArticleDTO();
        trung.dao.ArticleDAO aDAO = new trung.dao.ArticleDAO();
        
        article = aDAO.viewArticleForUpdate(articleId);
        
        if (article.getStatus().compareToIgnoreCase("submited") == 0 || article.getStatus().compareToIgnoreCase("posted") == 0) {
            result = aDAO.checkArticle(articleId, statusId, modId, reason);
        }
        
        return "success";
    }
    
    public void setArticleId(int articleId) {
        this.articleId = articleId;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }

    public void setModId(int modId) {
        this.modId = modId;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public boolean isResult() {
        return result;
    }
    
    
    
}
