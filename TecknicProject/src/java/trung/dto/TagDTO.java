/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trung.dto;

/**
 *
 * @author Trung
 */
public class TagDTO {
    private int check;
    private String name;

    public TagDTO() {
    }

    public TagDTO(int id, String name) {
        this.check = id;
        this.name = name;
    }
  
    public int getCheck() {
        return check;
    }

    public void setCheck(int id) {
        this.check = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
}
