package utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Alex on 30.03.2017.
 */
public class StringHelper {
    public String getCurrentTime(){
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();

        System.out.println(dateFormat.format(date)); //2016/11/16 12:08:43
        return dateFormat.format(date);
    }
}
