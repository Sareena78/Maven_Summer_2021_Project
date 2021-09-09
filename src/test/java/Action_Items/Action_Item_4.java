package Action_Items;

import Reusable_Classes.ReUsableMethods;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.IDataProviderAnnotation;

import javax.swing.text.html.Option;
import java.util.ArrayList;

public class Action_Item_4 {
    public static void main(String[] args) throws InterruptedException {
        //set property for driver
        //System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");

        //Path to driver changes since we have already added the dependency
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("incognito");

        //Create a driver object which is an instance of the WebDriver class and give it access to options.
        // Options become properties of the driver.
        WebDriver driver = new ChromeDriver(options);

        //creating an object called "jse" which is an instance of the JavascriptExecutor class.
        //converting the driver object into a JavascriptExecutor object and storing it in "jse"
        //the same way we converted the decimal number into an int and stored it in an int.
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        /*
        double decimalNum = 10.5;
        int wholeNum = (int)decimalNum;
        System.out.println(wholeNum);//wholeNum = 10
         */

        //define and declare the array list.
        ArrayList<String> firstNames = new ArrayList<>();
        firstNames.add("Aqila");
        firstNames.add("Nahida");
        firstNames.add("Azeem");

        ArrayList<String> lastNames = new ArrayList<>();
        lastNames.add("Jameel");
        lastNames.add("Rahim");
        lastNames.add("Alam");

        ArrayList<String> dob = new ArrayList<>();
        dob.add("01121900");
        dob.add("02121900");
        dob.add("03121900");

        ArrayList<String> zipcodes = new ArrayList<>();
        zipcodes.add("11218");
        zipcodes.add("11219");
        zipcodes.add("11220");

        ArrayList<String> id = new ArrayList<>();
        id.add("0000000");
        id.add("1111111");
        id.add("2222222");

        for (int i=0;i < 1;i++){//id.size() = 3 bc there are 3 things in the id list.
            //navigate to uhc.com
            driver.navigate().to("https://www.uhc.com/");
            Thread.sleep(2000);
            //click on find a doctor

            try {
                //intention: trying to click on the find a doctor button
                System.out.println("Clicking on the find a doctor button");
                WebElement findADocButton = driver.findElement(By.xpath("//*[@aria-label='Find a doctor']"));
                findADocButton.click();
                //will lead to a new page so sleep
                Thread.sleep(2500);
            }catch(Exception err){
                //catch executes if try fails.
                //without the try and catch if a block of code fails to exexcute, the entire script will stop.
                //try and catch allows you to try a block of code and if it fails, instead of the script stopping, the catch kicks in and script continues.
                System.out.println("Unable to click on the find a doctor button " + err);
            }

            //close popup if there is one
            try {
                //
                System.out.println("Close pop up");
                WebElement popUpButton = driver.findElement(By.xpath("//*[@id='ip-close']"));
                popUpButton.click();
            }catch (Exception err){
                //If there is no pop up
                System.out.println("There is no pop up");
            }

            //scroll down
            try {
                System.out.println("Scrolling down");
                jse.executeScript("scroll(0,500)");
            }catch(Exception err){
                System.out.println("Unable to scroll");
            }

            //click on drop down
            ReUsableMethods.clickMethod(driver,"//*[contains(@aria-labelledby,'Select your plan to sign in')]","drop down");

            //click on medicare
            ReUsableMethods.clickMethod(driver,"//*[@aria-label='Medicare plan Opens a new window']","medicare link");

            //switch to the new tab since we have multiple tabs open.
            //creating a list of open tabs at the moment
            ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
            //this command will select the tab based on the index. if 2 open tabs index 1 switches to the 2nd tab.
            driver.switchTo().window(tabs.get(1));
           /* //if a third tab opens up, need to modify the list to include all current open tabs. new call of getWindowHandles().
            tabs = new ArrayList<>(driver.getWindowHandles());
            driver.switchTo().window(tabs.get(2));

            //close the current (third tab)
            driver.close();
            //can go back to the second tab without needing to create a new list of tabs.
            driver.switchTo().window(tabs.get(1));
            //*/

            //click on register now
            //the * in an xpath makes your script ignore the tag that element is in. if 2 elements have the same xpath locators, but are in different tags
            //you can differentiate between them by putting the tag name instead of ignoring it with a *
            ReUsableMethods.clickMethod(driver,"//button[contains(text(),'Register Now')]","");

            //enter first name
            ReUsableMethods.sendKeysMethod(driver,"//*[@name='firstname']",firstNames.get(i),"first name");
            //enter last name
            ReUsableMethods.sendKeysMethod(driver,"//*[@name='lastname']",lastNames.get(i),"last name");
            //enter date of birth mm/dd/yyyy format(enter date of birth greater than 18 yrs of age)
            ReUsableMethods.sendKeysMethod(driver,"//*[@name='dob']",dob.get(i),"Date of Birth");
            //enter valid zip code
            ReUsableMethods.sendKeysMethod(driver,"//*[@name='zip']",zipcodes.get(i),"Zip Codes");

            //enter invalid plan id(numbers only)
            ReUsableMethods.sendKeysMethod(driver,"//*[@name='memberId']",id.get(i),"member id");
            //click on continue
            ReUsableMethods.clickMethod(driver,"//*[@id='step1Btn']","Continue button");

            //Capture the error message and print it out
            String actualErrorMessage = ReUsableMethods.getText(driver,"//*[@id='pageErrors']","Error message");

            System.out.println(actualErrorMessage);


        }//end of loop

    }//end of main
}//end of class

//navigate to uhc.com
//click on find a doctor
//wait 5 seconds and verify if a popup appears then click on the pop up to close it (use try catch as well to click on close element for pop up)
//choose Medicaid plan from the sign in dropdown(see if you can use select command. If not then click on dropdown then click on value by text)
//switch to the new tab
//click on register now
//enter first name
//enter last name
//enter date of birth mm/dd/yyyy format(enter date of birth greater than 18 yrs of age)
//enter valid zip code
//enter invalid plan id(numbers only)
//click on continue
//Capture the error message and print it out
