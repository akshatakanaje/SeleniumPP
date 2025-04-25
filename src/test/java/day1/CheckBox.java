package day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class CheckBox {

    public static void main(String[] args) {

        WebDriver driver =new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

        Assert.assertFalse(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
        driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).click();
        Assert.assertTrue(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());

        //Count the number od check boxes
        Assert.assertEquals(driver.findElements(By.cssSelector("input[type='checkbox']")).size(), 6);


        //another round check box
        System.out.println(driver.findElement(By.id("Div1")).getDomAttribute("style"));
        driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
        System.out.println(driver.findElement(By.id("Div1")).getDomAttribute("style"));

        if(driver.findElement(By.id("Div1")).getDomAttribute("style").contains("0.5")){
            System.out.println("Its enabled");
            Assert.assertTrue(true);
        } else {
            Assert.assertTrue(false);
        }

    }
}
