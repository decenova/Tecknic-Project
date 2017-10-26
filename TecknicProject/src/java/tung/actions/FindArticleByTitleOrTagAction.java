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
import tung.dao.ArticleDAO;
import tung.dto.ArticleDTO;

/**
 *
 * @author hoanh
 */
@ParentPackage("json-default")
public class FindArticleByTitleOrTagAction extends ActionSupport {

    private String searchTitle;
    private ArrayList<ArticleDTO> articleList;
    private String cbxTag;
    


    public FindArticleByTitleOrTagAction() {
    }

    @Action(value = "/findArticleV2", results = {
        @Result(name = "success", type = "json")
    })
    public String execute() throws Exception {
        ArticleDAO dao = new ArticleDAO();
        articleList = dao.findByTitleOrTag(searchTitle, cbxTag.split(","));
        return SUCCESS;
    }

    public String getSearchTitle() {
        return searchTitle;
    }

    public void setSearchTitle(String searchTitle) {
        this.searchTitle = searchTitle;
    }

    public ArrayList<ArticleDTO> getArticleList() {
        return articleList;
    }

    public String getCbxTag() {
        return cbxTag;
    }

    public void setCbxTag(String cbxTag) {
        this.cbxTag = cbxTag;
    }


    
}
