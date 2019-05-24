package cn.cjli.webmall.common.util;

import org.apache.commons.codec.binary.Base64;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * webmall cn.cjli.webmall.common.util
 *
 * @author Lichaojie
 * @version 2019/5/21 19:06
 */
public class EncryptUtil {
	/**
	 * 单项散列函数SHA 用于对用户密码进行加密
	 * @param password
	 * @return
	 */
	public static String sha(String password) {
		MessageDigest messageDigest = null;
		try {
			messageDigest = MessageDigest.getInstance("SHA");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		byte[] ret = messageDigest.digest(password.getBytes());
		return Base64.encodeBase64String(ret);
	}
}
