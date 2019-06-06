package com.food.util;

import java.util.UUID;
/**
 * ���ϵͳ�Զ���UUIDֵ
 * @author KYJ
 *
 */
public class CommonsUtil {
     public static String getUUID(){
    	 return UUID.randomUUID().toString();
     }
     public static boolean isNum(String str) {
    		for(int i = str.length(); --i>=0;) {
    			if(!Character.isDigit(str.charAt(i))) {
    				return false;
    			}
    		}
    		return true;
    	}
}  

