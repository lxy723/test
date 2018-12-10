import org.openqa.selenium.By;
        import org.openqa.selenium.Keys;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.WebElement;
        import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;


public class AssertDemo {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        //页面加载超时时间设置为5s
        driver.manage().timeouts().pageLoadTimeout(5,TimeUnit.SECONDS);
        driver.get("https://www.baidu.com");

        //定位对象时给10s的时间，如果10s内还定位不到则抛出异常
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        driver.findElement(By.id("kw")).sendKeys("selenium");

        //异步脚本的超时时间设置成3s
        driver.manage().timeouts().setScriptTimeout(3,TimeUnit.SECONDS);


//        WebDriverWait wait = new WebDriverWait(driver,10,1);
//        wait.until(new ExpectedCondition<WebElement>() {
//            @Override
//            public WebElement apply(WebDriver text){
//                return text.findElement(By.id("kw"));
//            }
//        }).sendKeys("selenium");
//
//        driver.findElement(By.id("su")).click();
//        Thread.sleep(2000);
//        driver.quit();
    }
}