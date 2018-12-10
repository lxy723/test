import java.util.Scanner;

public class ScannerDemo {

    public static void main(String args[]){
        Scanner scan = new Scanner(System.in);
        double sum = 0;
        int m = 0;

        while (scan.hasNextDouble()){
            double x = scan.nextDouble();
            m = m + 1;
            sum = sum + x;
        }
        System.out.println((m+"个数的和为"+sum));
        System.out.println(m+"个数的平均值"+(sum/m));

    }

//    public static void main(String args[]){
//        Scanner scan = new Scanner(System.in);
//        int i = 0;
//        float f = 0.0f;
//        System.out.print("输入整数：");
//        if (scan.hasNextInt()){
//            i = scan.nextInt();
//            System.out.println("整数数据：" + i);
//        }else {
//            System.out.println("输入的不是整数！");
//        }
//
//        System.out.print("输入小数：");
//        if (scan.hasNextFloat()){
//            f = scan.nextFloat();
//            System.out.println("小数数据：" + f);
//        }else {
//            System.out.println("输入的不是小数！");
//        }
//    }

//    public static void main(String args[]){
//        Scanner scan = new Scanner(System.in);
//        System.out.println("next方式接收：");
//        if(scan.hasNext()){
//            String str1 = scan.next();
//            System.out.println("输入的数据为： "+str1);
//        }
//    }
}
