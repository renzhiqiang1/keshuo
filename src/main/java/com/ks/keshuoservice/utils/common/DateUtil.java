package com.ks.keshuoservice.utils.common;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 日期转换类
 * @author Happy
 *
 */
public class DateUtil {
	
	private final static SimpleDateFormat sdfYear = new SimpleDateFormat("yyyy");
    private final static SimpleDateFormat sdfDay = new SimpleDateFormat("yyyy-MM-dd");
    private final static SimpleDateFormat sdfDays = new SimpleDateFormat("yyyyMMdd");
    private final static SimpleDateFormat sdfTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private final static SimpleDateFormat sdfssTime = new SimpleDateFormat("yyyy-MM-dd HH:ss:mm");
    private final static SimpleDateFormat sdfTimes = new SimpleDateFormat("yyyyMMddHHmmss");
    private final static SimpleDateFormat sdfTimesss = new SimpleDateFormat("yyyyMMddHHmmssSSS");
    private final static SimpleDateFormat sdfdate = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    private final static SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss:SSS");
    private final static SimpleDateFormat sdfTimeZw = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
	
    
    public static String getHmDataString(){
    	String formatStr =formatter.format(new Date());
    	return formatStr;
    }
    
	public static String formatTimestamp(Timestamp t){
		if(t==null) return "";
		DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(t).toString();
	}
	
	
	@SuppressWarnings("static-access")
	public static Date addMinute(Date t,int time){
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(t);
		calendar.add(calendar.MINUTE, time);
		return calendar.getTime();
	}
	
	
	@SuppressWarnings("static-access")
	public static Date addDay(Date t,int days){
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(t);
		calendar.add(calendar.DATE, days);
		return calendar.getTime();
	}
	
	public static Timestamp getCurrentTimestamp() throws ParseException{ 
		Timestamp tt = new Timestamp(new Date().getTime());
		return tt;
	}
	public static Date getCurrentTime() throws ParseException{
		SimpleDateFormat dateWithHour = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date tt = new java.sql.Date(dateWithHour.parse(dateWithHour.format(new Date())).getTime());
		return tt;
	}
	public static Date getCurrentTimes() throws ParseException{
		SimpleDateFormat dateWithHour = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date tt = new java.sql.Date(dateWithHour.parse(dateWithHour.format(new Date())).getTime());
		return tt;
	}
	
	public static Date getCurrentDate(){
		return new Date();
	} 
	
	public static java.sql.Date getCurrentSqlDate(){ 
		java.sql.Date dt = new java.sql.Date(new Date().getTime());
		return dt;
	}
	
	
	public static Date stringToDate(String date) throws ParseException{
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");//小写的mm表示的是分钟  
		return sdf.parse(date);
	}
	
	
	
	public static Date stringNameListToDate(String date) throws ParseException{
		SimpleDateFormat sdf = null;
		if(date.contains("-")){
			sdf=new SimpleDateFormat("yyyy-MM-dd");//小写的mm表示的是分钟  
		}else if(date.contains("/")){
			sdf=new SimpleDateFormat("yyyy/MM/dd");//小写的mm表示的是分钟  
		}else{
			if(date.length()==8){
				sdf=new SimpleDateFormat("yyyyMMdd");//小写的mm表示的是分钟  
			}else if(date.length()==14){
				sdf=new SimpleDateFormat("yyyyMMddHHmmss");//小写的mm表示的是分钟 
			}else if(date.length()==17){
				sdf=new SimpleDateFormat("yyyyMMddHHmmssSSS");//小写的mm表示的是分钟 
			}
		}
		return sdf.parse(date);
	}
	
	
	public static Date ssMMSringToDate(String date) throws ParseException{
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");//小写的mm表示的是分钟  
		return sdf.parse(date);
	}
	
	/*
	 * string日期转换为年月日时分秒格式
	 */
	public static Date stringToDateSs(String date) throws ParseException{
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//小写的mm表示的是分钟  
		return sdf.parse(date);
	}
	
	public static String getStringData(String date){
		String time = date.substring(0, 4) + "-" + date.substring(4, 6) + "-" + date.substring(6, 8);
		return time;
	}
	

	
	public static String dateToString(Date date) throws ParseException{
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");//小写的mm表示的是分钟 
		return sdf.format(date);
	}
	
	public static String dateToStringMm(Date date) throws ParseException{
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm");//小写的mm表示的是分钟  
		return sdf.format(date); 
	}
	
	public static String dateToStringSs(Date date) throws ParseException{
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//小写的mm表示的是分钟  
		return sdf.format(date); 
	}
	
	public static String stringDateToString(String str) throws ParseException{
		if(str==null||str.equals("")){
			return "";
		}
		Date date = new SimpleDateFormat("yyMMdd").parse(str);
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd"); 
		return sdf.format(date); 
	}
	
	public static String stringDateTosString(String str) throws ParseException{
		if(str==null||str.equals("")){
			return "";
		}
		Date date = new SimpleDateFormat("yy-MM-dd").parse(str);
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd"); 
		return sdf.format(date); 
	}
	
	public static String stringDateMmToString(String str) throws ParseException{
		if(str==null||str.equals("")){
			return "";
		}
		Date date = new SimpleDateFormat("yyMMddHHmm").parse(str);
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm"); 
		return sdf.format(date); 
	}
	public static String stringDateSssToString(String str) throws ParseException{
		if(str==null||str.equals("")){
			return "";
		}
		Date date = new SimpleDateFormat("yyMMddHHmmssSSS").parse(str);
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
		return sdf.format(date); 
	}
	
	public static String strTostr(String str) throws ParseException{
		if(str==null||str.equals("")){
			return "";
		}
		Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(str);
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd"); 
		return sdf.format(date); 
	}
	
	
	public static String dateToStringbm(Date date) throws ParseException{
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");//小写的mm表示的是分钟  
		return sdf.format(date); 
	}
	public static String dateToStringZW(Date date) throws ParseException{
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy年-MM月-dd日");//小写的mm表示的是分钟  
		return sdf.format(date); 
	}	
	public static String dateToStringZWNO(Date date) throws ParseException{
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy年MM月dd日");//小写的mm表示的是分钟  
		return sdf.format(date); 
	}
	
	public static java.sql.Date DateToSqlDate(Date date) throws ParseException{
		return new java.sql.Date(date.getTime()) ;
	}
	
	public static java.sql.Date stringToSqlDate(String date) throws ParseException{
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");//小写的mm表示的是分钟  
		return DateToSqlDate(sdf.parse(date));
	}
	
	public static java.sql.Date stringNumberToSqlDate(String date) throws ParseException{
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");//小写的mm表示的是分钟  
		return DateToSqlDate(sdf.parse(date));
	}
	
	public static String stringNumberYyToSqlDate(String str) throws ParseException{
		SimpleDateFormat sdf=new SimpleDateFormat("yyMMdd");
		Date date= sdf.parse(str);
		SimpleDateFormat sdfo=new SimpleDateFormat("yyyy-MM-dd");
		return sdfo.format(date); 
	}
	
	
	public static String stringNumberYYYYToSqlDate(String str) throws ParseException{
		if(str==null || str.trim().length()!=8)
			return null;
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");
		Date date= sdf.parse(str);
		SimpleDateFormat sdfo=new SimpleDateFormat("yyyy-MM-dd");
		return sdfo.format(date); 
	}
	
	public static String stringToSqlStr(String str) throws ParseException{
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
		Date date= sdf.parse(str);
		SimpleDateFormat sdfo=new SimpleDateFormat("yyyy-MM-dd");
		return sdfo.format(date); 
	}
	
	
	public static Date stringNumberToDate(String date) throws ParseException{
		SimpleDateFormat sdf=new SimpleDateFormat("yyMMddHHmm");//小写的mm表示的是分钟  
		return sdf.parse(date);
	}
	public static java.sql.Date stringToSqlTime(String date) throws ParseException{
		if(date!=null){
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//小写的mm表示的是分钟  
			return DateToSqlDate(sdf.parse(date));
		}else{
			return null;
		}
	
	}
	public static Date stringToSqlMilliTimeFormatYYMMDD(String date) throws ParseException{
		SimpleDateFormat sdf=new SimpleDateFormat("yyMMddHHmmssSSS");//小写的mm表示的是分钟  
		return sdf.parse(date);
	}
	public static Date stringToSqlMilliTime(String date) throws ParseException{
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmssSSS");//小写的mm表示的是分钟  
		return sdf.parse(date);
	}
	public static String SqlDateToString(java.sql.Date date) throws ParseException{
		Date utilDate = new Date(date.getTime());
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");//小写的mm表示的是分钟  
		return sdf.format(utilDate); 
	}
	public static String SqlDateToyyMMddString(Date departdate) throws ParseException{
		Date utilDate = new Date(departdate.getTime());
		SimpleDateFormat sdf=new SimpleDateFormat("yyMMddHHmm");//小写的mm表示的是分钟  
		return sdf.format(utilDate); 
	}
	public static java.sql.Date addDay(java.sql.Date t,int days) throws ParseException{
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(new Date(t.getTime()));
		calendar.add(calendar.DATE, days);
		return DateToSqlDate(calendar.getTime());
	}
	public static String currentTimeString(Date date){
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmssSSS");//小写的mm表示的是分钟  
		return sdf.format(date); 
	}
	public static String currentTimeYYString(Date date){
		SimpleDateFormat sdf=new SimpleDateFormat("yyMMddHHmmssSSS");//小写的mm表示的是分钟  
		return sdf.format(date); 
	}
	public static Date stringToDateDynamicByLength(String date,Long lenght) throws Exception{
		if(lenght==8){
			SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");//小写的mm表示的是分钟  
			return sdf.parse(date);
		}else if(lenght==14){
			SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");//小写的mm表示的是分钟 
			return sdf.parse(date);
		}else if(lenght==17){
			SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmssSSS");//小写的mm表示的是分钟 
			return sdf.parse(date);
		}else{
			throw new Exception("date parameer conversion exception");
		}
	}
	
	public static Date stringToDateDynamic(String stringDate) throws Exception{
		if(stringDate!=null && stringDate.trim().length()>0){
			if(stringDate.trim().length()==6){
				Date date = new SimpleDateFormat("yyMMdd").parse(stringDate.trim());
				return date;
			}else if(stringDate.trim().length()==8){
				SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");//小写的mm表示的是分钟  
				return sdf.parse(stringDate.trim());
			}else if(stringDate.trim().length()==12){
				SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmm");//小写的mm表示的是分钟 
				return sdf.parse(stringDate.trim());
			}else if(stringDate.trim().length()==14){
				SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");//小写的mm表示的是分钟 
				return sdf.parse(stringDate.trim());
			}else if(stringDate.trim().length()==17){
				SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmssSSS");//小写的mm表示的是分钟 
				return sdf.parse(stringDate.trim());
			}else{
				return null;
			}
		}else{
			return null;
		}
	}
	
	public static Date stringToDateBQDate(String stringDate) throws Exception{
	
		if(stringDate!=null && stringDate.trim().length()>0){
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
			Date date = new Date();
			String year = sdf.format(date);
			String yearFrontTwo = year.substring(0, 2);
			String yearLaterTwo = year.substring(2, year.length());
			
			if(Integer.parseInt(stringDate)>Integer.parseInt(yearLaterTwo)){
				stringDate = Integer.parseInt(yearFrontTwo) - 1 + stringDate;
			}else{
				stringDate = Integer.parseInt(yearFrontTwo) + stringDate;
			}
			 return sdf.parse(stringDate);
		}else{
			return null;
		}
	
	}
	
	/**
	 * 针对年是两位
	 * 转换日期
	 * @param template
	 * 		目标格式
	 * @return
	 * @throws Exception
	 */
	public static String longDateToStringDynamic(Long temp,String template) throws Exception{
		if(temp!=null){
			String stringDate=String.valueOf(temp);
			SimpleDateFormat tempSdf=new SimpleDateFormat(template);
			if(stringDate.trim().length()==6){
				Date date = new SimpleDateFormat("yyMMdd").parse(stringDate);
				return tempSdf.format(date);
			}else if(stringDate.trim().length()==10){
				Date date = new SimpleDateFormat("yyMMddHHmm").parse(stringDate);
				return tempSdf.format(date);
			}else if(stringDate.trim().length()==12){
				Date date = new SimpleDateFormat("yyMMddHHmmss").parse(stringDate);
				return tempSdf.format(date);
			}else if(stringDate.trim().length()==15){
				Date date = new SimpleDateFormat("yyMMddHHmmssSSS").parse(stringDate);
				return tempSdf.format(date);
			}else{
				return null;
			}
		}else{
			return null;
		}
	}
	
	
	/**
	 * 针对年是两位
	 * 转换日期
	 * @param stringDate
	 * 		原字符串
	 * @param template
	 * 		目标格式
	 * @return
	 * @throws Exception
	 */
	public static String stringDateToStringDynamic(String stringDate,String template) throws Exception{
		if(stringDate!=null && stringDate.trim().length()>0){
			SimpleDateFormat tempSdf=new SimpleDateFormat(template);
			if(stringDate.trim().length()==6){
				Date date = new SimpleDateFormat("yyMMdd").parse(stringDate);
				return tempSdf.format(date);
			}else if(stringDate.trim().length()==10){
				Date date = new SimpleDateFormat("yyMMddHHmm").parse(stringDate);
				return tempSdf.format(date);
			}else if(stringDate.trim().length()==12){
				Date date = new SimpleDateFormat("yyMMddHHmmss").parse(stringDate);
				return tempSdf.format(date);
			}else if(stringDate.trim().length()==15){
				Date date = new SimpleDateFormat("yyMMddHHmmssSSS").parse(stringDate);
				return tempSdf.format(date);
			}else{
				return null;
			}
		}else{
			return null;
		}
	}
	
	public static String dateToFormatString(Date date){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
		return sdf.format(date);
	}
	
	public static long timeDiff(Date date1, Date date2){
		return date1.getTime() - date2.getTime();
	}
	
	@SuppressWarnings("static-access")
	public static Date addTime(Date t,int time){
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(t);
		calendar.add(calendar.MILLISECOND, time);
		return calendar.getTime();
	}
	
	/**
	 * 返回格式化分钟
	 * 时达
	 * 2018年7月19日20:30:40
	 */
	public static String oneMin (Date date){
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
		String string = sdf.format(date);
		return string;
	}
	/**
	 * 返回格式化小时
	 * 时达
	 * 2018年7月19日20:22:49
	 */
	public static String oneHour (Date date){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:00:00");
		String string = sdf.format(date);
/*		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		String string = sdf.format(date).substring(0,13);
*/		/*string += ":00:00";*/
		return string;
	}
	
	/**
	 * 返回格式化天
	 * 时达
	 * 2018年7月19日20:23:09
	 */
	public static String oneDay (Date date){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String string = sdf.format(date);
		return string;
	}
	
	/**
	 * 返回格式化话每年第几周
	 * 时达
	 * 2018年7月19日20:26:09
	 */
	public static String oneWeek (Date date){
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		String week = Integer.toString(c.get(Calendar.WEEK_OF_YEAR));
		if (week.length() == 1)
		week = "0" + week;
		String year = Integer.toString(c.get(Calendar.YEAR));
		return year +"第"+ week+"周";
	}
	
	/**
	 * 返回格式化话每年第几周
	 * 时达
	 * 2018年7月19日20:26:09
	 */
	public static String oneWeeks (Date date){
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		String week = Integer.toString(c.get(Calendar.WEEK_OF_YEAR));
		if (week.length() == 1)
		week = "0" + week;
		String year = Integer.toString(c.get(Calendar.YEAR));
		return year +"年第"+ week+"周";
	}
	
	/**
	 * 返回格式化每年第几月
	 * 时达
	 * 2018年7月19日20:28:24
	 */
	public static String oneMonth (Date date){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
		String string = sdf.format(date);
		return string;
	}
	
	/**
	 * 返回特定时间格式数据
	 * 2018年7月19日20:28:24
	 */
	public static Map<String,Date> buildTaskDate(Date date,String type){
		Map<String,Date> result=new HashMap<String,Date>();
		
		if("week".equals(type)){
			Calendar instance = Calendar.getInstance();
			instance.setTime(date);
			instance.set(Calendar.HOUR_OF_DAY, 0);
			instance.set(Calendar.MINUTE, 0);
			instance.set(Calendar.SECOND, 0);
			
			int week=instance.get(Calendar.WEEK_OF_YEAR);//当前时间处于当年第几周
			instance.set(Calendar.WEEK_OF_YEAR, week);
			instance.set(Calendar.DAY_OF_WEEK, 2);//周一
			
			//结束时间
			Date endDate=instance.getTime();
			
			//中间间隔差距1周
			instance.add(Calendar.WEEK_OF_YEAR, -1);
			Date beginDate=instance.getTime();//和endDate 非同一个对象，已验证
			
			result.put("beginDate", beginDate);
			result.put("endDate", endDate);
		}else if("month".equals(type)){
			Calendar instance = Calendar.getInstance();
			instance.setTime(date);
			instance.set(Calendar.HOUR_OF_DAY, 0);
			instance.set(Calendar.MINUTE, 0);
			instance.set(Calendar.SECOND, 0);
			instance.set(Calendar.DAY_OF_MONTH, 1);
			
			//结束时间
			Date endDate=instance.getTime();
			//中间间隔差距一个月
			instance.add(Calendar.MONTH, -1);
			Date beginDate=instance.getTime();//和endDate 非同一个对象，已验证
			
			result.put("beginDate", beginDate);
			result.put("endDate", endDate);
		}
		
		return result;
	}
	
	/**
     * 两日期相减得到天数
     *
     * @param beginDate
     * @param endDate
     * @return long
     * @author Administrator
     */
    public static long getDaysBySub(Date beginDate, Date endDate) {
        long day = (endDate.getTime() - beginDate.getTime()) / (24 * 60 * 60 * 1000);
        return day;
    }
    
    /**
     * <li>功能描述：时间相减得到天数
     *
     */
    public static long getDaySub(String beginDateStr, String endDateStr) {
        long day = 0;
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date beginDate = null;
        Date endDate = null;

        try {
            beginDate = sdfTimes.parse(beginDateStr);
            endDate = sdfTimes.parse(endDateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        day = (endDate.getTime() - beginDate.getTime()) / (24 * 60 * 60 * 1000);
        //System.out.println("相隔的天数="+day);

        return day;
    }
    
    /**
     * 获取n天前或n天后的YYYYMMDD格式
	 * n是正数表示n天后，n是负数表示n天前，0表示当前时间
     * 返回字符串格式
     * @return
     */
	 public static String getTomorrowDays(int n) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        Calendar c = Calendar.getInstance();
        //-1.昨天时间 0.当前时间 1.明天时间 *以此类推
        c.add(Calendar.DATE, n);
        String time = sdf.format(c.getTime());
        return time;
    }
	 
	   /**
	     * 获取yyyyMMddHHmmss格式
	     * 返回字符串格式
	     * @return
	     */
	    public static String getSdfTimes() {
	        return sdfTimes.format(new Date());
	    }
	    
	    /**
	     * 获取yyyyMMddHHmmss格式
	     * 返回字符串格式
	     * @return
	     * @throws ParseException 
	     */
	    public static String getSdfTimes(Date date) throws ParseException {
			String strDate = sdfTimes.format(date);
			return strDate; 
	    }
	    
	    /**
	     * 获取yyyyMMddHHmmss格式
	     * 返回字符串格式
	     * @return
	     * @throws ParseException 
	     */
	    public static Date getSdfTimes(String date) throws ParseException {
			Date dateTime = sdfTimes.parse(date);
			return dateTime; 
	    }
	    
	    /**
	     * 获取yyyyMMddHHmmssSS格式
	     * 返回字符串格式
	     * @return
	     */
	    public static String getSdfTimesss() {
	        return sdfTimesss.format(new Date());
	    }
	    
	    /**
	     * 获取yyyy-MM-dd HH:mm:ss格式
	     * 返回字符串格式
	     * @return
	     */
	    public static String getSdfTime() {
	        return sdfTime.format(new Date());
	    }
	    
	    /**
	     * 转yyyy格式
	     * 返回字符串格式
	     * @return
	     */
	    public static String getYearByDate() {
	        return sdfYear.format(new Date());
	    }
	    
	    /**
	     * 转yyyy-MM-dd格式
	     * 返回字符串格式
	     * @return
	     * @throws ParseException 
	     */
	    public static Date getSdfTimeYmdByDate(Date date) throws ParseException {
	         String strSdfDay = sdfDay.format(date);
	         return sdfDay.parse(strSdfDay);
	    }
	    
	    /**
	     * 转yyyy-MM-dd格式
	     * 返回字符串格式
	     * @return
	     * @throws ParseException 
	     */
	    public static Date getSdfTimeYmdByDate(String date) throws ParseException {
	        return sdfDay.parse(date);
	    }
	    	    
	    /**
	     * 转yyyy-MM-dd格式
	     * 返回字符串格式
	     * @return
	     */
	    public static String getSdfTimeYmdByDate(java.sql.Date date) {
	        return sdfDay.format(date);
	    }
	    
	    /**
	     * 转yyyy-MM-dd格式
	     * 返回字符串格式
	     * @return
	     */
	    public static String getSdfTimeYmdByDateStr(Date date) {
	        return sdfDay.format(date);
	    }
	    
	    /**
	     * 转yyyy-MM-dd HH:mm:ss格式
	     * 返回字符串格式
	     * @return
	     */
	    public static String getSdfTimeYmdHmsByDate(java.sql.Date date) {
	        return sdfTime.format(date);
	    }
	    
	    /**
	     * 转yyyy-MM-dd HH:mm:ss格式
	     * 返回字符串格式
	     * @return
	     */
	    public static String getSdfTimeYmdHmsByDate(Date date) {
	        return sdfTime.format(date);
	    }
	    
	    /**
	     * 转yyyy-MM-dd HH:mm:ss格式
	     * 返回字符串格式
	     * @return
	     */
	    public static Date getSdfTimeYmdHmsByStr(String date) throws ParseException {
	        return sdfTime.parse(date);
	    }
	    
	    /**
	     * 转yyyy-MM-dd HH:mm:ss格式
	     * 返回字符串格式
	     * @return
	     */
	    public static String getSdfTimeYmdHmsByDate() {
	        return sdfTime.format(new Date());
	    }
	    
	    /**
	     * 转yyyy年MM月dd日 HH:mm:ss格式
	     * 返回字符串格式
	     * @return
	     */
	    public static String getSdfTimeZwYmdHmsByDate() {
	        return sdfTimeZw.format(new Date());
	    }
	    
	    
	    /**
	     * 加一天
	     *
	     * @param startDate
	     * @return
	     */
	    public static String dateAddNDay(String startDate, int n) {
	        System.out.println("String类型 " + startDate);//页面传递到后台的时间 为String类型

	        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
	        Date sDate = null;
	        try {
	            sDate = sdf.parse(startDate);
	        } catch (ParseException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	        System.out.println("String类型转Date类型 " + sDate); //要实现日期+1 需要String转成Date类型

	        Format f = new SimpleDateFormat("yyyy-MM-dd");
	        System.out.println("Date结束日期:" + f.format(sDate));

	        Calendar c = Calendar.getInstance();
	        c.setTime(sDate);
	        c.add(Calendar.DAY_OF_MONTH, n);           //利用Calendar 实现 Date日期+1天

	        sDate = c.getTime();
	        System.out.println("Date结束日期+1 " + f.format(sDate));//打印Date日期,显示成功+1天

	        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyyMMddHHmmss");
	        startDate = sdf1.format(sDate);
	        System.out.println("Date类型转String类型  " + startDate);//将日期转成String类型 方便进入数据库比较
	        return startDate;
	    }
	    
	    /**
	     * 比较date1 是否小于 date2 ；
	     *
	     * @param date1
	     * @param date2
	     * @return 小于返回 true、大于返回 false
	     */
	    public static boolean compareDateByDate(String date1, String date2) {
//	        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
	        boolean result = false;
	        try {
	            Date formatDate1 = sdfTimes.parse(date1);
	            Date formatDate2 = sdfTimes.parse(date2);
	            result = formatDate1.before(formatDate2);
//	            result = formatDate1.getTime() <= formatDate2.getTime();
	        } catch (ParseException e) {
	            e.printStackTrace();
	        }
	        return result;
	    }
	    
	    /**
	     * 给时间加上几个小时
	     * @param day 当前时间 格式：yyyy-MM-dd HH:mm:ss
	     * @param hour 需要加的时间
	     * @return
	     */
	    public static String addDateMinut(String day, int hour){   
	    	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    	Date date = null;   
	    	try {   
	    		date = format.parse(day);   
	    	} catch (Exception ex) {   
	    		ex.printStackTrace();   
	    	}   
	    	if (date == null)   
	    		return "";   
	    	Calendar cal = Calendar.getInstance();   
	    	cal.setTime(date);   
	    	cal.add(Calendar.HOUR, hour);// 24小时制   
	    	date = cal.getTime();   
	    	cal = null;   
	    	return format.format(date);   
	    	
	    }
	    
	    /**
	     * 获取全年日期
	     * @throws ParseException
	     */
	    public static List<String> getYearDateList() throws ParseException {
	    	List<String> yearList = new ArrayList<String>();
	    	String getYear = sdfYear.format(new Date());
		    String dateStart=getYear+"-01-01";
		    String dateEnd=getYear+"-12-31";
		    SimpleDateFormat date=new SimpleDateFormat("yyyy-MM-dd");
		    long startTime = date.parse(dateStart).getTime();//start
		    long endTime = date.parse(dateEnd).getTime();//end
		    long day=1000*60*60*24;
		    for(long i=startTime;i<=endTime;i+=day) {
		    	yearList.add(date.format(new Date(i)));
	        }
		    return yearList;
	    }
	    
	    /**
	     * 两日期相减得到小时
	     *
	     * @param beginDate
	     * @param endDate
	     * @return long
	     * @author Administrator
	     */
	    public static long getDaysByHour(Date beginDate, Date endDate) {
	        long day = ((endDate.getTime() - beginDate.getTime()) / (60 * 60 * 1000))%24;
	        return day;
	    }
	    
	    /**
	     * 获取当前日期减去指定年数
	     * @param num
	     * @return
	     */
	    public static String getYearReduceNum(int num) {
	    	Date date = new Date();//获取当前时间  
	    	Calendar calendar = Calendar.getInstance();  
	    	calendar.setTime(date);  
	    	calendar.add(Calendar.YEAR, -num);//当前时间减去一年，即一年前的时间  
	        return sdfDays.format(calendar.getTime());
		}
	    
	    /**
	     * 获取当前日期减去指定天数
	     * @param num
	     * @return
	     */
	    public static String getDayReduceNum(int num) {
	    	Date date = new Date();//获取当前时间  
	    	Calendar calendar = Calendar.getInstance();  
	    	calendar.setTime(date);  
	    	calendar.add(Calendar.DAY_OF_MONTH, -num);//当前时间减去指定天数
	        return sdfDay.format(calendar.getTime());
		}
	    
	    /**
	     * 获取当前日期（年月日）
	     * @param num
	     * @return
	     */
	    public static String getStrTimeYmd() {
	    	Date date = new Date();//获取当前时间   
	        return sdfDays.format(date);
		}
	    
	    /**
	     * 计算两个时间合计小时，精确至分钟。
	     * @param startTime 开始时间
	     * @param endTime 结束时间
	     * @return
	     * @throws ParseException 
	     */
	    public static double getDobMinute(String startTime,String endTime) throws ParseException {
	    	double retMinute = 0;
	    	
	    	 Date d1 = sdfTime.parse(startTime);
             Date d2 = sdfTime.parse(endTime);
             
             long diff = d2.getTime() - d1.getTime();//这样得到的差值是毫秒级别  
             //获取天
             long days = diff / (1000 * 60 * 60 * 24);         
             //获取小时
             long hours = (diff-days*(1000 * 60 * 60 * 24))/(1000* 60 * 60);  
             //获取分钟
             long minutes = (diff-days*(1000 * 60 * 60 * 24)-hours*(1000* 60 * 60))/(1000* 60);           
             //将分钟转换小时，保留后两位。
             double dobMm = Double.parseDouble(minutes+"") / 60;
             //将天转换小时
             long daysTurnHours = days*24;
             
             retMinute = Double.parseDouble(String.format("%.2f", dobMm+hours+daysTurnHours));
                                  
	    	
	    	return retMinute;
		}
	    
	    /**
	     * 得到小时
	     */
	    public static String getHour(Date currentTime) {
	      SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	      String dateString = formatter.format(currentTime);
	      String hour;
	      hour = dateString.substring(11, 13);
	      return hour;
	    }
	   
	    /**
	     * 得到分钟
	     *
	     * @return
	     */
	    public static String getTime(Date currentTime) {
	      SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	      String dateString = formatter.format(currentTime);
	      String min;
	      min = dateString.substring(14, 16);
	      return min;
	    }
}
