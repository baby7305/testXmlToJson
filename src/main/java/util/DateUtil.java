package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {
	public static String getCurrentDateTimeStr() {
		return converDateToString(Calendar.getInstance().getTime(), "yyyy-MM-dd HH:mm:ss");
	}

	public static String getCurrentDateTimeStr(String style) {
		return converDateToString(Calendar.getInstance().getTime(), style);
	}

	public static String getCurrentDateStr() {
		return converDateToString(Calendar.getInstance().getTime(), "yyyy-MM-dd");
	}

	public static String getCurrentTimeStr() {
		return converDateToString(Calendar.getInstance().getTime(), "HH:mm:ss");
	}

	public static String getYear() {
		return String.valueOf(Calendar.getInstance().get(1));
	}

	public static String getMonth() {
		return String.valueOf(Calendar.getInstance().get(2) + 1);
	}

	public static String getDay() {
		return String.valueOf(Calendar.getInstance().get(5));
	}

	public static String getFirstDayOfMonth() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Calendar calendar = Calendar.getInstance();
		calendar.set(5, calendar.getActualMinimum(5));
		return dateFormat.format(calendar.getTime());
	}

	public static String getLastDayOfMonth() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Calendar calendar = Calendar.getInstance();
		calendar.set(5, calendar.getActualMaximum(5));
		return dateFormat.format(calendar.getTime());
	}

	public static String getFirstMonthOfYear() {
		return Calendar.getInstance().get(1) + "-01";
	}

	public static String getLastMonthOfYear() {
		return Calendar.getInstance().get(1) + "-12";
	}

	public static int getWeek() {
		int week = Calendar.getInstance().get(7) - 1;
		if (week == 0) {
			week = 7;
		}
		return week;
	}

	public static String getHour() {
		return String.valueOf(Calendar.getInstance().get(11));
	}

	public static String getMinute() {
		int minute = Calendar.getInstance().get(12);
		if (minute < 10) {
			return 0 + String.valueOf(minute);
		}
		return String.valueOf(minute);
	}

	public static String getSecond() {
		int second = Calendar.getInstance().get(13);
		if (second < 10) {
			return 0 + String.valueOf(second);
		}
		return String.valueOf(second);
	}

	public static Date convertStringToDate(String str, String style) {
		SimpleDateFormat formatter = new SimpleDateFormat(style);
		Date date = null;
		try {
			date = formatter.parse(str);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

	public static Date convertStringToDate(String str) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = null;
		try {
			date = formatter.parse(str);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

	public static String converDateToString(Date date, String style) {
		SimpleDateFormat formatter = new SimpleDateFormat(style);
		return formatter.format(date);
	}

	public static String converDateToString(Date date) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return formatter.format(date);
	}

	public static Date converDateToDate(Date date, String style) {
		SimpleDateFormat formatter = new SimpleDateFormat(style);
		try {
			return formatter.parse(formatter.format(date));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static Date getCurrentDate() {
		return Calendar.getInstance().getTime();
	}

	public static int getDiffAllDayByCurrentTime(Date date) {
		Date datetime1 = converDateToDate(getCurrentDate(), "yyyy-MM-dd");
		Date datetime2 = converDateToDate(date, "yyyy-MM-dd");

		return (int) ((datetime1.getTime() - datetime2.getTime()) / 1000L / 60L / 60L / 24L);
	}

	public static int getDiffAllDays(Date startDate, Date endDate) {
		Date datetime1 = converDateToDate(startDate, "yyyy-MM-dd");
		Date datetime2 = converDateToDate(endDate, "yyyy-MM-dd");
		return Math.abs((int) ((datetime2.getTime() - datetime1.getTime()) / 1000L / 60L / 60L / 24L));
	}

	public static int getDiffDayByCurrentTime(Date datetime) {
		return Math.abs((int) ((getCurrentDate().getTime() - datetime.getTime()) / 1000L / 60L / 60L / 24L));
	}

	public static int getDiffSecByCurrentTime(Date datetime) {
		return Math.abs((int) ((getCurrentDate().getTime() - datetime.getTime()) / 1000L));
	}

	public static int getDiffMinByCurrentTime(Date datetime) {
		return Math.abs((int) ((getCurrentDate().getTime() - datetime.getTime()) / 1000L / 60L));
	}

	public static long getTime(String datetime, String style) {
		long time = 0L;
		try {
			time = convertStringToDate(datetime, style).getTime();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return time;
	}

	public static String getDateTimeStrByMillis(long millis) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date t = new Date(millis);
		return formatter.format(t);
	}

	public static String getDateTimeStrByMillis(long millis, String style) {
		SimpleDateFormat formatter = new SimpleDateFormat(style);
		Date t = new Date(millis);
		return formatter.format(t);
	}

	public static Date getBeforeDateTime(int days) {
		Calendar c = Calendar.getInstance();
		c.add(6, 0 - days);
		return c.getTime();
	}

	public static Date getBeforeDateTime(Date date, int days) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(6, 0 - days);
		return c.getTime();
	}

	public static String getBeforeDateTimeStr(int days) {
		Calendar c = Calendar.getInstance();
		c.add(6, 0 - days);
		return converDateToString(c.getTime());
	}

	public static String getBeforeDateStr(int days) {
		Calendar c = Calendar.getInstance();
		c.add(6, 0 - days);
		return converDateToString(c.getTime(), "yyyy-MM-dd");
	}

	public static Date getAfterDateTime(int days) {
		Calendar c = Calendar.getInstance();
		c.add(6, days);
		return c.getTime();
	}

	public static Date getAfterDateTime(Date date, int days) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(6, days);
		return c.getTime();
	}

	public static String getAfterDateTimeStr(int days) {
		Calendar c = Calendar.getInstance();
		c.add(6, days);
		return converDateToString(c.getTime());
	}

	public static String getAfterDateStr(int days) {
		Calendar c = Calendar.getInstance();
		c.add(6, days);
		return converDateToString(c.getTime(), "yyyy-MM-dd");
	}

	public static long getMillisOfDate(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		return c.getTimeInMillis();
	}

	public static int getDiffSecBetweenBothDate(Date beginTime, Date endTime) {
		return Math.abs((int) ((endTime.getTime() - beginTime.getTime()) / 1000L));
	}

	public static String getNowTime() {
		SimpleDateFormat sm = new SimpleDateFormat("yyyyMMddHHmmss");
		String time = sm.format(new Date());
		return time;
	}

	public static String getNowYear() {
		String year = DateUtil.getNowTime().substring(0, 4);
		return year;
	}

	public static String getNowMonth() {
		String month = DateUtil.getNowTime().substring(4, 6);
		return month;
	}

	public static String getNowDay() {
		String day = DateUtil.getNowTime().substring(6, 8);
		return day;
	}

	public static int getNowWeek() {
		Calendar ca = Calendar.getInstance();
		ca.setTime(new Date());
		int weekNum = ca.get(Calendar.WEEK_OF_YEAR);
		return weekNum;
	}

	public static String getNowDate() {
		String date = DateUtil.getNowTime().substring(0, 8);
		return date;
	}


	//查看当月第几周
	public static int getNowFewDate() throws ParseException {
		String dateString = DateUtil.getNowDate();

		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		Date date = sdf.parse(dateString);

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int weekOfMonth = calendar.get(Calendar.WEEK_OF_MONTH);
		return weekOfMonth;
	}

	//查看周几
	public static int getNowFewweek() throws ParseException {
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		int weekday = cal.get(Calendar.DAY_OF_WEEK) - 1;
		return weekday;
	}

	//返回对应星期的天数
	public static String getDayForWeekDay(int i, int imomth, int fewWeek) throws ParseException {
		//获取当前时间戳
		Long dayT = System.currentTimeMillis() / 1000 / 60 / 60 / 24;
		//要查的时间戳
		Long daySelect = dayT - (i - imomth + 1 - fewWeek);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		// 时间戳转换成时间
		String sd = sdf.format(new Date(Long.parseLong(String.valueOf(daySelect * 1000 * 60 * 60 * 24))));
		String dayNow = sd.substring(6, 8);
		return dayNow;
	}


}