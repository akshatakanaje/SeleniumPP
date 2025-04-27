package day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class FunctionalTesting {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver=new ChromeDriver();

        //Implicit wait applies globally
        //driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        //explicit wait applies to specific element
        WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));

        String[] itemsNeeded= {"Cucumber","Brocolli","Beetroot"};
        driver.get("https://rahulshettyacademy.com/seleniumPractise/");
        addItems(driver,itemsNeeded);

        driver.findElement(By.cssSelector("img[alt='Cart']")).click();
        driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();

        driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");
        driver.findElement(By.cssSelector("button.promoBtn")).click();

        //explicit wait
        w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo")));
        System.out.println(driver.findElement(By.cssSelector("span.promoInfo")).getText());
    }



    public static  void addItems(WebDriver driver,String[] itemsNeeded) {

        int j=0;

        List<WebElement> products=driver.findElements(By.cssSelector("h4.product-name"));  //30 items are there

        for(int i=0;i<products.size();i++) {

            //the name which is present in website is like this Brocolli - 1 Kg
            //format it to get actual vegetable name
            String[] name=products.get(i).getText().split("-");
            String formattedName=name[0].trim();

             //convert array into array list for easy search
            List itemsNeededList = Arrays.asList(itemsNeeded);

            // check whether name you extracted is present in arrayList or not
            if(itemsNeededList.contains(formattedName)) {
                j++;

               //click on Add to cart
                driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
                if(j==itemsNeeded.length) {
                    break;

                }
            }

        }

    }

}
