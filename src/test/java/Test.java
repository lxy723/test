public class Test {
    public static void main(String args[]){
        int max = 0;
        int x = 3 ;
        int y = 10;
        max = x > y?x:y;
        System.out.println("最大值为" + max);
    }

//    public static void main(String args[]){
//        int [] numbers = {10,20,30,40,50};
//        for (int x : numbers){
//            if(x == 30){
//                continue;
//            }
//        System.out.print(x);
//        System.out.print("\n");
//        }
//    }

//    public static void main(String args[]){
//        int [] numbers = {10, 20, 30, 40, 50};
//
//        for(int x : numbers ){
//            System.out.print( x );
//            System.out.print(",");
//        }
//        System.out.print("\n");
//        String [] names ={"James", "Larry", "Tom", "Lacy"};
//        for( String name : names ) {
//            System.out.print( name );
//            System.out.print(",");
//        }
//    }

//    public static void main(String args[]){
//        for(int x = 10;x < 20; x++){
//            System.out.println("value of x:"+x);
//        }
//    }

//    public static void main(String args[]){
//        int x = 10;
//        do {
//            System.out.println("value of x:"+x);
//            x++;
//        }while (x<20);
//    }

//    public static void main(String args[]){
//        int x = 10;
//        while (x <= 20){
//            System.out.println("value of x :"+x);
//            x++;
//            System.out.print("\n");
//        }
//    }

//    public static void main(String args[]) {
//        int a = 10;
//        int b = 20;
//        int c = 25;
//        int d = 25;
//        System.out.println("a + b = " + (a + b) );
//        System.out.println("a - b = " + (a - b) );
//        System.out.println("a * b = " + (a * b) );
//        System.out.println("b / a = " + (b / a) );
//        System.out.println("b % a = " + (b % a) );
//        System.out.println("c % a = " + (c % a) );
//        System.out.println("a++   = " +  (a++) );
//        System.out.println("a--   = " +  (a--) );
//        // 查看  d++ 与 ++d 的不同
//        System.out.println("d++   = " +  (d++) );
//        System.out.println("++d   = " +  (++d) );
//    }
}