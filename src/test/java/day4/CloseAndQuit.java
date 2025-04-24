package day4;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
public class CloseAndQuit {

    public static void main(String[] args) {

        WebDriver driver = new FirefoxDriver();
        driver.get("http://www.hdfcbank.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//*[@id='loginsubmit']")).click();
        //driver.close();
        //Closes the browser which is currently focused
        driver.quit();
        //Closes all the browsers opened by driver
        //Destroys the driver object

    }
}
