package My_Practice;

import Reusable_Classes.ReUsableMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.io.IOException;

public class My_Practice {
    public static void main(String[] args) {
        //Class name = x;
        //object name = driver
        //so this is how we will create a new object in a class,
        //Once an object in webdriver class is created we will implement methods on that object.
        //x driver = new x();
        try {

            WebDriver driver = ReUsableMethods.setDriver();
            driver.navigate().to("https://www.google.com/");
            //add wait item
            Thread.sleep(15);
            String getTitle = driver.getTitle();
            //get title and url as well to Validate if you are landed on the correct url and not a mimicked or hacked one.
            System.out.println(" The title of page is " + getTitle + " and The Url is " + driver.getCurrentUrl());

            driver.quit();
        } catch (Exception err) {
            System.out.println("Unable to run google page" + err);
        }
        try {
            //set driver
            WebDriver driver = ReUsableMethods.setDriver();
            //navigate to facebook
            driver.navigate().to("https://www.facebook.com/");
            //add wait time to slow down page execution
            Thread.sleep(15);
            //enter user-name
            driver.findElement(By.id("email")).sendKeys("qilajameel@yahoo.com");
            Thread.sleep(15);
            //enter password
            driver.findElement(By.xpath("//*[@type='password']")).sendKeys("987_987");

            Thread.sleep(15);
            //click on login
            driver.findElement(By.xpath("//*[@name='login']")).click();

            //get the text of error message.
            String errorMessage = driver.findElement(By.xpath("//*[@class='_9ay7']")).getText();
            System.out.println(errorMessage);
            
        /*/find locator for forgot password and click on it
        driver.findElement(By.linkText("Forgot Password?")).click();
        Thread.sleep(15);*/
            //Catch the error and print it if above command does not work, e stands for error
        } catch (IOException | InterruptedException e) {
            System.out.println(" THe error is " + e);

        }
    }//end of main method
}//end of class


