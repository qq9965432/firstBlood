/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.wist_bean.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang3.time.DateFormatUtils;

/**
 * 日期工具类, 继承org.apache.commons.lang.time.DateUtils类
 * @author jeeplus
 * @version 2014-4-15
 */
public class DateUtils extends org.apache.commons.lang3.time.DateUtils {
	
	private static String[] parsePatterns = {
		"yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm", "yyyy-MM", 
		"yyyy/MM/dd", "yyyy/MM/dd HH:mm:ss", "yyyy/MM/dd HH:mm", "yyyy/MM",
		"yyyy.MM.dd", "yyyy.MM.dd HH:mm:ss", "yyyy.MM.dd HH:mm", "yyyy.MM"};

	/**
	 * 得到当前日期字符串 格式（yyyy-MM-dd）
	 */
	public static String getDate() {
		return getDate("yyyy-MM-dd");
	}
	
	/**
	 * 得到当前日期字符串 格式（yyyy-MM-dd） pattern可以为："yyyy-MM-dd" "HH:mm:ss" "E"
	 */
	public static String getDate(String pattern) {
		return DateFormatUtils.format(new Date(), pattern);
	}
	
	/**
	 * 得到日期字符串 默认格式（yyyy-MM-dd） pattern可以为："yyyy-MM-dd" "HH:mm:ss" "E"
	 */
	public static String formatDate(Date date, Object... pattern) {
		String formatDate = null;
		if(date != null){
			if (pattern != null && pattern.length > 0) {
				formatDate = DateFormatUtils.format(date, pattern[0].toString());
			} else {
				formatDate = DateFormatUtils.format(date, "yyyy-MM-dd");
			}
		}
		
		return formatDate;
	}
	
	/**
	 * 得到日期时间字符串，转换格式（yyyy-MM-dd HH:mm:ss）
	 */
	public static String formatDateTime(Date date) {
		return formatDate(date, "yyyy-MM-dd HH:mm:ss");
	}

	/**
	 * 得到当前时间字符串 格式（HH:mm:ss）
	 */
	public static String getTime() {
		return formatDate(new Date(), "HH:mm:ss");
	}

	/**
	 * 得到当前日期和时间字符串 格式（yyyy-MM-dd HH:mm:ss）
	 */
	public static String getDateTime() {
		return formatDate(new Date(), "yyyy-MM-dd HH:mm:ss");
	}

	/**
	 * 得到当前年份字符串 格式（yyyy）
	 */
	public static String getYear() {
		return formatDate(new Date(), "yyyy");
	}

	/**
	 * 得到当前月份字符串 格式（MM）
	 */
	public static String getMonth() {
		return formatDate(new Date(), "MM");
	}

	/**
	 * 得到当天字符串 格式（dd）
	 */
	public static String getDay() {
		return formatDate(new Date(), "dd");
	}

	/**
	 * 得到当前星期字符串 格式（E）星期几
	 */
	public static String getWeek() {
		return formatDate(new Date(), "E");
	}
	
	/**
	 * 日期型字符串转化为日期 格式
	 * { "yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm", 
	 *   "yyyy/MM/dd", "yyyy/MM/dd HH:mm:ss", "yyyy/MM/dd HH:mm",
	 *   "yyyy.MM.dd", "yyyy.MM.dd HH:mm:ss", "yyyy.MM.dd HH:mm" }
	 */
	public static Date parseDate(Object str) {
		if (str == null){
			return null;
		}
		try {
			return parseDate(str.toString(), parsePatterns);
		} catch (ParseException e) {
			return null;
		}
	}

	/**
	 * 获取过去的天数
	 * @param date
	 * @return
	 */
	public static long pastDays(Date date) {
		long t = new Date().getTime()-date.getTime();
		return t/(24*60*60*1000);
	}

	/**
	 * 获取过去的小时
	 * @param date
	 * @return
	 */
	public static long pastHour(Date date) {
		long t = new Date().getTime()-date.getTime();
		return t/(60*60*1000);
	}
	
	/**
	 * 获取过去的分钟
	 * @param date
	 * @return
	 */
	public static long pastMinutes(Date date) {
		long t = new Date().getTime()-date.getTime();
		return t/(60*1000);
	}
	
	/**
	 * 转换为时间（天,时:分:秒.毫秒）
	 * @param timeMillis
	 * @return
	 */
    public static String formatDateTime(long timeMillis){
		long day = timeMillis/(24*60*60*1000);
		long hour = (timeMillis/(60*60*1000)-day*24);
		long min = ((timeMillis/(60*1000))-day*24*60-hour*60);
		long s = (timeMillis/1000-day*24*60*60-hour*60*60-min*60);
		long sss = (timeMillis-day*24*60*60*1000-hour*60*60*1000-min*60*1000-s*1000);
		return (day>0?day+",":"")+hour+":"+min+":"+s+"."+sss;
    }
	
	/**
	 * 获取两个日期之间的天数
	 * 
	 * @param before
	 * @param after
	 * @return
	 */
	public static double getDistanceOfTwoDate(Date before, Date after) {
		long beforeTime = before.getTime();
		long afterTime = after.getTime();
		return (afterTime - beforeTime) / (1000 * 60 * 60 * 24);
	}
	
	
	   /** 
     * 获取date的月份的时间范围 
     * @param date 
     * @return 
     */  
    public static DateRange getMonthRange(Date date) {  
        Calendar startCalendar = Calendar.getInstance();  
        startCalendar.setTime(date);  
        startCalendar.set(Calendar.DAY_OF_MONTH, 1);  
        setMaxTime(startCalendar);  
          
        Calendar endCalendar = Calendar.getInstance();  
        endCalendar.setTime(date);  
        endCalendar.set(Calendar.DAY_OF_MONTH, endCalendar.getActualMaximum(Calendar.DAY_OF_MONTH));  
        setMaxTime(endCalendar);  
          
        return new DateRange(startCalendar.getTime(), endCalendar.getTime());  
    }
    
    /**
     * 
     * <b>方法描述：</b>TODO(获取指定日期的前7天的时间范围)<br/>
     * <b>方法描述：</b>TODO(例如:date时 2017-08-26，那么获取到的时间范围是  2017-08-19~2017-08-25)<br/>
     * <b>参数描述：</b><br/>
     *		@param date
     *		@return<br/>
     * @return DateRange<br/>
     */
	 public static DateRange get7DaysRange(Date date) {  
	     Calendar startCalendar = Calendar.getInstance();  
	     startCalendar.setTime(date);  
	     startCalendar.add(Calendar.DAY_OF_YEAR, -7);  
	     //startCalendar.add(Calendar.DAY_OF_YEAR, -1);  
	     setMinTime(startCalendar);  
		 
	     Calendar endCalendar = Calendar.getInstance();  
	     endCalendar.setTime(date);  
	     endCalendar.add(Calendar.DAY_OF_YEAR, -1);  
	     setMaxTime(endCalendar);  
	     return new DateRange(startCalendar.getTime(), endCalendar.getTime());  
	     
	 }

	/** 
	  * 获取指定日期的前30天的时间范围
	  * 例如，date时 2017-08-26，那么获取到的时间范围是  2017-07-26~2017-08-25
	  * @param date 
	  * @return 
	  */  
	 public static DateRange get30DaysRange(Date date) {  
	     Calendar startCalendar = Calendar.getInstance();  
	     startCalendar.setTime(date);  
	     startCalendar.add(Calendar.MONTH, -1);  
	     //startCalendar.add(Calendar.DAY_OF_YEAR, -1);  
	     setMinTime(startCalendar);  
	       
	     Calendar endCalendar = Calendar.getInstance();  
	     endCalendar.setTime(date);  
	     endCalendar.add(Calendar.DAY_OF_YEAR, -1);  
	     setMaxTime(endCalendar);  
	       
	     return new DateRange(startCalendar.getTime(), endCalendar.getTime());  
	 }  
	 
	 /** 
	  * 获取指定日期的 最近3个月 的时间范围
	  * 例如，date时 2017-08-26，那么获取到的时间范围是  2017-05-26~2017-08-25
	  * @param date 
	  * @return 
	  */  
	 public static DateRange get90DaysRange(Date date) {  
	     Calendar startCalendar = Calendar.getInstance();  
	     startCalendar.setTime(date);  
	     startCalendar.add(Calendar.MONTH, -3);  
	     //startCalendar.add(Calendar.DAY_OF_YEAR, -1);  
	     setMinTime(startCalendar);  
	       
	     Calendar endCalendar = Calendar.getInstance();  
	     endCalendar.setTime(date);  
	     endCalendar.add(Calendar.DAY_OF_YEAR, -1);  
	     setMaxTime(endCalendar);  
	       
	     return new DateRange(startCalendar.getTime(), endCalendar.getTime());  
	 }  	 
    
    /** 
     * 获取当前季度的时间范围 
     * @return current quarter 
     */  
    public static DateRange getThisQuarter() {  
        Calendar startCalendar = Calendar.getInstance();  
        startCalendar.set(Calendar.MONTH, ((int) startCalendar.get(Calendar.MONTH) / 3) * 3);  
        startCalendar.set(Calendar.DAY_OF_MONTH, 1);  
        setMinTime(startCalendar);  
          
        Calendar endCalendar = Calendar.getInstance();  
        endCalendar.set(Calendar.MONTH, ((int) startCalendar.get(Calendar.MONTH) / 3) * 3 + 2);  
        endCalendar.set(Calendar.DAY_OF_MONTH, endCalendar.getActualMaximum(Calendar.DAY_OF_MONTH));  
        setMaxTime(endCalendar);  
          
        return new DateRange(startCalendar.getTime(), endCalendar.getTime());  
    }  
      
    /** 
     * 获取昨天的时间范围 
     * @return 
     */  
    public static DateRange getYesterdayRange() {  
         Calendar startCalendar = Calendar.getInstance();  
         startCalendar.add(Calendar.DAY_OF_MONTH, -1);  
         setMinTime(startCalendar);  
           
         Calendar endCalendar = Calendar.getInstance();  
         endCalendar.add(Calendar.DAY_OF_MONTH, -1);  
         setMaxTime(endCalendar);  
           
         return new DateRange(startCalendar.getTime(), endCalendar.getTime());  
    }  
      
    /** 
     * 获取当前月份的时间范围 
     * @return 
     */  
    public static DateRange getThisMonth(){  
        Calendar startCalendar = Calendar.getInstance();  
        startCalendar.set(Calendar.DAY_OF_MONTH, 1);  
        setMinTime(startCalendar);  
          
        Calendar endCalendar = Calendar.getInstance();  
        endCalendar.set(Calendar.DAY_OF_MONTH, endCalendar.getActualMaximum(Calendar.DAY_OF_MONTH));  
        setMaxTime(endCalendar);  
          
        return new DateRange(startCalendar.getTime(), endCalendar.getTime());  
    }  
    
    /**
     * 获取当前周的时间范围
     */
    public static DateRange getThisWeek(){
        Calendar startCalendar = Calendar.getInstance();  
        startCalendar.set(Calendar.DAY_OF_WEEK, 2);
        setMinTime(startCalendar);  

        //因为这里的周最后一天是周六，所以要加一天
        Calendar endCalendar = Calendar.getInstance();  
        endCalendar.set(Calendar.DAY_OF_WEEK,Calendar.SATURDAY  );
        endCalendar.add(Calendar.DAY_OF_MONTH, 1);
        setMaxTime(endCalendar);  

        return new DateRange(startCalendar.getTime(), endCalendar.getTime());  
    }
      
    /**
     * 获取当上周的时间范围
     */
    public static DateRange getLastWeek(){
        Calendar startCalendar = Calendar.getInstance();  
        startCalendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        startCalendar.add(Calendar.DAY_OF_MONTH, -7);
        setMinTime(startCalendar);  

        //因为这里的周最后一天是周六，所以要加一天
        Calendar endCalendar = Calendar.getInstance();  
        endCalendar.set(Calendar.DAY_OF_WEEK,Calendar.SATURDAY);
        endCalendar.add(Calendar.DAY_OF_MONTH, 1+(-7));
        setMaxTime(endCalendar);  

        return new DateRange(startCalendar.getTime(), endCalendar.getTime());  
    }
    
    /** 
     * 获取上个月的时间范围 
     * @return 
     */  
    public static DateRange getLastMonth(){  
        Calendar startCalendar = Calendar.getInstance(); 
        //startCalendar.set(Calendar.YEAR, 2016);
        startCalendar.add(Calendar.MONTH, -1);  
        startCalendar.set(Calendar.DAY_OF_MONTH, 1);  
        setMinTime(startCalendar);  
          
        Calendar endCalendar = Calendar.getInstance();  
        //endCalendar.set(Calendar.YEAR, 2016);
        endCalendar.add(Calendar.MONTH, -1);  
        endCalendar.set(Calendar.DAY_OF_MONTH, endCalendar.getActualMaximum(Calendar.DAY_OF_MONTH));  
        setMaxTime(endCalendar);
        
        return new DateRange(startCalendar.getTime(), endCalendar.getTime());  
    }  
      
    /** 
     * 获取上个季度的时间范围 
     * @return 
     */  
    public static DateRange getLastQuarter() {  
        Calendar startCalendar = Calendar.getInstance();  
        startCalendar.set(Calendar.MONTH, ((int) startCalendar.get(Calendar.MONTH) / 3 - 1) * 3);  
        startCalendar.set(Calendar.DAY_OF_MONTH, 1);  
        setMinTime(startCalendar);  
          
        Calendar endCalendar = Calendar.getInstance();  
        endCalendar.set(Calendar.MONTH, ((int) endCalendar.get(Calendar.MONTH) / 3 - 1) * 3 + 2);  
        endCalendar.set(Calendar.DAY_OF_MONTH, endCalendar.getActualMaximum(Calendar.DAY_OF_MONTH));  
        setMaxTime(endCalendar);  
          
        return new DateRange(startCalendar.getTime(), endCalendar.getTime());  
    } 
    
    /**
     * 
     * <b>方法描述：</b>TODO(这是当天的最小时间，即时分秒都是  0)<br/>
     * <b>参数描述：</b><br/>
     *		@param calendar<br/>
     * @return void<br/>
     */
    public static void setMinTime(Calendar calendar){  
        calendar.set(Calendar.HOUR_OF_DAY, 0);  
        calendar.set(Calendar.MINUTE, 0);  
        calendar.set(Calendar.SECOND, 0);  
        calendar.set(Calendar.MILLISECOND, 0);  
    }  
    /**
     * 
     * <b>方法描述：</b>TODO(这是当天的最大时间，即时分秒是   23:59:59)<br/>
     * <b>参数描述：</b><br/>
     *		@param calendar<br/>
     * @return void<br/>
     */      
    public static void setMaxTime(Calendar calendar){  
        calendar.set(Calendar.HOUR_OF_DAY, calendar.getActualMaximum(Calendar.HOUR_OF_DAY));  
        calendar.set(Calendar.MINUTE, calendar.getActualMaximum(Calendar.MINUTE));  
        calendar.set(Calendar.SECOND, calendar.getActualMaximum(Calendar.SECOND));  
        calendar.set(Calendar.MILLISECOND, calendar.getActualMaximum(Calendar.MILLISECOND));  
    }  
     
    /*  */
    public final static String DEFAULT_PATTERN = "MM/dd/yyyy HH:mm:ss";  
    public static String format(Date date){  
        SimpleDateFormat sdf = new SimpleDateFormat(DEFAULT_PATTERN);  
        return sdf.format(date);  
    }  
    
   /*
    public static void main(String[] args) {  
        
        DateRange currentQuarter = getThisQuarter();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(currentQuarter.getStart());
        
        System.out.println("当前季度的时间范围： "+dateFormat.format(currentQuarter.getStart())+" - "+dateFormat.format(currentQuarter.getEnd()));
        
        DateRange lastQuarter = getLastQuarter();  
        System.out.println("上个季度的时间范围: "+dateFormat.format(lastQuarter.getStart())+" - "+dateFormat.format(lastQuarter.getEnd()));  
        
          
          
        DateRange yesterdayRange = getYesterdayRange();  
        System.out.println("昨天的时间范围: "+dateFormat.format(yesterdayRange.getStart())+" - "+dateFormat.format(yesterdayRange.getEnd()));  
          
      
        DateRange thisMonth = getThisMonth();  
        System.out.println("当前月份的时间范围: "+dateFormat.format(thisMonth.getStart())+" - "+dateFormat.format(thisMonth.getEnd()));  
          
        DateRange lastMonth = getLastMonth();  
        System.out.println("上个月的时间范围: "+dateFormat.format(lastMonth.getStart())+" - "+dateFormat.format(lastMonth.getEnd()));  
          
        DateRange thisWeek = getThisWeek();  
        System.out.println("本周的时间范围: "+dateFormat.format(thisWeek.getStart())+" - "+dateFormat.format(thisWeek.getEnd()));
        
        DateRange lastWeek = getLastWeek();  
        System.out.println("上周的时间范围: "+dateFormat.format(lastWeek.getStart())+" - "+dateFormat.format(lastWeek.getEnd()));
        
        //周
        
		Calendar lastCalendar = Calendar.getInstance();
		//lastCalendar.setTime(date);
		lastCalendar.add(Calendar.DAY_OF_YEAR, -7);
		
        DateRange get7DaysRange = get7DaysRange(lastCalendar.getTime());
        System.out.println(dateFormat.format(get7DaysRange.getStart()) + "-" + dateFormat.format(get7DaysRange.getEnd()));
        
        //月

        
        

		
        DateRange get30DaysRange = get30DaysRange(new Date());
        System.out.println(dateFormat.format(get30DaysRange.getStart()) + "-" + dateFormat.format(get30DaysRange.getEnd()));
        
        //季度

        DateRange get90DaysRange = get90DaysRange(new Date());
        System.out.println(dateFormat.format(get90DaysRange.getStart()) + "-" + dateFormat.format(get90DaysRange.getEnd()));

        	
        //季度
        Calendar qCalendar = Calendar.getInstance();
        qCalendar.add(Calendar.MONTH, -3);  
        //qCalendar.set(Calendar.DAY_OF_MONTH, 1);  
        setMinTime(qCalendar);  
        System.out.println(dateFormat.format(qCalendar.getTime()));
        Calendar endCalendar = Calendar.getInstance();  
        endCalendar.set(Calendar.MONTH, ((int) startCalendar.get(Calendar.MONTH) / 3) * 3 + 2);  
        endCalendar.set(Calendar.DAY_OF_MONTH, endCalendar.getActualMaximum(Calendar.DAY_OF_MONTH)); 
	
    }  
  
		*/
        
	
	/**
	 * @param args
	 * @throws ParseException
	 
	public static void main(String[] args) throws ParseException {
//		System.out.println(formatDate(parseDate("2010/3/6")));
//		System.out.println(getDate("yyyy年MM月dd日 E"));
//		long time = new Date().getTime()-parseDate("2012-11-19").getTime();
//		System.out.println(time/(24*60*60*1000));
	}
	*/
}
