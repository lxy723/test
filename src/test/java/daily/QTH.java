package daily;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class QTH {
    WebDriver driver;
    @BeforeMethod
    public void beforeQTH() throws InterruptedException {
        driver = new ChromeDriver();
        driver.get("http://www.qtjiaoyi.com");
        driver.manage().window().maximize();
        Thread.sleep(2000);
    }


    //用例1：正确用户名、密码，登录成功，title为验证方式
    @Test
    public void testcase1() throws InterruptedException {
        WebElement loginbtn = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/span[2]/a[2]"));
        loginbtn.click();
        Thread.sleep(2000);
        WebElement user = driver.findElement(By.className("user_account"));
        WebElement pwd = driver.findElement(By.className("user_pwd"));
        WebElement loginSubmit = driver.findElement(By.id("loginSubmit"));
        user.sendKeys("18860233258");
        pwd.sendKeys("123456");
        loginSubmit.click();
        Thread.sleep(2000);

        driver.switchTo().window(driver.getWindowHandle());
        Assert.assertEquals(driver.getTitle(),"钱塘大数据交易中心-工业大数据交易服务平台|API定制|爬虫市场|数据商城");

        driver.close();
    }
    //用例2：错误密码，登录失败，title为验证方式
    @Test
    public void testcase2() throws InterruptedException {
        WebElement loginbtn = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/span[2]/a[2]"));
        loginbtn.click();
        Thread.sleep(2000);
        WebElement user = driver.findElement(By.className("user_account"));
        WebElement pwd = driver.findElement(By.className("user_pwd"));
        WebElement loginSubmit = driver.findElement(By.id("loginSubmit"));
        user.sendKeys("18860233258");
        pwd.sendKeys("1234569");
        loginSubmit.click();
        Thread.sleep(2000);

        driver.switchTo().window(driver.getWindowHandle());
        Assert.assertEquals(driver.getTitle(),"登录");

        driver.close();
    }

    //用例3：密码用户名都为空，登录失败，title为验证方式
    @Test
    public void testcase3() throws InterruptedException {
        WebElement loginbtn = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/span[2]/a[2]"));
        loginbtn.click();
        Thread.sleep(2000);
        WebElement loginSubmit = driver.findElement(By.id("loginSubmit"));
        loginSubmit.click();
        Thread.sleep(2000);

        driver.switchTo().window(driver.getWindowHandle());
        Assert.assertEquals(driver.getTitle(),"登录");

        driver.close();
    }
}
