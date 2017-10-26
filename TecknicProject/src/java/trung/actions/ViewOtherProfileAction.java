/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trung.actions;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import trung.dao.ArticleDAO;
import trung.dao.UserDAO;
import trung.dto.UserDTO;

/**
 *
 * @author Trung
 */
public class ViewOtherProfileAction extends ActionSupport{
    
    private int userId;
    
    private String otherName;
    private String otherRole;
    private int    otherNumOfArticle;
    private String otherDOJ;
    private String otherGender;
    private String otherEmail;
    
    public ViewOtherProfileAction() {
    }
    @Action(value = "/viewOtherProfile", results = {
        @Result(name = "success", location = "/profile.jsp")
    })  
    public String execute() throws Exception {
        
        UserDAO uDao = new UserDAO();
        UserDTO uDto = uDao.findOtherProfileByUserID(userId);
        ArticleDAO aDao = new ArticleDAO();
        
        //Lấy thông tin cá nhân
        otherName = uDto.getName();        
        otherDOJ  = uDto.getDOJ();
        otherEmail= uDto.getEmail();
        
        char gender = uDto.getGender();
        if (gender == 'M') {
            otherGender = "Nam";
        } else if (gender == 'F') {
            otherGender = "Nữ";
        } else if (gender == 'O') {
            otherGender = "Chưa xác định";
        } else {
            otherGender = "Lỗi";
        }
        
        otherNumOfArticle = uDao.getNumberOfArticleByUserID(userId);
        otherRole = uDto.getRole();
        
        //lấy danh sách các article
        
        
       return "success"; 
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getOtherName() {
        return otherName;
    }

    public String getOtherRole() {
        return otherRole;
    }

    public int getOtherNumOfArticle() {
        return otherNumOfArticle;
    }

    public String getOtherDOJ() {
        return otherDOJ;
    }

    public String getOtherGender() {
        return otherGender;
    }

    public String getOtherEmail() {
        return otherEmail;
    }

    
    
    
    
    
}
