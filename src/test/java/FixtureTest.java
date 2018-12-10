import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FixtureTest {

    //在当前测试类开始时运行
    @BeforeClass
    public static void beforeClass(){
        System.out.println("----------beforeClass");
    }

    //在当前测试类结束时运行
    @AfterClass
    public static void afterClass(){
        System.out.println("----------afterClass");
    }

    //每个测试方法运行之前运行
    @BeforeMethod
    public void beforeMethod(){
        System.out.println("======beforeMethod");
    }

    //每个测试方法运行之后运行
    @AfterMethod
    public void afterMethod(){
        System.out.println("=====afterMethod");
    }

    @Test
    public void testCase1(){
        System.out.println("testcase 1");
    }

    @Test
    public void testCase2(){
        System.out.println("testcase 2");
    }
}
