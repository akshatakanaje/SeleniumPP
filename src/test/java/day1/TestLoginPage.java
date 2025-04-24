package day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestLoginPage {

    ChromeDriver driver;   //invoke the browser
    String url = "https://lms-frontend-devenv-f977e452a111.herokuapp.com/login";

    public void invokeBrowser() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);
    }


    public void login() {
        //email
        driver.findElement(By.id("username")).sendKeys("");
        driver.findElement(By.id("password")).sendKeys("");

        driver.findElement(By.xpath("//a[@id='forgot-passwordId']")).click();
        
    }

    public static void main(String[] args) {
        TestLoginPage testLoginPage = new TestLoginPage();
        testLoginPage.invokeBrowser();
        testLoginPage.login();
    }
}
