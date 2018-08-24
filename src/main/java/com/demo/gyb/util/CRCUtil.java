package com.demo.gyb.util;

import org.apache.commons.codec.binary.Base64;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.CRC32;

public class CRCUtil {
	 /**
     * 采用BufferedInputStream的方式加载文件
     */
    public static long checksumBufferedInputStream(InputStream inputStream ) throws IOException {
    	//InputStream inputStream = new BufferedInputStream(new FileInputStream(filepath));
        CRC32 crc = new CRC32();
        byte[] bytes = new byte[1024];
        int cnt;
        while ((cnt = inputStream.read(bytes)) != -1) {
            crc.update(bytes, 0, cnt);
        }
        inputStream.close();
        return crc.getValue();
    }
    public static void main(String[] args){
    	try {
    		Base64 base64 = new Base64();
    		String filepath = "G:/nrf51422_xxac_src.bin";
    		//String filepath = "G:/update.log";
    		File file = new File(filepath);
    		System.out.println(file.length());
    		FileInputStream in = new FileInputStream(filepath);
//    		 int tempbyte;    
//    		 while ((tempbyte = in.read()) != -1) {    
//    		 System.out.write(tempbyte);    
//    		 }    
//    		 in.close();
    		Long filelength = file.length();
    		 byte[] b = new byte[filelength.intValue()];
        	 in.read(b);
        	 in.close();
        	 //System.out.println(byte2hex(b).length());
            String string1 = base64.encodeAsString(b);
            System.out.println(string1);
//            String s = bytes2Hex(buffer);
//            System.out.println(s); 
//            System.out.println(s.length());
//            byte[] b = s.getBytes();
//            System.out.println(b.length);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    public static String bytes2Hex(byte[] src) {
        if (src == null || src.length <= 0) {   
            return null;   
        } 
        char[] res = new char[src.length * 2]; // 每个byte对应两个字符
        final char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
        for (int i = 0, j = 0; i < src.length; i++) {
            res[j++] = hexDigits[src[i] >> 4 & 0x0f]; // 先存byte的高4位
            res[j++] = hexDigits[src[i] & 0x0f]; // 再存byte的低4位
        }
        return new String(res);
    }
    public static String byte2hex(byte[] b) {
        String hs = "";
        String stmp = "";
        for (int n = 0; n < b.length; n++) { 
            stmp = (Integer.toHexString(b[n] & 0XFF));
            if (stmp.length() == 1) { 
                hs = hs + "0" + stmp; 
            } else { 
                hs = hs + stmp; 
            } 
        } 
        return hs.toUpperCase(); 
    } 
}
