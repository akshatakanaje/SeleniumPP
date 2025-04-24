package day2;

import org.openqa.selenium.chrome.ChromeDriver;

public class WorkingWithChrome1 {

    ChromeDriver driver;

    public void invokeBrowser() {

        System.setProperty("webdriver.chrome.driver", "/Users/akshatakanaje/eclipse-workspace/libs/chromedriver");

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://www.w3schools.com/");

    }


    public void validateAndPrintTitle() {
        String expectedTitle = "QA Automation Tools Trainings and Tutorials | w3schools";
        String actualTitle = driver.getTitle();
        if (actualTitle.equals(expectedTitle)) {
            System.out.println("PASS - Title matches");
        } else {
            System.out.println("FAIL - Title does not match");
        }
    }


    public void navigateCommands() {

        driver.navigate().to("https://facebook.com");

        driver.navigate().back();
        String urlFromWebPage = driver.getCurrentUrl();
        System.out.println("Current URL after navigating back: " + urlFromWebPage);


        driver.navigate().forward();
        driver.navigate().refresh();
    }



    public void closeBrowser() {

        //Closes the current active window or tab
        //driver.close();

        //Closes all the windows opened during session
        driver.quit();
    }


    public static void main(String[] args) {

        WorkingWithChrome1 as = new  WorkingWithChrome1();
        as.invokeBrowser();
        as.validateAndPrintTitle();
        as.navigateCommands();
        as.closeBrowser();
    }

}
