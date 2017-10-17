/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trung.actions;

import db.MyConnection;
import java.util.ArrayList;
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
        ArticleDAO aDao = new ArticleDAO();
        for (ArticleDTO dto : aDao.findArticleByUserID(2)) {
            System.out.println(dto.toString());
        }
        
        System.out.println("\n**** Find other profile by UserId = 2 ****");
        UserDAO uDao = new UserDAO();
        System.out.println(uDao.findOtherProfileByUserID(2).toString());
        
        System.out.println("\n**** Total of post by UserId = 2 ****");
        System.out.println(uDao.getNumberOfArticleByUserID(2));
        
        System.out.println("\n**** View Article for update ArticleID = 1 ****");
        System.out.println(aDao.viewArticleForUpdate(1));
        
        System.out.println("\n**** Update Role UserID = 2 Role = 4 ****");
        System.out.println(uDao.updateRole(2, 4));
        
        System.out.println("\n**** Update NumOfView ArticleID = 1 ****");
        aDao.updateNumOfView(1);
        
        System.out.println("\n**** Update Article ArticleId = 1 ****");
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(2);
        arr.add(3);
        ArticleDTO dto = new ArticleDTO(1, "LoloLand", "This is not a movie", "default", null, 0, null, 0, 0, null, 0, arr);
        System.out.println("Before: " + aDao.viewArticleForUpdate(1));
        aDao.updateArticle(dto);
        System.out.println("After : " + aDao.viewArticleForUpdate(1));
    }
}
