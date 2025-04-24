package day3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TryingLoginWithBrowser {

    ChromeDriver driver;   //invoke the browser

    String url = "https://www.facebook.com/";

    public void invokeBrowser() {

        System.setProperty("webdriver.chrome.driver", "/Users/akshatakanaje/eclipse-workspace/libs/chromedriver");

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get(url);
    }


    public void login(String username, String password) {

        //What's your e-mail?
        WebElement usernameElement = driver.findElement(By.name("email"));

        usernameElement.sendKeys(username);


        //password
        driver.findElement(By.name("pass")).sendKeys(password);


        //login button
        driver.findElement(By.name("login")).click();
    }


    public static void main(String[] args) {
        TryingLoginWithBrowser tr = new TryingLoginWithBrowser();
        tr.invokeBrowser();
        tr.login("abcd@gmail.com", "jFXlzZz@123");
    }

}
