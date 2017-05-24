import java.util.Date;

import static sun.misc.Version.println;

/**
 * Created by asus on 2017/5/24.
 */
public class TestTime {
    public static  void main(String[] args)
    {
        Date Date = new Date();
        //System.out.print(System.currentTimeMillis());//毫秒数
        long i = 1495642386;//System.currentTimeMillis()/1000;//目前秒数
        long j = 2592000;// 一个月的总秒数
        //long j = 23;
        long h = i+j;
        long now = System.currentTimeMillis()/1000;//目前秒数
        if(now<h)
        {
            System.out.println("小了");
        }else{
            System.out.print("大了");
        }




    }

}
