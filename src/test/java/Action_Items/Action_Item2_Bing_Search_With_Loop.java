package Action_Items;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Action_Item2_Bing_Search_With_Loop {
    public static void main(String[] args) throws InterruptedException {
        String[] newsChannels = new String[3];
        newsChannels[0] = "CNN";
        newsChannels[1] = "FoxNews";
        newsChannels[2] = "ABCNews";

        //set property and path to your driver
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");

        //define your web driver (basically what driver is being used for automation)
        WebDriver driver = new ChromeDriver();

        for(int i = 0; i < newsChannels.length; i++){
        //(String newsChannel : newsChannels) {
            //  for(int i = 0; i < cities.length; i++){

            //navigate to bing search page
            driver.navigate().to("https://www.bing.com");

            //maximize the browser
            driver.manage().window().maximize();

            //put a few seconds wait
            Thread.sleep(3000);

            //identify the search field and enter a keyword "Fox News"
            driver.findElement(By.xpath("//*[@name='q']")) .sendKeys(newsChannels[i]);

            //hit submit on the search icon
            driver.findElement(By.xpath("//*[@name='search']")).submit();

            //every time you interact with new page you should put sleep statement
            Thread.sleep(2000);

            //capture the search result and only print out the number
            String result = driver.findElement(By.xpath("//*[@class='sb_count']")).getText();
            System.out.println("My full result is " + result);

            //extract out the number from the search result and print it using split
            String[] arrayResult = result.split(" ");
            System.out.println("My search number for NewsChannel " + newsChannels + " is " + arrayResult[1]);

        }//end of loop
        
        //System.out.println("my result is " + result);
        //quit my browser
        driver.quit();

    }//end of main method
}//end of java class
