package day2;

import java.awt.Dimension;
import org.openqa.selenium.chrome.ChromeDriver;

public class WorkingWithChrome {

    ChromeDriver driver;

    public void invokeBrowser() {

        //System.setProperty("webdriver.chrome.driver", "/Users/akshatakanaje/eclipse-workspace/libs/chromedriver");
       // System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\libs\\chromedriver");

        driver = new ChromeDriver();


        //Maximize the browser's screen
        driver.manage().window().maximize();

        Dimension dim = new Dimension(1024, 680);

        //driver.manage().window().setSize(dim);

        //Bypass all the existing cookies
        driver.manage().deleteAllCookies();

        driver.get("https://www.numpyninja.com/");


    }

    public void navigateCommands() {

        driver.navigate().to("https://facebook.com");

        driver.navigate().back();

        driver.navigate().forward();

        driver.navigate().refresh();
    }

    public void printTitleofThePage() {
        String title = driver.getTitle();

        System.out.println("The title of the page - "+ title);
    }

    public void closeBrowser() {

        //Closes the current active window or tab
        //driver.close();

        //Closes all the windows opened during session
        driver.quit();
    }

    public static void main(String[] args) {
        WorkingWithChrome wc = new WorkingWithChrome();
        wc.invokeBrowser();
        wc.navigateCommands();
        wc.printTitleofThePage();
        wc.closeBrowser();
    }
}
