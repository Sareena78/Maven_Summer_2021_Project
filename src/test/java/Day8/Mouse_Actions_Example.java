package Day8;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class Mouse_Actions_Example {
    public static void main(String[] args) throws InterruptedException {
        //set up webdriver manager to handle dynamic browser versions
        WebDriverManager.chromedriver().setup();
        //Chrome options
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("incognito");
        WebDriver driver = new ChromeDriver(options);

        //navigate to mortgage calculator site
        driver.navigate().to("https://www.usps.com");
        //few seconds to wait
        Thread.sleep(3000);

        //move to send tab using mouse Actions
        Actions mouseMove = new Actions(driver);
        WebElement sendTab = driver.findElement(By.xpath("//*[@id='mail-ship-width']"));
        mouseMove.moveToElement(sendTab).perform();
        //using actions to click on the schedule a pickup
        //Thread.sleep(1500);
        WebElement schedulePickup = driver.findElement(By.xpath("//a[text()='Schedule a Pickup']"));
        mouseMove.moveToElement(schedulePickup).click().perform();


    }//end of main
}//end of class
