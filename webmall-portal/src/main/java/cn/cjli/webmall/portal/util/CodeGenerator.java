package cn.cjli.webmall.portal.util;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.Calendar;
import java.util.Date;

/**
 * webmall cn.cjli.webmall.portal.util
 *
 * @author Lichaojie
 * @version 2019/6/4 11:25
 */
public class CodeGenerator {
	private static final int ID_LENGTH = 4;

	public static String orderSn(Date date, long id){
		return orderSn(date,2,id);
	}

	public static String orderSn(Date date, int randomeLength, long id){
		String time = Long.toString(date.getTime());
		time = time.substring(time.length() - 8, time.length());

		String random = RandomStringUtils.randomNumeric(randomeLength);

		StringBuilder idString = new StringBuilder();
		do {
			idString.append(id % 10);
			id = id / 10;
		}while (idString.length() < ID_LENGTH && id != 0);

		int len = idString.length();
		for (int i = 0; i < ID_LENGTH - len; i ++){
			idString.append(0);
		}

		return time + random + idString.reverse().toString();

	}

	public static void main(String[] args){
		Date date = new Date();
		System.out.println(date.getTime());
		System.out.println(orderSn(date,2,2));
	}
}
