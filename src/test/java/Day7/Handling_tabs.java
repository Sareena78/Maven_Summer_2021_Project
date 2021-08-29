package Day7;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;

public class Handling_tabs {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        //set the conditions for chromeoptions before the webdriver is defined
        ChromeOptions options = new ChromeOptions();
        //set arguments to maximize the driver and make it incognito
        options.addArguments("start-maximized");
        options.addArguments("incognito");
        //define the webdriver
        WebDriver driver = new ChromeDriver(options);

        driver.navigate().to("https://www.uhc.com");
        Thread.sleep(3000);

        //click on find a doctor
        driver.findElement(By.xpath("//*[text()='Find a doctor']")).click();
        Thread.sleep(1500);
        //click on start your search to open a new tab
        driver.findElement(By.xpath("//*[text()='Start your search']")).click();

        //switch to the new tab
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));

        //close the new tab
        driver.close();

        //switch back to default tab
        driver.switchTo().window(tabs.get(1));


    }//end of main
}//end of class
