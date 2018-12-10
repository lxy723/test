package daily;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class QianTanHaoDemo {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("http://www.qthmedia.com/");
       WebElement search_text = driver.findElement(By.id("search_text"));
       WebElement seachBtn = driver.findElement(By.id("searchBtn"));
       search_text.sendKeys("test");
//       seachBtn.click();
       search_text.submit();
       Thread.sleep(2000);

        List<WebElement> search_result = driver.findElements(By.xpath("//*[@id=\"lf_width\"]/div/h3"));
        System.out.println(search_result.size());

        for(WebElement result : search_result){
            System.out.println(result.getText());
        }

        System.out.println("--------我是分割线----------");

        WebElement text = search_result.get(search_result.size()-1);
        System.out.println(text.getText());
        driver.quit();

//        WebDriver driver = new ChromeDriver();
//        //getURL
//        driver.get("http://www.qthmedia.com/");
//        //浏览器窗口最大化
//        driver.manage().window().maximize();
//
//        //鼠标悬停在钱塘号首页
//        WebElement qthIndex = driver.findElement(By.id("qthIndex"));
//        Actions action = new Actions(driver);
//        action.clickAndHold(qthIndex).perform();
//        action.contextClick(driver.findElement(By.id("qthIndex"))).perform();
//        action.doubleClick(driver.findElement(By.id("qthIndex"))).perform();
//
//        driver.findElement(By.className("down_list_a")).click();
//
//        //查找底部导航栏备案信息并打印
//        WebElement footer_code = driver.findElement(By.className("footer_code"));
//        System.out.println(footer_code.getText());
//
//        //备案信息对用户是否可见
//        System.out.println(footer_code.isDisplayed());
//
//        //查找搜索输入框并打印输入框大小及对用户是否可见
//        WebElement seach_text = driver.findElement(By.id("search_text"));
//        System.out.println(seach_text.getSize());
//        System.out.println(seach_text.isDisplayed());
//
//        //查找搜索按钮
//        WebElement searchBtn = driver.findElement(By.id("searchBtn"));
//
//        //输入框中传值
//        seach_text.sendKeys("test");
//        seach_text.clear();
//        seach_text.sendKeys("hello");
//        searchBtn.click();
//
//        driver.quit();
    }
}
