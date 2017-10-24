/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tung.actions;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import tung.dao.CommentDAO;

/**
 *
 * @author hoanh
 */
@ParentPackage("json-default")
public class AddCommentAction extends ActionSupport {
    
    private int articleID;
    private String txtComment;
    
    
    public AddCommentAction() {
    }
    @Action(value = "/addComment", results = {
        @Result(name = "success", type = "json")
    })
    public String execute() throws Exception {
        CommentDAO dao = new CommentDAO();
        //fix cứng
//        articleID = 1;
        int userID = (int) (ActionContext.getContext().getSession().get("ID"));
        dao.addComment(userID, articleID, txtComment);
        return SUCCESS;
    }


    public int getArticleID() {
        return articleID;
    }

    public void setArticleID(int articleID) {
        this.articleID = articleID;
    }

    public String getTxtComment() {
        return txtComment;
    }

    public void setTxtComment(String txtComment) {
        this.txtComment = txtComment;
    }

    
    
    
    
}
