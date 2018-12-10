import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.Set;


public class SelectDemo {
    public static void main(String args[]) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.qthmedia.com/");
        driver.manage().window().maximize();

        //登录钱塘号
       driver.findElement(By.id("qtLogin")).click();
       driver.findElement(By.className("user_account")).sendKeys("18860233258");
       driver.findElement(By.className("user_pwd")).sendKeys("123456");
       driver.findElement(By.className("form_submit")).click();
       Thread.sleep(2000);

       driver.findElement(By.xpath("//*[@id=\"papermain\"]/div[1]/div[2]/div/a[1]")).click();
       Thread.sleep(2000);

        //<select>标签的下拉框选择
        WebElement el = driver.findElement(By.xpath("//*[@id=\"select1\"]"));
        WebElement e2 = driver.findElement(By.xpath("//*[@id=\"select2\"]"));
        Select sel = new Select(el);
        Select se2 = new Select(e2);
        sel.selectByValue("1009");
        se2.selectByValue("2051");

        driver.findElement(By.xpath("/html/body/div/div[1]/ul[2]/div/li[2]/a")).click();
        driver.findElement(By.xpath("//*[@id=\"uploadBtn\"]")).sendKeys("D:\\lxy\\20170925\\视频.mp4");

        //获取cookie
        Set<Cookie> coo = driver.manage().getCookies();
        System.out.println(coo);


        Thread.sleep(2000);
//       driver.quit();
    }

}
