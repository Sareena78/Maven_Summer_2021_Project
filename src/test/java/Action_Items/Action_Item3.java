package Action_Items;

import Reusable_Classes.Reusable_Annotations_Class_Html_Report;
import Reusable_Classes.Reusable_Methods_With_Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.Test;

import java.util.List;

public class Action_Item3 extends Reusable_Annotations_Class_Html_Report {
    public static void main(String[] args) throws InterruptedException {

        //set property and path to your driver
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");

        //Use chrome options to set various properties of the driver.
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        //or driver.manage().window().maximize();
        options.addArguments("incognito");

        //Create a new webdriver object, Driver is the object, an object is an instance
        //CLass Object = new class() e.g. Car AqilasCar = new Car();
        //(basically what driver is being used for automation)
        WebDriver driver = new ChromeDriver(options);

        //define and declare the array
        String[] zipCodes;
        zipCodes = new String[3];
        zipCodes[0] = "11218";
        zipCodes[1] = "11219";
        zipCodes[2] = "11010";

        //List<WebElement> locationLinks = driver.findElements(By.xpath("//*[@class='linkUnderline-1_h4g']"));

        //loop through arrays
        for(int i = 0; i < zipCodes.length; i++){

            //navigate to bing search page
            driver.navigate().to("https://www.weightwatchers.com/us/find-a-workshop/");
            Thread.sleep(2000);

            //Click on Studio
            driver.findElement(By.xpath("//*[@class='studioIcon-2TdMR']")).click();
            Thread.sleep(2000);

            //use sendkeys method to enter the zip code in the search field and submit using the submit method
            //create a web element object for the search field
            WebElement searchField = driver.findElement(By.xpath("//*[@id='location-search']"));
            searchField.clear();
            searchField.sendKeys(zipCodes[i]);
            searchField.submit();
            Thread.sleep(2000);

            //depending on what i is/which zipCode is entered, click on the corresponding location link.
            //Ex. if the first zipcode is entered, and i is 0, click the first link
            //Ex. if the second zipcode is entered, and i is 1, click the second link
            if(i==0){
                driver.findElements(By.xpath("//*[@class='linkUnderline-1_h4g']")).get(i).click();
                //locationLinks.get(i).click();
            }else if(i==1){
                driver.findElements(By.xpath("//*[@class='linkUnderline-1_h4g']")).get(i).click();
                //locationLinks.get(i).click();
            }else{
                driver.findElements(By.xpath("//*[@class='linkUnderline-1_h4g']")).get(i).click();
                //locationLinks.get(i).click();
            }
            Thread.sleep(2000);

            //capture the location name
            String locationName = driver.findElement(By.xpath("//*[@class='locationName-1jro_']")).getText();
            System.out.println(locationName);
            Thread.sleep(2000);

            //capture the address text
            //String address = new String();
            String address = driver.findElement(By.xpath("//*[@class='address-2PZwW']")).getText();
            System.out.println(address);
            Thread.sleep(2000);

            //click on business hours button
            driver.findElement(By.xpath("//*[@class='title-3o8Pv']")).click();

            //capture the business hours
            String businessHours = driver.findElement(By.xpath("//*[@class='time-35INk']")).getText();
            System.out.println(businessHours);

            //Reusable_Methods_With_Logger.getText(driver, "", "", logger);
            Thread.sleep(2000);


        }//end of loop

        //quit the session
        driver.quit();

    }//end of main

}//end of class
