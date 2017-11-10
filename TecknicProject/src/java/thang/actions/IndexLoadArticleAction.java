/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thang.actions;

import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import thang.dao.ArticleDAO;

/**
 *
 * @author Decen
 */
@ParentPackage("json-default")
public class IndexLoadArticleAction extends ActionSupport {

    private int size;
    private int pos;
    private int tagId;
    private ArrayList json;

    public IndexLoadArticleAction() {
    }

    @Action(value = "/indexLoadArticle", results = {
        @Result(name = SUCCESS, type = "json"),
        @Result(name = INPUT, type = "json"),
    })
    public String execute() throws Exception {
        ArticleDAO dao = new ArticleDAO();
        if (tagId == 0)
            json = dao.loadIndexArticle(size, pos);
        else
            json = dao.loadIndexArticle(size, pos,tagId);
        return SUCCESS;
    }

    public ArrayList getJson() {
        return json;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setPos(int pos) {
        this.pos = pos;
    }

    public void setTagId(int tagId) {
        this.tagId = tagId;
    }

}
