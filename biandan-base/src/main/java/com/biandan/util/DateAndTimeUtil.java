package com.biandan.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class DateAndTimeUtil {
	
	/**
	 * 字符串时间转date
	 * @param time
	 * @param format  yyyy-MM-dd HH:mm:ss
	 * @return	
	 * @throws Exception
	 */
	public static Date formatDate(String time,String format) throws Exception{
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.parse(time);
	}
	
	
	/*** 
     * 日期月份减一个月 
     *  
     * @param datetime 
     *            日期(2014-11) 
     * @return 2014-10 
     */  
    public static String dateFormat(String datetime) {  
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");  
        Date date = null;  
        try {  
            date = sdf.parse(datetime);  
        } catch (ParseException e) {  
            e.printStackTrace();  
        }  
        Calendar cl = Calendar.getInstance();  
        cl.setTime(date);  
        cl.add(Calendar.MONTH, -1);  
        date = cl.getTime();  
        return sdf.format(date);  
    }  
  
    public static String dateFormatFull(Date date) {  
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
        return sdf.format(date);  
    }  
    
    public static String dateFormat(Date date) {  
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  
    	return sdf.format(date);  
    }  
  
    /**** 
     * 传入具体日期 ，返回具体日期减一个月。 
     *  
     * @param date 
     *            日期(2014-04-20) 
     * @return 2014-03-20 
     * @throws ParseException 
     */  
    public static String subMonth(String date) throws ParseException {  
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  
        Date dt = sdf.parse(date);  
        Calendar rightNow = Calendar.getInstance();  
        rightNow.setTime(dt);  
  
        rightNow.add(Calendar.MONTH, -1);  
        Date dt1 = rightNow.getTime();  
        String reStr = sdf.format(dt1);  
  
        return reStr;  
    }  
  
    /**** 
     * 获取月末最后一天 
     *  
     * @param sDate 
     *            2014-11-24 
     * @return 30 
     */  
    public static String getMonthMaxDay(String sDate) {  
        SimpleDateFormat sdf_full = new SimpleDateFormat("yyyy-MM-dd");  
        Calendar cal = Calendar.getInstance();  
        Date date = null;  
        try {  
            date = sdf_full.parse(sDate + "-01");  
        } catch (ParseException e) {  
            e.printStackTrace();  
        }  
        cal.setTime(date);  
        int last = cal.getActualMaximum(Calendar.DATE);  
        return String.valueOf(last);  
    }  
    
    //根据月份获得最后一天
    public static String getLastDayOfMonth(int year,int month)  
    {  
        Calendar cal = Calendar.getInstance();  
        //设置年份  
        cal.set(Calendar.YEAR,year);  
        //设置月份  
        cal.set(Calendar.MONTH, month-1);  
        //获取某月最大天数  
        int lastDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);  
        //设置日历中月份的最大天数  
        cal.set(Calendar.DAY_OF_MONTH, lastDay);  
        //格式化日期  
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  
        String lastDayOfMonth = sdf.format(cal.getTime());  
          
        return lastDayOfMonth;  
    } 
  
    // 判断是否是月末  
    public static boolean isMonthEnd(Date date) {  
        Calendar cal = Calendar.getInstance();  
        cal.setTime(date);  
        if (cal.get(Calendar.DATE) == cal  
                .getActualMaximum(Calendar.DAY_OF_MONTH))  
            return true;  
        else  
            return false;  
    }  
  
    /*** 
     * 日期减一天、加一天 
     *  
     * @param option 
     *            传入类型 pre：日期减一天，next：日期加一天 
     * @param dayNum 
     *            增加或者减去的天数
     * @param _date 
     *            2014-11-24 
     * @param _dateFormat 日期格式
     *            默认：yyyy-MM-dd
     * @return 减一天：2014-11-23或(加一天：2014-11-25) 
     */  
    public static String checkOption(String option,int dayNum, String _date,String _dateFormat) { 
    	SimpleDateFormat sdf ;
    	if (_dateFormat != null && !"".equals(_dateFormat)){
    		sdf = new SimpleDateFormat(_dateFormat);
    	}else {
    		sdf = new SimpleDateFormat("yyyy-MM-dd"); 
		}
    	
        Calendar cl = Calendar.getInstance();  
        Date date = null;  
  
        try {  
            date = (Date) sdf.parse(_date);  
        } catch (ParseException e) {  
            e.printStackTrace();  
        }  
        cl.setTime(date);  
        if ("pre".equals(option)) {  
            // 时间减一天  
            cl.add(Calendar.DAY_OF_MONTH, -dayNum);  
  
        } else if ("next".equals(option)) {  
            // 时间加一天  
            cl.add(Calendar.DAY_OF_YEAR, dayNum);  
        } else {  
            // do nothing  
        }  
        date = cl.getTime();  
        return sdf.format(date);  
    }  
    
  
  
    /*** 
     * 判断日期是否为当前月， 是当前月返回当月最小日期和当月目前最大日期以及传入日期上月的最大日和最小日 
     * 不是当前月返回传入月份的最大日和最小日以及传入日期上月的最大日和最小日 
     *  
     * @param date 
     *            日期 例如：2014-11 
     * @return String[] 开始日期，结束日期，上月开始日期，上月结束日期 
     * @throws ParseException 
     */  
    public static String[] getNow_Pre_Date(String date) throws ParseException {  
  
        String[] str_date = new String[4];  
        Date now = new Date();  
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");  
        SimpleDateFormat sdf_full = new SimpleDateFormat("yyyy-MM-dd");  
        String stMonth = sdf.format(now);  
        String stdate = "";// 开始日期  
        String endate = "";// 结束日期  
        String preDate_start = "";// 上月开始日期  
        String preDate_end = "";// 上月结束日期  
  
        // 当前月  
        if (date.equals(stMonth)) {  
            stdate = stMonth + "-01"; // 2014-11-01  
            endate = sdf_full.format(now);// 2014-11-24  
            preDate_start = subMonth(stdate);// 2014-10-01  
            preDate_end = subMonth(endate);// 2014-10-24  
        } else {  
            // 非当前月  
            String monthMaxDay = getMonthMaxDay(date);  
            stdate = date + "-01";// 2014-10-01  
            endate = date + "-" + monthMaxDay;// 2014-10-31  
            preDate_start = subMonth(stdate);// 2014-09-01  
            preDate_end = subMonth(endate);// 2014-09-30  
        }  
        str_date[0] = stdate;  
        str_date[1] = endate;  
        str_date[2] = preDate_start;  
        str_date[3] = preDate_end;  
  
        return str_date;  
    }  
  //获取上个月的今天
    public static Calendar getDateOfLastMonth(Calendar date) {  
        Calendar lastDate = (Calendar) date.clone();  
        lastDate.add(Calendar.MONTH, -1);  
        return lastDate;  
    }  
  //获取上个月的今天
    public static Calendar getDateOfLastMonth(String dateStr) {  
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  
        try {  
            Date date = sdf.parse(dateStr);  
            Calendar c = Calendar.getInstance();  
            c.setTime(date);  
            return getDateOfLastMonth(c);  
        } catch (ParseException e) {  
            throw new IllegalArgumentException("Invalid date format(yyyyMMdd): " + dateStr);  
        }  
    }  
      public static Date getUpWeek(Date date){
    	  Calendar c = Calendar.getInstance();
          
          //过去七天
          c.setTime(date);
          c.add(Calendar.DATE, - 7);
          Date d = c.getTime();
    	  return d;
      }
      /**
       * java获取指定日期所在周的第一天和最后一天
       * @param dataStr
       * @return
       * @throws ParseException
       */
      public static String[] getFirstAndLastOfWeek(String dataStr,String formatStr) throws ParseException {
          Calendar cal = Calendar.getInstance();

          cal.setTime(new SimpleDateFormat("yyyy-MM-dd").parse(dataStr));

          int d = 0;
          if (cal.get(Calendar.DAY_OF_WEEK) == 1) {
              d = -6;
          } else {
              d = 2 - cal.get(Calendar.DAY_OF_WEEK);
          }
          cal.add(Calendar.DAY_OF_WEEK, d);
          // 所在周开始日期
          String data1 = new SimpleDateFormat(formatStr).format(cal.getTime());
          cal.add(Calendar.DAY_OF_WEEK, 6);
          // 所在周结束日期
          String data2 = new SimpleDateFormat(formatStr).format(cal.getTime());
          String[] result={data1,data2};
          return result;

      }
      
    @SuppressWarnings("unused")
	private static List<String> getMonthBetween(String minDate, String maxDate) throws ParseException {
	      ArrayList<String> result = new ArrayList<String>();
	      SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");//格式化为年月
	  
	      Calendar min = Calendar.getInstance();
	      Calendar max = Calendar.getInstance();
	  
	      min.setTime(sdf.parse(minDate));
	      min.set(min.get(Calendar.YEAR), min.get(Calendar.MONTH), 1);
	  
	      max.setTime(sdf.parse(maxDate));
	      max.set(max.get(Calendar.YEAR), max.get(Calendar.MONTH), 2);
	  
	      Calendar curr = min;
	      while (curr.before(max)) {
	       result.add(sdf.format(curr.getTime()));
	       curr.add(Calendar.MONTH, 1);
	      }
	  
	      return result;
	    }
    /**
	  * 根据 年、月 获取对应的月份 的 天数
	  */
     public static int getDaysByYearMonth(int year, int month) {
 
         Calendar a = Calendar.getInstance();
         a.set(Calendar.YEAR, year);
         a.set(Calendar.MONTH, month - 1);
         a.set(Calendar.DATE, 1);
         a.roll(Calendar.DATE, -1);
         int maxDate = a.get(Calendar.DATE);
         return maxDate;
     }
      public static void main(String[] args) throws ParseException {  
       
    	  List<String> list=getMonthBetween("2017-02-05","2018-02-05");
    	  for (String string : list) {
			System.out.println(string);
		}
    	  
    	  System.out.println(getDaysByYearMonth(2018,2));
      }
    
}
