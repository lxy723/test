import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateDemo {
    public static void main(String args[]){
        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
        String input = args.length == 0 ? "1818-11-11" :args[0];
        System.out.print(input + " Parse as ");

        Date t;

        try{
            t = ft.parse(input);
            System.out.println(t);
        }catch (ParseException e){
            System.out.println("Unparseable using" + ft);
        }
    }

//    public static void main(String args[]){
//        Date date = new Date();
//        String str = String.format("Current Date/Time : %tc", date);
//        System.out.println((str));
//    }

//    public static void main(String args[]){
//        //初始化date对象
//        Date dNow = new Date();
//
//        SimpleDateFormat ft = new SimpleDateFormat("E yyy.MM.dd 'at' hh:mm:ss a zzz");
//        System.out.println("Current Date: "+ ft.format(dNow));
//
//        //使用toString（）函数显示日期时间
//        System.out.println(date.toString());
//    }
}
