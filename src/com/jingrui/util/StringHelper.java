package com.jingrui.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;

import com.jingrui.domain.Customer;

public class StringHelper {
    public static List<Customer> cutdownIntroduction(List<Customer> list){
    	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println("cutdown introduction begin:"+df.format(new Date()));
    	
		for(int i=0;i<list.size();i++){
		    Customer c = list.get(i);
		    String s_1 = c.getIntroduction();
		    String s_2 = "";
		    if(s_1!=null&&s_1.length()>=10){
		        s_2=s_1.substring(0, 10);
		        c.setIntroduction(s_2+"...");
		    }
		}
		
		System.out.println("cutdown introduction end:"+df.format(new Date()));
		return list;
	}
    
    public static Set<Customer> cutdownIntroduction(Set<Customer> set){
    	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println("cutdown introduction begin:"+df.format(new Date()));
    	
		for (Customer customer : set) {
			Customer c = customer;
		    String s_1 = c.getIntroduction();
		    String s_2 = "";
		    if(s_1!=null&&s_1.length()>=10){
		        s_2=s_1.substring(0, 10);
		        c.setIntroduction(s_2+"...");
		    }
		}
		
		System.out.println("cutdown introduction end:"+df.format(new Date()));
		return set;
	}
    public static String decode(String str){
        String[] tmp = str.split(";&#|&#|;");
        StringBuffer sb = new StringBuffer("");
        for (int i=0; i<tmp.length; i++ ){
            if (tmp[i].matches("\\d{5}")){
                sb.append((char)Integer.parseInt(tmp[i]));
            } else {
            sb.append(tmp[i]);
            }
        }
        return sb.toString();
    }
    
}
