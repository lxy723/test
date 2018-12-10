import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexMatches {

    private static String REGEX = "a*b";
    private static String INPUT = "aabfooaabfooabfoob";
    private static String REPLACE = "-";
    public static void main(String args[]){
        Pattern p = Pattern.compile(REGEX);
        Matcher m = p.matcher(INPUT);
        StringBuffer sb = new StringBuffer();
        while (m.find()){
            m.appendReplacement(sb,REPLACE);
        }
        m.appendTail(sb);
        System.out.println(sb.toString());
    }

//    private static String REGEX = "dog";
//    private static String INPUT = "The dog says meow. "+ "All dogs say meow";
//    private static String REPLACE = "cat";
//
//    public static void main(String argsp[]){
//        Pattern p = Pattern.compile(REGEX);
//        Matcher m = p.matcher(INPUT);
//        INPUT = m.replaceAll(REPLACE);
//        System.out.println(INPUT);
//    }

//    private static final String REGEX = "foo";
//    private static final String INPUT = "foooooooooo";
//    private static Pattern pattern;
//    private static Matcher matcher;
//
//    public static void main(String args[]){
//        pattern = Pattern.compile(REGEX);
//        matcher = pattern.matcher(INPUT);
//
//        System.out.println("Current REGEX is: "+REGEX);
//        System.out.println("Current INPUT is: "+INPUT);
//
//        System.out.println("lookingAt(): "+matcher.lookingAt());
//        System.out.println("matches(): "+matcher.matches());
//
//
//    }

//    private static final String REGEX = "\\bcat\\b";
//    private static final String INPUT = "cat cat cat cattie cat";
//
//    public static void main(String args[]){
//        Pattern p = Pattern.compile(REGEX);
//        Matcher m = p.matcher(INPUT);
//        int count = 0;
//        while (m.find()){
//            count++;
//            System.out.println("Match number " + count);
//            System.out.println("start(): " + m.start());
//            System.out.println("end(): " + m.end());
//        }
//    }

//    public static void main(String args[]){
//        //按指定模式在字符串查找
//        String line = "This order was placed for QT3000! OK?";
//        String pattern = "(.*)(\\d+)(.*)";
//
//        //创建pattern对象
//        Pattern r = Pattern.compile(pattern);
//
//        //创建matcher对象
//        Matcher m = r.matcher(line);
//        if (m.find()){
//            System.out.println("Found value: " + m.group(0));
//            System.out.println("Found value: " + m.group(1));
//            System.out.println("Found value: " + m.group(2));
//        }else {
//            System.out.println("NO MATCH");
//        }
//    }
}
