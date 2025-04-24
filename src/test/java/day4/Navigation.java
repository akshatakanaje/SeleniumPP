package day4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Navigation {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new FirefoxDriver();

        //1st method
        driver.get("https://www.rediff.com/");
        driver.manage().window().maximize();

        //2nd method
        driver.navigate().to("https://www.rediff.com/");
        driver.manage().window().maximize();

        driver.findElement(By.xpath("//*[@id='signin_info']/a[1]")).click();

        Thread.sleep(5000);

        driver.navigate().back();
        Thread.sleep(5000);

        driver.navigate().forward();
        Thread.sleep(5000);

        driver.navigate().refresh();


    }
}
