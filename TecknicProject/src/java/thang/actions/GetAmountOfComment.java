/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thang.actions;

import static com.opensymphony.xwork2.Action.INPUT;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import tung.dao.CommentDAO;

/**
 *
 * @author Decen
 */
@ParentPackage("json-default")
public class GetAmountOfComment extends ActionSupport {
    private int articleId;
    private int numOfComment;
    public GetAmountOfComment() {
    }
    
    @Action(value = "/getAmountOfComment", results = {
        @Result(name = SUCCESS, type = "json"),
        @Result(name = INPUT, type = "json"),
    })
    public String execute() throws Exception {
        CommentDAO dao = new CommentDAO();
        numOfComment = dao.getAmountOfComment(articleId);
        return SUCCESS;
    }


    public void setArticleId(int articleId) {
        this.articleId = articleId;
    }

    public int getNumOfComment() {
        return numOfComment;
    }

    
}
