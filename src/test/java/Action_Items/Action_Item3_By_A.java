package Action_Items;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Action_Item3_By_A {
    public static void main(String[] args) throws InterruptedException {

        String locationName, address, schedule;

        String[] zipCodes = new String[3];
        zipCodes[0] = "11354";
        zipCodes[1] = "32004";
        zipCodes[2] = "90001";

        //Set up web driver and create a new instance of the driver.
        WebDriverManager.chromedriver().setup();

        //Use chrome options to set various properties of the driver.
        ChromeOptions options = new ChromeOptions();

        options.addArguments("start-maximized");
        options.addArguments("incognito");

        //Create a new instance of the driver.
        WebDriver driver = new ChromeDriver(options);

        JavascriptExecutor jse = (JavascriptExecutor) driver;

        //Loop through the zipCodes array and display their corresponding addresses and schedules.
        for (int i = 0; i < zipCodes.length; i++) {

            //Navigate to https://www.weightwatchers.com/us/find-a-workshop
            driver.navigate().to("https://www.weightwatchers.com/us/find-a-workshop");
            Thread.sleep(3000);

            //Click the studio button.
            driver.findElement(By.xpath("//*[@class='studioIcon-2TdMR']")).click();

            //Declare and assign a web element for the search field.
            WebElement searchField = driver.findElement(By.xpath("//*[@id='location-search']"));

            //Enter zip code into the search field and submit.
            searchField.clear();
            searchField.sendKeys(zipCodes[i]);
            searchField.submit();
            Thread.sleep(3000);

            switch (zipCodes[i]) {
                case "11354":
                case "32004":
                case "90001":

                    //Click location link corresponding to the iteration of the loop (1st iteration will click the 1st link, 2nd iteration 2nd link).
                    driver.findElements(By.xpath("//*[@class='linkUnderline-1_h4g']")).get(i).click();
                    Thread.sleep(2000);

                    //Assign location name text to location variable.
                    locationName = driver.findElement(By.xpath("//*[@class='locationName-1jro_']")).getText();

                    //Assign address text to address variable.
                    address = driver.findElement(By.xpath("//*[@class='address-2PZwW']")).getText();

                    //Split address string to separate the actual address from other text.
                    String[] addressArray = address.split("Studio reopened");

                    //Print location and address.
                    System.out.println("The " + locationName + " location is at " + addressArray[0].trim());

                    //Scroll towards the bottom to be able to view the schedule.
                    jse.executeScript("scroll(0, 950)");
                    Thread.sleep(2000);

                    //Assign all the text from studio work shop schedule to a string variable.
                    schedule = driver.findElement(By.xpath("//*[@id='studioWorkshopSchedule']")).getText();

                    //Split schedule string to separate actual schedule from other text.
                    String[] scheduleText = schedule.split("Reserve your Studio spot");

                    //Print the schedule for corresponding location.
                    System.out.println(scheduleText[1].trim());
                    System.out.println(" ");

                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + zipCodes[i]);
            }//end of switch case
        }//end of loop

        driver.quit();

    }//end of main
}//end of class

