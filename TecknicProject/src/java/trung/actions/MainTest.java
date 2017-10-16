/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trung.actions;

import db.MyConnection;
import trung.dao.ArticleDAO;
import trung.dto.ArticleDTO;

/**
 *
 * @author Trung
 */
class MainTest {

    public static void main(String[] args) {
        System.out.println("**** This is trung's test class ****");
        ArticleDAO dao = new ArticleDAO();
        for (ArticleDTO dto : dao.findArticleByUserID(2)) {
            System.out.println(dto.toString());
        }
    }
}
