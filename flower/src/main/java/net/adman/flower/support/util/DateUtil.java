package net.adman.flower.support.util;

import java.text.ParseException;
import java.util.Date;

import org.apache.commons.lang3.time.DateUtils;
import org.apache.commons.lang3.time.FastDateFormat;

public class DateUtil {
	public static final String FMT_DATE_DASHED_TIME_COLONED = "yyyy-MM-dd HH:mm:ss";
	public static final String FMT_DATE_TIME_ISO_8601 = "yyyy-MM-dd'T'HH:mm:ss";
	public static final String FMT_DATE_TIME = "yyyyMMddHHmmss";
	public static final String FMT_DATE_SLASHED = "yyyy/MM/dd";
	public static final String FMT_DATE = "yyyyMMdd";
	
	public enum Format {
		/**
		 * yyyy-MM-dd HH:mm:ss
		 */
		DateDashedTimeColoned(FMT_DATE_DASHED_TIME_COLONED),
		
		/**
		 * yyyy-MM-dd'T'HH:mm:ss
		 */
		DateTimeIso8601(FMT_DATE_TIME_ISO_8601),
		
		/**
		 * yyyyMMddHHmmss
		 */
		DateTime(FMT_DATE_TIME),
		
		/**
		 * yyyy/MM/dd
		 */
		DateSlashed(FMT_DATE_SLASHED),
		
		/**
		 * yyyyMMdd
		 */
		Date(FMT_DATE);
		
		private String pattern;
		
		private Format(String pattern) {
			this.pattern = pattern;
		}
		public String getPattern() {
			return pattern;
		}
		public FastDateFormat getInstance() {
			return FastDateFormat.getInstance(pattern);
		}
		public static Format get(String str) {
			return valueOf(str);
		}
	}
	
	public static String expr(Date date, FastDateFormat format) {
		return format.format(date);
	}
	public static String expr(Date date, Format format) {
		return expr(date, format.getInstance());
	}
	public static String expr(Date date) {
		return expr(date, Format.DateDashedTimeColoned);
	}
	public static String exprNow(FastDateFormat format) {
		return expr(new Date(), format);
	}
	public static String exprNow(String format) {
		return exprNow(FastDateFormat.getInstance(format));
	}
	
	public static Date parse(String str, String pattern) throws ParseException {
		return DateUtils.parseDate(str, pattern);
	}
	public static Date parse(String str, Format format) throws ParseException {
		return parse(str, format.getPattern());
	}
	
	public static Date yesterday() {
		return DateUtils.addDays(new Date(), -1);
	}
}
