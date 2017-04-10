package com.jingrui.util;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 * <p>Title: BASE64.java</p>
 * <p>Description: information management software platform</p>
 * <p>Copyright: Copyright (c) 2011-2012 JinRui Information Technology Co., Ltd.</p>
 * <p>Company: JinRui Information Technology Co., Ltd.</p>
 * @author wangkang
 * @version 1.0 creation time£º2017-1-11 ÏÂÎç3:14:05
 */

public class BASE64 {
	
	public static byte[] decryptBASE64(String key) throws Exception {   
        return (new BASE64Decoder()).decodeBuffer(key);   
    }
	
	public static String encryptBASE64(byte[] key) throws Exception {   
        return (new BASE64Encoder()).encodeBuffer(key);   
    }
	
	public static void main(String[] args) {
		String str = "wangkang";
		try{
		    String  result1= BASE64.encryptBASE64(str.getBytes());
	        System.out.println("result1:"+result1);
	        
	        byte  result2[]= BASE64.decryptBASE64(result1);
	        String  str2=new String(result2);
	        System.out.println("result2:"+str2);
		}catch (Exception e) {
	        e.printStackTrace();
	    }
	}
}
