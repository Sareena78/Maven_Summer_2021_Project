package Day9;

import Reusable_Classes.ReUsableMethods;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class Mcal_with_ReusableMethods {
    public static void main(String[] args) throws IOException, InterruptedException {
        WebDriver driver = ReUsableMethods.setDriver();


//navigate to mlcalc
        driver.navigate().to("https://www.mlcalc.com");
        Thread.sleep(2500);
//clear and enter a purchase price
        ReUsableMethods.sendKeysMethod(driver,"//*[@id='ma']","400000","Purchase Price");
//clear and enter down payment
        ReUsableMethods.sendKeysMethod(driver,"//*[@id='dp']","25","Down Payment");
    }
}
