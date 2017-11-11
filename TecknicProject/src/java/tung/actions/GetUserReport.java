/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tung.actions;

import com.opensymphony.xwork2.ActionSupport;
import java.sql.Timestamp;
import java.util.ArrayList;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import tung.dao.ArticleDAO;
import tung.dao.UserDAO;
import tung.dto.UserDTO;
import tung.utils.Utils;

/**
 *
 * @author hoanh
 */
@ParentPackage("json-default")
public class GetUserReport extends ActionSupport {
    String txtFrom;
    String txtTo;
    ArrayList<UserDTO> arrayList;
    public GetUserReport() {
    }
    @Action(value = "/getUserReport", results = {
        @Result(name = "success", type = "json")
    })
    public String execute() throws Exception {
        UserDAO dao = new UserDAO();
        Timestamp from = Utils.parseToDate(txtFrom);
        Timestamp to = Utils.parseToDateV2(txtTo + " 23:59:59.9"); //hết ngày
        arrayList = dao.getUserByViewAndJoin(from, to);
        return SUCCESS;
    }


    public String getTxtFrom() {
        return txtFrom;
    }

    public void setTxtFrom(String txtFrom) {
        this.txtFrom = txtFrom;
    }

    public String getTxtTo() {
        return txtTo;
    }

    public void setTxtTo(String txtTo) {
        this.txtTo = txtTo;
    }

    public ArrayList<UserDTO> getArrayList() {
        return arrayList;
    }

    public void setArrayList(ArrayList<UserDTO> arrayList) {
        this.arrayList = arrayList;
    }

 
    
}
