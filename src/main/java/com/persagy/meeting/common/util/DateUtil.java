package com.persagy.meeting.common.util;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.Date;

/** 
 * 功能描述： 日期工具类
 * @类型名称 DateUtil
 * @创建者 wanghailong
 * @邮箱 wanghailong@persagy.com  
 * @修改描述 
 */
public class DateUtil {
    private final static DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
    /**
     * 东八区时区偏移量
     */
    private final static int ASIA_SHANGHAI = 8;
    public static final String sdfDay = "yyyyMMdd";
    public static final String sdfMonth = "yyyyMM";
    public static final String sdfTime = "yyyyMMddHHmmss";
    public static final String sdfHour = "yyyyMMddHH";
    public static final String sdfMinute = "yyyyMMddHHmm";
    //时间格式-显示
    public final static String date_format_show = "yyyy-MM-dd HH:mm:ss";

    /**
     * LocalDate类型转为Date
     *
     * @param localDate LocalDate object
     * @return Date object
     */
    public static Date localDate2Date(LocalDate localDate) {

        ZonedDateTime zonedDateTime = localDate.atStartOfDay(ZoneId.systemDefault());
        return Date.from(zonedDateTime.toInstant());
    }

    /**
     * LocalDateTime类型转为Date
     * @param localDateTime LocalDateTime object
     * @return Date object
     */
    public static Date localDateTime2Date(LocalDateTime localDateTime) {
        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }

    /**
     *
     * Description: Date转换为LocalDateTime
     * @param date
     * @return LocalDateTime
     * @author kangjun
     * @since 2019年8月5日: 下午5:25:27
     */
    public static LocalDateTime date2LocalDateTime(Date date) {
        return LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
    }


    //获取指定日期的毫秒
    public static Long getMilliByLocalDateTime(LocalDateTime time) {
        return time.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
    }

    //获取指定日期的秒
    public static Long getSecondsByLocalDateTime(LocalDateTime time) {
        return time.atZone(ZoneId.systemDefault()).toInstant().getEpochSecond();
    }

    /**
     * 格式化LocalDateTime为指定格式 字符串
     * @param pattern 格式
     * @return 日期字符串
     */
    public static String format(LocalDateTime time,String pattern) {
        return time.format(DateTimeFormatter.ofPattern(pattern));
    }
    public static String format(LocalDateTime time,DateTimeFormatter pattern) {
        return time.format(pattern);
    }
    public static String format(LocalDateTime time) {
        return time.format(FORMATTER);
    }

    /**
     * 解析字符串日期为Date
     *
     * @param dateStr 日期字符串
     * @param pattern 格式
     * @return Date
     */
    public static LocalDateTime parse(String dateStr, String pattern) {
        return LocalDateTime.parse(dateStr, DateTimeFormatter.ofPattern(pattern));
    }
    public static LocalDateTime parse(String dateStr, DateTimeFormatter pattern) {
        return LocalDateTime.parse(dateStr, pattern);
    }
    public static LocalDateTime parse(String dateStr) {
        return LocalDateTime.parse(dateStr, FORMATTER);
    }

    //获取当前时间的指定格式
    public static String formatNow(String pattern) {
        return  format(LocalDateTime.now(), pattern);
    }

    //日期加上一个数,根据field不同加不同值,field为ChronoUnit.*
    public static LocalDateTime plus(LocalDateTime time, long number, TemporalUnit field) {
        return time.plus(number, field);
    }

    //日期减去一个数,根据field不同减不同值,field参数为ChronoUnit.*
    public static LocalDateTime minus(LocalDateTime time, long number, TemporalUnit field){
        return time.minus(number,field);
    }

    /**
     * 获取两个日期的差  field参数为ChronoUnit.*
     * 默认累加的方式
     * 重要说明： 计算月份差 计算的是否满月，年份同理，
     * 区别1：Period只考虑到日期，ChronoUnit.between()计算到具体时分秒
     * 区别2：Period只计算月份差，不考虑年份是否一样，ChronoUnit.between()计算考虑年份
     * :Period只考虑到日期，field.between(startTime, endTime)会计算到具体时间
     * 					period.getMonths();		field.between
     * 比如：6月6号8点到8月6号7点： 		2				1
     * 比如：6月6号8点到8月6号9点： 		2				2
     * 比如：6月5号到8月6号： 				2				2
     * 比如：6月7号到8月6号： 				1				1
     *
     * @param startTime
     * @param endTime
     * @param field  单位(年月日时分秒)
     * @return
     */
    public static long betweenTwoTime(LocalDateTime startTime, LocalDateTime endTime, ChronoUnit field) {

//        Period period = Period.between(LocalDate.from(startTime), LocalDate.from(endTime));
//    	startTime : 1993-10-19
//    	endTime : 2019-08-06
//    	年龄 : 25 年 9 月 18 日
//        period.getYears();	period.getMonths();			period.getDays();
//         25 年							9 月					18 日
//        field.between(startTime, endTime);
//        25 年 					 25*12+9           	 		（ 25*12+9）个月+18 日

        return field.between(startTime, endTime);
    }


    /**
     * Description:获得当前时间的字符串.
     * @return String 当前时间的字符串格式.格式是yyyyMMddHHmmss
     * @author lijie
     */
    public static String getNowTimeStr() {
        return LocalDateTime.now().format(FORMATTER);
    }

    public static String getTimeStr(LocalDateTime date) {
        return date.format(FORMATTER);
    }

    public static String getMinusHour(String dateTime,long hour) {
        LocalDateTime parse = parse(dateTime).minusHours(hour);
        return format(parse);
    }
    public static String getPlusHour(String dateTime,long hour) {
        LocalDateTime parse = parse(dateTime).plusHours(hour);
        return format(parse);
    }
    public static String getPlusHourNow(long hour) {
        LocalDateTime parse =LocalDateTime.now().plusHours(hour);
        return format(parse);
    }
    /**
     * 获取年
     *
     * @return 年
     */
    public static int getYear(LocalDateTime ldt) {
        return ldt.getYear();
    }
    /**
     * 获取月份
     */
    public static int getMonth(LocalDateTime ldt) {
        return ldt.getMonthValue();
    }
    /**
     * 获取月份差
     * 不算满月的月份差（比如7月31号到8月1号仍然算一个月份差）
     */
    public static int getBetweenMonth(LocalDateTime startLdt,LocalDateTime endLdt) {
        int minusMonth = (endLdt.getYear()-startLdt.getYear())*12-endLdt.getMonthValue()-startLdt.getMonthValue();
        return minusMonth;
    }
    /**
     * 获取月份最大天数
     */
    public static int getDaylengthOfMonth() {
        LocalDateTime localTime = LocalDateTime.now();
        return localTime.toLocalDate().lengthOfMonth();
    }
    /**
     * 获取年份最大天数
     */
    public static int getDaylengthOfYear() {
        LocalDateTime localTime = LocalDateTime.now();
        return localTime.toLocalDate().lengthOfYear();
    }
    /**
     * Description: 日期格式转换
     * @param srcDateStr 源日期字符串
     * @param srcDatePattern  源日期字符串格式
     * @param destDatePattern 目标日期字符串格式
     * @return String
     * @author kangjun
     * @since 2019年10月9日: 下午2:29:23
     */
    public static String transferDateFormat(String srcDateStr, String srcDatePattern, String destDatePattern) {
        DateTimeFormatter srcFommater = DateTimeFormatter.ofPattern(srcDatePattern);
        DateTimeFormatter destFommater = DateTimeFormatter.ofPattern(destDatePattern);
        return LocalDateTime.parse(srcDateStr, srcFommater).format(destFommater);
    }

    private static void test1() {
        String aString = "{	\"id\": \"11\",\r\n" +
                "			    \"nodes\": [\r\n" +
                "			              {\r\n" +
                "			                  \"name\": \"1\",\r\n" +
                "			                  \"time\": \"2019-10-30\",\r\n" +
                "			                  \"time_key\": \"T015\"\r\n" +
                "			              },\r\n" +
                "			              {\r\n" +
                "			                  \"name\": \"2\",\r\n" +
                "			                  \"time\": \"2019-10-30\",\r\n" +
                "			                  \"time_key\": \"T015\"\r\n" +
                "			              },\r\n" +
                "			              {\r\n" +
                "			                  \"name\": \"3\",\r\n" +
                "			                  \"time\": \"2019-10-30\",\r\n" +
                "			                  \"time_key\": \"T015\"\r\n" +
                "			              }\r\n" +
                "			          ]\r\n" +
                "			      }";

        JSONObject aa = JSONObject.parseObject(aString);
        JSONArray nodes = aa.getJSONArray("nodes");
        for (int i = 0; i < nodes.size(); i++) {
            // 处理结点信息
            JSONObject node = nodes.getJSONObject(i);
            if (node.getString("name").equals("1")) {
                node.put("time", i);
            }
        }
        System.out.println(nodes);
    }
}
