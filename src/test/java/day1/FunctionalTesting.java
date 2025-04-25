package day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Arrays;
import java.util.List;

public class FunctionalTesting {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver=new ChromeDriver();

        String[] itemsNeeded= {"Cucumber","Brocolli","Beetroot"};

        driver.get("https://rahulshettyacademy.com/seleniumPractise/");
        Thread.sleep(3000);

        addItems(driver,itemsNeeded);
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
