/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Mr.Thinh
 */
public class DateTimeHelper {
    
   public static Date toDate(String value, String format) throws ParseException {
        return new SimpleDateFormat(format).parse(value);
    }

    public static Date deleteTime(Date date) {
        Calendar cl = Calendar.getInstance();
        cl.setTime(date);
        cl.set(Calendar.HOUR_OF_DAY, 0);
        cl.set(Calendar.MINUTE, 0);
        cl.set(Calendar.SECOND, 0);
        cl.set(Calendar.MILLISECOND, 0);
        return cl.getTime();
    }

    public static java.util.Date toDateUtil(java.sql.Date d) {
        java.util.Date x = new java.util.Date(d.getTime());
        x = deleteTime(x);
        return x;
    }

    public static java.sql.Date toDateSql(java.util.Date d) {
        d = deleteTime(d);
        return new java.sql.Date(d.getTime());
    }

    public static int getDayofWeek(java.util.Date d) {
        Calendar c = Calendar.getInstance();
        c.setTime(d);
        int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
        return dayOfWeek;
    }
    
    public static Date addDays(java.util.Date d, int days){
        Calendar cal = Calendar.getInstance(); 
        cal.setTime(d);
        cal.add(Calendar.DATE, days);
        return cal.getTime();
    }
    
    public static ArrayList<java.sql.Date> getDateList(java.sql.Date from, java.sql.Date to){
        ArrayList<java.sql.Date> dates = new ArrayList<>();
        int days = 0;
        java.util.Date e_from = toDateUtil(from);
        java.util.Date e_to = toDateUtil(to);
        while(true)
        {
            java.util.Date d = DateTimeHelper.addDays(e_from, days);
            dates.add(toDateSql(d));
            days++;
            if(d.compareTo(e_to)>=0)
                break;
        }
        return dates;
    }
    
    public static String getDayNameofWeek(java.sql.Date s) {
        java.util.Date d = toDateUtil(s);
        Calendar c = Calendar.getInstance();
        c.setTime(d);
        int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
        switch(dayOfWeek){
            case 1: return "SUN";
            case 2: return "MON";
            case 3: return "TUE";
            case 4: return "WED";
            case 5: return "THU";
            case 6: return "FRI";
            case 7: return "SAT";
        }
        return "ERROR";
    }
    
    public static int compare(java.sql.Date a, java.sql.Date b){
        Date e_a = toDateUtil(a);
        Date e_b = toDateUtil(b);
        System.out.println(a + " " + b +" " +e_a.compareTo(e_b));
        return e_a.compareTo(e_b);
    }
}