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


    public void login() throws InterruptedException {
        //email
        driver.findElement(By.id("username")).sendKeys("John.Matthew@gmail.com");
        driver.findElement(By.id("password")).sendKeys("John@123");

        //driver.findElement(By.xpath("//a[@id='forgot-passwordId']")).click();

        driver.findElement(By.className("mat-select-placeholder mat-select-min-line ng-tns-c161-3 ng-star-inserted")).click();
        Thread.sleep(2000);
        driver.findElement(By.className("mat-option-text")).click();
        
    }

    public static void main(String[] args) throws InterruptedException {
        TestLoginPage testLoginPage = new TestLoginPage();
        testLoginPage.invokeBrowser();
        testLoginPage.login();
    }
}
