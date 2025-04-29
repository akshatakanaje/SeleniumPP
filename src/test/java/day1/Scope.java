package day1;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

public class Scope {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver=new ChromeDriver();
        driver.get("http://qaclickacademy.com/practice.php");

        //Give me the count of links on the page.
        System.out.println(driver.findElements(By.tagName("a")).size());

        //Limiting webdriver scope to footer block
        WebElement footerdriver = driver.findElement(By.id("gf-BIG"));
        //Count of links present in the footer section
        System.out.println(footerdriver.findElements(By.tagName("a")).size());

        //Limiting webdriver scope to 1st column which is there in footer section
        WebElement coloumndriver = footerdriver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
        //Get the count of links present in 1st columns in the footer section
        int sizeOfLinks = coloumndriver.findElements(By.tagName("a")).size();
        System.out.println(sizeOfLinks);

        //click on each link in the coloumn and check if the pages are opening-
        for(int i=1;i<sizeOfLinks;i++) {

            //open the link in another tab
            String clickonlinkTab= Keys.chord(Keys.CONTROL,Keys.ENTER);
            coloumndriver.findElements(By.tagName("a")).get(i).sendKeys(clickonlinkTab);
            Thread.sleep(5000L);
        }
        // switch to every child windows and get the title
        Set<String> iterateToEveryWindow = driver.getWindowHandles();//4
        Iterator<String> it=iterateToEveryWindow.iterator();

        while(it.hasNext()) {
            driver.switchTo().window(it.next());
            System.out.println(driver.getTitle());
        }
    }
}
