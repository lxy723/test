import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class JSDemo {
    public static void main(String args[]) throws InterruptedException {
        WebDriver driver = new ChromeDriver();

        //设置浏览器窗口大小
        driver.manage().window().setSize(new Dimension(700,600));
        driver.get("http://www.qthmedia.com");

        driver.findElement(By.id("search_text")).sendKeys("test");
        driver.findElement(By.id("searchBtn")).click();
        Thread.sleep(2000);

        //将页面滚动条拖到底部
        ((JavascriptExecutor)driver).executeScript("window.scrollTo(100,450);");
        Thread.sleep(3000);
    }
}