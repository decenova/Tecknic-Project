/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trung.actions;

import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import trung.dao.ArticleDAO;
import trung.dto.ArticleDTO;

/**
 *
 * @author Trung
 */
@ParentPackage("json-default")
public class LoadUncheckArticle extends ActionSupport{
    
    private int pos;
    private int size;
    ArrayList<ArticleDTO> result = new ArrayList<>();
    
    public LoadUncheckArticle() {
    }
    
    @Action(value = "/loadUncheckArticle", results = {
        @Result(name = "success", type = "json")
    })
    public String execute() throws Exception {
        
        ArticleDAO aDao = new ArticleDAO();
        
        result = aDao.loadUncheckArticle(size, pos);
        
        return "success";
    }

    public void setPos(int pos) {
        this.pos = pos;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public ArrayList<ArticleDTO> getResult() {
        return result;
    }
    
    
    
}
