package com.junlon.common.base.utils.rsa;

import com.junlon.common.base.utils.string.StringUtil;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.log4j.Logger;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * MD5
 */
public class MD5 {

	private static Logger logger = Logger.getLogger(MD5.class);

	/**
	 * 获取MD5消息摘要
	 * 
	 * @param data
	 *            源数据
	 * @return MD5消息摘要
	 */
	public static byte[] getMD5(byte[] data) {
		byte[] md5 = null;
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md5 = md.digest(data);
		} catch (Exception e) {
		}
		return md5;
	}

	/*
	 * MD5字符串
	 */
	public static String getMD5Str(String str) {
		MessageDigest messageDigest = null;

		try {
			messageDigest = MessageDigest.getInstance("MD5");
			messageDigest.reset();
			if (!StringUtil.isEmpty(str)) {
				messageDigest.update(str.getBytes("UTF-8"));
			}
		} catch (NoSuchAlgorithmException e) {
			logger.error(e);
		} catch (UnsupportedEncodingException e) {
			logger.error(e);
		}

		byte[] byteArray = messageDigest.digest();

		StringBuffer md5StrBuff = new StringBuffer();

		for (int i = 0; i < byteArray.length; i++) {
			if (Integer.toHexString(0xFF & byteArray[i]).length() == 1)
				md5StrBuff.append("0").append(Integer.toHexString(0xFF & byteArray[i]));
			else
				md5StrBuff.append(Integer.toHexString(0xFF & byteArray[i]));
		}
		return md5StrBuff.toString().toUpperCase();
	}
	
	/*
	 * MD5字符串
	 */
	public static String getMD5Str(String str, String charset) {
		MessageDigest messageDigest = null;

		try {
			messageDigest = MessageDigest.getInstance("MD5");
			messageDigest.reset();
			if (!StringUtil.isEmpty(str)) {
				messageDigest.update(str.getBytes(charset));
			}
		} catch (NoSuchAlgorithmException e) {
			logger.error(e);
		} catch (UnsupportedEncodingException e) {
			logger.error(e);
		}

		byte[] byteArray = messageDigest.digest();

		StringBuffer md5StrBuff = new StringBuffer();

		for (int i = 0; i < byteArray.length; i++) {
			if (Integer.toHexString(0xFF & byteArray[i]).length() == 1)
				md5StrBuff.append("0").append(Integer.toHexString(0xFF & byteArray[i]));
			else
				md5StrBuff.append(Integer.toHexString(0xFF & byteArray[i]));
		}
		return md5StrBuff.toString().toUpperCase();
	}
	
	/**
	 * 16位MD5方法 
	 * @param sourceStr
	 * @return
	 */
	public static String MD5_16(String sourceStr) {
        String result = "";
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(sourceStr.getBytes());
            byte b[] = md.digest();
            int i;
            StringBuffer buf = new StringBuffer("");
            for (int offset = 0; offset < b.length; offset++) {
                i = b[offset];
                if (i < 0)
                    i += 256;
                if (i < 16)
                    buf.append("0");
                buf.append(Integer.toHexString(i));
            }
           // result = buf.toString();
            result = buf.toString().substring(8, 24);
            
        } catch (NoSuchAlgorithmException e) {
        	logger.error("NoSuchAlgorithmException",e);
        }
        return result;
    }

	/*
	 * MD5字符串
	 */
	public static String getMD5Str(byte[] data) {
		MessageDigest messageDigest = null;

		try {
			messageDigest = MessageDigest.getInstance("MD5");

			messageDigest.reset();

			messageDigest.update(data);
		} catch (NoSuchAlgorithmException e) {
			logger.error("NoSuchAlgorithmException",e);
		}

		byte[] byteArray = messageDigest.digest();

		StringBuffer md5StrBuff = new StringBuffer();

		for (int i = 0; i < byteArray.length; i++) {
			if (Integer.toHexString(0xFF & byteArray[i]).length() == 1)
				md5StrBuff.append("0").append(Integer.toHexString(0xFF & byteArray[i]));
			else
				md5StrBuff.append(Integer.toHexString(0xFF & byteArray[i]));
		}
		return md5StrBuff.toString().toUpperCase();
	}

	public static void main(String[] args){
		System.out.println(MD5.getMD5Str("chenjianhua"));
		System.out.println(DigestUtils.md5Hex("chenjianhua").toUpperCase());
		
	}
}
