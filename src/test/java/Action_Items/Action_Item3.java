package Action_Items;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Action_Item3 {
    public static void main(String[] args) {
        //define and declare the array
        int[] zipcodes;
        zipcodes = new int[3];
        zipcodes[0] = 11218;
        zipcodes[1] = 11219;
        zipcodes[2] = 11010;
        // start of loop
        for(int i = 0; i < zipcodes.length; i++){
        //set property and path to your driver
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
        //define your web driver (basically what driver is being used for automation)
        WebDriver driver = new ChromeDriver();
            //navigate to bing search page
            driver.navigate().to("https://www.weightwatchers.com/us/find-a-workshop/");
            //enter the zip code 11218
            driver.findElement(By.xpath("//*[@class=input input-3TfT5]"));
            //identify the search field
            driver.findElement(By.xpath("//*[@id=primary-link]")).submit();
        }//end of loop

    }//end of main

}//end of class
