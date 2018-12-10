import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

public class MoreWindows {
    public static void main(String args[]) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.baidu.com");

        //获得当前窗口句柄
        String search_handle = driver.getWindowHandle();

        //打开百度注册窗口
        driver.findElement(By.linkText("登录")).click();
        Thread.sleep(3000);
        driver.findElement(By.linkText("立即注册")).click();

        //获得所有窗口句柄
        Set<String> handles = driver.getWindowHandles();

        //判断是否为注册窗口，并操作注册窗口上的元素
        for(String handle:handles){
            if(handle.equals(search_handle)==false){
                //切换到注册页面
                driver.switchTo().window(handle);
                System.out.println("now register window");
                Thread.sleep(2000);
                driver.findElement(By.name("userName")).clear();
                driver.findElement(By.name("userName")).sendKeys("user name");
                driver.findElement(By.name("phone")).clear();
                driver.findElement(By.name("phone")).sendKeys("phone number");
                Thread.sleep(2000);
                driver.close();
            }
        }
        Thread.sleep(2000);

//        driver.quit();
    }
}
