/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trung.actions;

import db.MyConnection;
import trung.dao.ArticleDAO;
import trung.dao.UserDAO;
import trung.dto.ArticleDTO;

/**
 *
 * @author Trung
 */
class MainTest {

    public static void main(String[] args) {
        System.out.println("**** This is trung's test class ****");
        System.out.println("\n**** List of Article by UserID = 2 ****");
        ArticleDAO dao = new ArticleDAO();
        for (ArticleDTO dto : dao.findArticleByUserID(2)) {
            System.out.println(dto.toString());
        }
        
        System.out.println("\n**** Find other profile by UserId = 1 ****");
        UserDAO uDao = new UserDAO();
        System.out.println(uDao.findOtherProfileByUserID(1).toString());
        
        System.out.println("\n**** Total of post by UserId = 2 ****");
        System.out.println(uDao.getNumberOfArticleByUserID(2));
    }
}
