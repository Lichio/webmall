package cn.cjli.webmall.common.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * webmall cn.cjli.webmall.common.util
 *
 * @author Lichaojie
 * @version 2019/5/21 11:27
 */
public class DateUtil {
	/**
	 * 从Date类型的时间中提取日期部分
	 */
	public static Date getDate(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		return calendar.getTime();
	}

	/**
	 * 从Date类型的时间中提取时间部分
	 */
	public static Date getTime(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.YEAR, 1970);
		calendar.set(Calendar.MONTH, 0);
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		return calendar.getTime();
	}

	/**
	 * 将日期转换成字符串格式
	 */
	public  static String parseCalendarToString(Date date){
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return  sf.format(date);
	}
}
