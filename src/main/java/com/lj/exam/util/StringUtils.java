package com.lj.exam.util;

import java.math.BigDecimal;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 字符串工具类
 *
 */
public class StringUtils {
	
	private static final Log log = LogFactory.getLog(StringUtils.class);
	public static String replaceBlank(String str) {
		String dest = "";
		if (str!=null) {
			Pattern p = Pattern.compile("\\s*|\t|\r|\n");
			Matcher m = p.matcher(str);
			dest = m.replaceAll("");    
		}
		return dest;
	}
	/**
	 * 判断字符串是否为纯数字
	 * <p> Create Date: 2014年9月29日 </p>
	 * @param str
	 * @return true 是，false 否
	 */
	public static boolean isDigital( String str ) {
		if( isBlank(str)){
			return false ;
		}
		return str.matches("\\d+") ;
	}
	
	/**
	 * 判断字符串是否字母加数字
	 * <p> Create Date: 2014年10月9日 </p>
	 * @param str
	 * @return true 是，false 否
	 */
	public static boolean isAlpha( String str){
		if( isBlank(str)){
			return false;
		}
		return str.matches("^[A-Za-z0-9]+$");
	}
	
	/**
	 * @param str 判断字符串是金额格式：####.####
	 * @return true 是，false 否
	 */
	public static boolean isMoney(String str) {
		try {
			new BigDecimal(str);
		} catch (Exception e) {
			log.error("字符串格式有问题",e);
			return false;
		}
		return true;
	}
	
	public static boolean isBlank(String str) {
        int length;
        if ((str == null) || ((length = str.length()) == 0)){
        	return true;
        }
        for (int i = 0; i < length; ++i) {
            if (!(Character.isWhitespace(str.charAt(i)))) {
                return false;
            }
        }
        return true;
    }
	public static boolean isNotBlank(String str) {
        int length;
        if ((str == null) || ((length = str.length()) == 0)){
        	return false;
        }
        for (int i = 0; i < length; ++i) {
            if (!(Character.isWhitespace(str.charAt(i)))) {
                return true;
            }
        }
        return false;
    }
	/**
	 * 判断值是不是空的,如果是空的  就返回  空的，如果不是就返回本身的值
	 * @param str
	 * @return
	 */
	public static String isBlankString(String str) {
       if("".equals(str)||str==null){
    	   return "";
       }else{
    	   return str;
       }
    }
	
	
	public static boolean isEmpty(String str) {
        return ((str == null) || (str.length() == 0));
    }

    public static boolean isNotEmpty(String str) {
        return ((str != null) && (str.length() > 0));
    }
    public static boolean equalsIgnoreCase(String str1, String str2) {
		if (str1 == null) {
			return str2 == null;
		}
		return str1.equalsIgnoreCase(str2);
	}
    public static boolean equals(String str1, String str2) {
		if (str1 == null) {
			return str2 == null;
		}
		return str1.equals(str2);
	}
    
    /**
     * Convert byte[] to hex string.这里我们可以将byte转换成int，
     * 然后利用Integer.toHexString(int)来转换成16进制字符串。   
     * @param src byte[] data   
     * @return hex string   
     */      
    public static String bytesToHexString(byte[] src){   
        StringBuilder stringBuilder = new StringBuilder("");   
        if (src == null || src.length <= 0) {   
            return null;   
        }   
        for (int i = 0; i < src.length; i++) {   
            int v = src[i] & 0xFF;   
            String hv = Integer.toHexString(v);   
            if (hv.length() < 2) {   
                stringBuilder.append(0);   
            }   
            stringBuilder.append(hv);   
        }   
        return stringBuilder.toString();   
    }   
    /**  
     * Convert hex string to byte[]  
     * @param hexString the hex string  
     * @return byte[]  
     */  
    public static byte[] hexStringToBytes(String hexString) {   
        if (hexString == null || hexString.equals("")) {   
            return null;   
        }   
        hexString = hexString.toUpperCase();   
        int length = hexString.length() / 2;   
        char[] hexChars = hexString.toCharArray();   
        byte[] d = new byte[length];   
        for (int i = 0; i < length; i++) {   
            int pos = i * 2;   
            d[i] = (byte) (charToByte(hexChars[pos]) << 4 | charToByte(hexChars[pos + 1]));   
        }   
        return d;   
    }  
    
    /**  
     * Convert char to byte  
     * @param c char  
     * @return byte  
     */  
    public static byte charToByte(char c) {   
        return (byte) "0123456789ABCDEF".indexOf(c);   
    }  
     
     /**
      * 字符串转字节
      * @param str
      * @return
      */
     public static byte[] strToBytes(String str) {
    	 byte[] res = null;
    	 if(!isBlank(str)){
    		 res = str.getBytes();   
    	 }
    	 return res;
     }
     
     /**
      * 金额转换：分-->元
      * @param str
      * @return
      */
     public static String amtConvert(long amount) {
    	 BigDecimal bg=new BigDecimal(amount);
    	 BigDecimal result=bg.divide(new BigDecimal(100L));
    	 return result.toString();
     }  
 	
}
