package daily;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Daily {
    WebDriver driver;
    @BeforeMethod
    public void beforeMethod() throws InterruptedException {
        driver = new ChromeDriver();
        driver.get("http://www.qtbigdata.com/");
        driver.manage().window().maximize();
        Thread.sleep(2000);

        WebElement settings = driver.findElement(By.xpath("/html/body/header/div[1]/ul/li[3]/a"));
        Actions action = new Actions(driver);
        action.moveToElement(settings).perform();
        driver.findElement(By.linkText("旗下产品")).click();
    }

    //用例1，进入交易中心页面，用页面标题判断是否成功进入
    @Test
    public void qtjiaoyi() throws InterruptedException {
        WebElement qtjy = driver.findElement(By.xpath("/html/body/header/div[1]/ul/li[3]/p/a[1]"));
        qtjy.click();
        Thread.sleep(2000);
        driver.switchTo().window(driver.getWindowHandle());
        driver.navigate().refresh();
        System.out.println(driver.getCurrentUrl());

        Assert.assertEquals(driver.getTitle(),"钱塘大数据交易中心-工业大数据交易服务平台|API定制|爬虫市场|数据商城");

    }
    //用例2，进入钱塘号页面，用页面标题判断是否成功进入
    @Test
    public void  qth() throws InterruptedException {
        WebElement qth = driver.findElement(By.xpath("/html/body/header/div[1]/ul/li[3]/p/a[2]"));
        qth.click();
        Thread.sleep(2000);

        Assert.assertEquals(driver.getTitle(),"钱塘号—工业新媒体平台|自媒体|大数据|智能制造|物联网");
    }
    //用例3，进入钱塘百科页面，用页面标题判断是否成功进入
    @Test
    public void qtbk() throws InterruptedException {
        WebElement qtbk = driver.findElement(By.xpath("/html/body/header/div[1]/ul/li[3]/p/a[5]"));
        qtbk.click();
        Thread.sleep(2000);

        Assert.assertEquals(driver.getTitle(),"钱塘百科");
    }
    //用例4，进入企知页面，用页面标题判断是否成功进入
    @Test
    public void qizhi() throws InterruptedException {
        WebElement qizhi = driver.findElement(By.xpath("/html/body/header/div[1]/ul/li[3]/p/a[3]"));
        qizhi.click();
        Thread.sleep(2000);

        Assert.assertEquals(driver.getTitle(),"企知");
    }

    //关闭
    @AfterMethod
    public void close(){
        driver.close();
    }


}
