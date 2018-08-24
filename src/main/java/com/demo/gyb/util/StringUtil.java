package com.demo.gyb.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtil {
    /**
     * 判断字符串是否为空
     */
	public static boolean isBlank(String s){
		if(null == s || "".equals(s) || "null".equals(s)){
			return true;
		}else{
			if("".equals(s.trim())){
				return true;
			}
			return false;
		}
	}
	
	public static boolean isBlank1(String s) {
		if (null == s || s.trim().equals("")|| s.trim().equalsIgnoreCase("null")) {
			return true;
		} else {
			return false;
		}
	}

	
	/**
	 * 整数转成4位的16进制字符串
	 */
	public static String numberTo4HexStr(int number){
		return String.format("%04x", number);
	}
	/**
	 * 验证字符串是否是16进制的
	 * @param str
	 * @return
	 */
	public static boolean validString2HexStr(String str) {
		str = str.trim();
		String regEx = null;
		int length = str.length();
		if(length == 32) {
			regEx = "[0-9a-fA-F]{32}";
		}else if(length == 12){
			regEx = "[0-9a-fA-F]{12}";
		}else {
			return false;
		}
		Matcher mat = Pattern.compile(regEx).matcher(str);
		if (mat.matches()) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * 判断是字符还是汉字
	 * @param c
	 * @return
	 */
	public static boolean isLetter(char c) {
		int k = 0x80;
		return c / k == 0 ? true : false;
	}

	/**
	 * 得到一个字符串的长度,显示的长度,一个汉字或日韩文长度为2,英文字符长度为1
	 * 
	 * @param String s 需要得到长度的字符串
	 * @return int 得到的字符串长度
	 */
	public static int length(String s) {
		if (s == null)
			return 0;
		s = s.trim();
		char[] c = s.toCharArray();
		int len = 0;
		for (int i = 0; i < c.length; i++) {
			len++;
			if (!isLetter(c[i])) {
				len++;
			}
		}
		return len;
	}
	public static void main(String[] args) {
		System.out.println(decToHex(1000));
	}

	/**
	 * 得到一个字符串的长度,显示的长度,一个汉字或日韩文长度为1,英文字符长度为0.5
	 * 
	 * @param String
	 *            s 需要得到长度的字符串
	 * @return int 得到的字符串长度
	 */
	public static double getLength(String s) {
		double valueLength = 0;
		String chinese = "[\u4e00-\u9fa5]";
		// 获取字段值的长度，如果含中文字符，则每个中文字符长度为2，否则为1
		for (int i = 0; i < s.length(); i++) {
			// 获取一个字符
			String temp = s.substring(i, i + 1);
			// 判断是否为中文字符
			if (temp.matches(chinese)) {
				// 中文字符长度为1
				valueLength += 1;
			} else {
				// 其他字符长度为0.5
				valueLength += 0.5;
			}
		}
		// 进位取整
		return Math.ceil(valueLength);
	}
	
	/**
	 * 指定字符串 不足位数 低位 补0
	 * @param str 
	 * @param strLength 
	 * @return
	 */
	public static String addZeroForNum(String str, int strLength) {
	    int strLen = str.length();
	    while (strLen < strLength) {
	    	StringBuffer sb = new StringBuffer();
//		    sb.append("0").append(str);// 左补0
	    	sb.append(str).append("0");//右补0
	    	str = sb.toString();
	    	strLen = str.length();
	    }
	    return str;
	}
	/**
	 * 10进制转16进制  低位在前
	 * @param dec
	 * @return
	 */
	public static String decToHex(int dec) {
	    String hex = "";
	    while(dec != 0) {
	        String h = Integer.toString(dec & 0xff , 16);
	        if((h.length() & 0x01) == 1) {
	        	h = '0' + h;
	        }
	        hex = hex + h;
	        dec = dec >> 8;
	    }
	    return hex;
	}
}
