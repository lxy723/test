import org.testng.Assert;
import org.testng.annotations.Test;

public class TestDemo {
    @Test
    public void testcase1(){
        Assert.assertTrue(false);
        System.out.println("testcase1");
    }
    @Test
    public void testcase2(){
        Assert.assertTrue(true);
        System.out.println("testcase2");
    }
}
