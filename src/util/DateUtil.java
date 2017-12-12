package util;

import java.util.Calendar;
import java.util.Date;

public class DateUtil {
    static long millisecondsofoneday = 1000*60*60*24;

    /**
     * 通过日期控件获得的日期和数据库中的日期类型不一样。
     * @param d
     * @return
     */
    public static java.sql.Date util2sql(java.util.Date d){
        return new java.sql.Date(d.getTime());
    }

    /**
     * 得到当天日期
     * @return
     */
    public static Date today(){
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
       // Date d = c.getTime();
        c.set(Calendar.HOUR, 0);
        c.set(Calendar.SECOND, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.MILLISECOND, 0);
        return c.getTime();

    }

    /**
     * 返回月初第一天
     * @return
     */
    public static Date monthBegin(){
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.set(Calendar.DATE, 1);
        c.set(Calendar.HOUR, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        c.set(Calendar.MILLISECOND, 0);
        return c.getTime();
    }

    /**
     * 返回月末
     * @return
     */
    public static Date monthEnd(){
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.set(Calendar.DATE, 1);
        c.add(Calendar.MONTH, 1);
        c.add(Calendar.DATE, -1);

        c.set(Calendar.HOUR, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        c.set(Calendar.MILLISECOND, 0);
        return c.getTime();
    }

    /**
     * 得到一个月有多少天
     * @return
     */
    public static int thisMonthTotalDay(){
        //Date日期返回的是毫秒
        long lastMillisecond = monthEnd().getTime();
        long beginMillisecond = monthBegin().getTime();

        return (int)((lastMillisecond - beginMillisecond) / millisecondsofoneday + 1);
    }

    /**
     * 这个月还剩的天数
     * @return
     */
    public static  int thisMonthLeftDay(){
        long lastMillisecond = monthEnd().getTime();
        long todayMillisecond = today().getTime();

        return (int)((lastMillisecond - todayMillisecond) / millisecondsofoneday + 1);
    }

    public static void main(String[] args) {
        System.out.println(DateUtil.today());
        System.out.println(DateUtil.thisMonthTotalDay());
        System.out.println(DateUtil.thisMonthLeftDay());
    }

}
