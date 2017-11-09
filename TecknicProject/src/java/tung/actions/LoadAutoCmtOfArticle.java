/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tung.actions;

import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import tung.dao.CommentDAO;
import tung.dto.CommentDTO;

/**
 *
 * @author hoanh
 */
@ParentPackage("json-default")
public class LoadAutoCmtOfArticle extends ActionSupport {
    int size;
    int pos;
    private int articleId;
    private ArrayList<CommentDTO> commentList;

    public LoadAutoCmtOfArticle() {
    }

    @Action(value = "/loadAutoCmt", results = {
        @Result(name = "success", type = "json")
    })
    public String execute() throws Exception {
        CommentDAO dao = new CommentDAO();
        commentList = dao.LoadAutoCmtByArticleID(articleId, pos, size);
        return SUCCESS;
    }

    public ArrayList<CommentDTO> getCommentList() {
        return commentList;
    }

    public void setArticleId(int articleId) {
        this.articleId = articleId;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getPos() {
        return pos;
    }

    public void setPos(int pos) {
        this.pos = pos;
    }

}
