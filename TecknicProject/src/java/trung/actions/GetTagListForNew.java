/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trung.actions;

import com.opensymphony.xwork2.ActionSupport;
import java.util.Map;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import trung.dao.ArticleDAO;
import trung.dto.TagDTO;

/**
 *
 * @author Trung
 */
@ParentPackage("json-default")
public class GetTagListForNew extends ActionSupport{
    private Map<Integer, String> result;
    public GetTagListForNew() {
    }
    @Action(value = "/getTagListForNew", results = {
        @Result(name = "success", type = "json")
    })
    public String execute() throws Exception {
         ArticleDAO aDao = new ArticleDAO();
        result = aDao.getAllTagForNew();
        return "success";
    }

    public Map<Integer, String> getResult() {
        return result;
    }
    
}
