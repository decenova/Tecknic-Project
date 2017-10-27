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
    
    private UserDTO user;
    private int    otherNumOfArticle;

    
    public ViewOtherProfileAction() {
    }
    @Action(value = "/viewOtherProfile", results = {
        @Result(name = "success", location = "/profile.jsp")
    })  
    public String execute() throws Exception {
        
        UserDAO uDao = new UserDAO();
        user = uDao.findOtherProfileByUserID(userId);
        ArticleDAO aDao = new ArticleDAO();
        
        String gender = user.getGender();
        if (gender.equalsIgnoreCase("M")) {
            user.setGender("Nam");
        } else if (gender.equalsIgnoreCase("F")) {
            user.setGender("Nữ");
        } else if (gender.equalsIgnoreCase("O")) {
            user.setGender("Chưa xác định");
        } else {
            user.setGender("???");
        }
        
        otherNumOfArticle = uDao.getNumberOfArticleByUserID(userId);
        
        
       return "success"; 
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getOtherNumOfArticle() {
        return otherNumOfArticle;
    }

    public UserDTO getUser() {
        return user;
    }
    
    

    
    
    
    
    
}
