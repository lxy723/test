package daily;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ZCB {
    @Test
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        //get到智车宝首页
        driver.get("http://zcb.qtjiaoyi.com");
        Assert.assertEquals(driver.getTitle(),"智车宝 | 首页");


        //点击精准营销-查看详情
        driver.findElement(By.className("scheme_details")).click();

        //最大化浏览器
        driver.manage().window().maximize();

        //执行浏览器后退
        driver.navigate().back();
        Thread.sleep(2000);

        //执行浏览器前进
        driver.navigate().forward();
        Thread.sleep(2000);

        //刷新页面
        driver.navigate().refresh();

        driver.findElement(By.linkText("我们的客户")).click();

    }
}
