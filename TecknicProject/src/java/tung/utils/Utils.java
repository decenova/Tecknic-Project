/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tung.utils;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 *
 * @author hoanh
 */
public class Utils {
    
    public final String MALE = "male";
    public final String FEMALE = "female";
    
    public static Timestamp parseToDate(String dob) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return new Timestamp(sdf.parse(dob).getTime());
    }
    public static boolean parseToGender(String txtGender) {
        
        return false;
        
    }
    
    
}
