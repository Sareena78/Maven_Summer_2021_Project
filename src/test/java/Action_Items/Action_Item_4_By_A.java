package Action_Items;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;

public class Action_Item_4_By_A {

    public class ActionItem_4 {

        public static void main(String[] args) throws InterruptedException {

            //set up driver
            WebDriverManager.chromedriver().setup();

            ChromeOptions options = new ChromeOptions();
            options.addArguments("start-maximized");
            //options.addArguments("incognito");

            WebDriver driver = new ChromeDriver(options);

            JavascriptExecutor jse = (JavascriptExecutor) driver;
            //------------------------------------------

            //Declare and define array lists.
            ArrayList<String> firstNames = new ArrayList<>();
            firstNames.add("Max");
            firstNames.add("Tony");
            firstNames.add("Jon");

            ArrayList<String> lastNames = new ArrayList<>();
            lastNames.add("Holloway");
            lastNames.add("Ferguson");
            lastNames.add("Jones");

            ArrayList<String> dobs = new ArrayList<>();
            dobs.add("04251997");
            dobs.add("10061966");
            dobs.add("07181976");

            ArrayList<String> zipCodes = new ArrayList<>();
            zipCodes.add("11354");
            zipCodes.add("10011");
            zipCodes.add("11125");

            ArrayList<String> idNums = new ArrayList<>();
            idNums.add("1234567");
            idNums.add("7654321");
            idNums.add("9876543");

            //Declare string variable for error message
            String errorMessage;

            for (int i = 0; i < firstNames.size(); i++) {
                //Navigate
                driver.navigate().to("https://www.uhc.com/");
                Thread.sleep(3000);

                //Click the Find a doctor button
                try {
                    System.out.println("Clicking the Find a doctor button");
                    WebElement findADoc = driver.findElement(By.xpath("//*[contains(@aria-label,'Find a doctor')]"));
                    findADoc.click();
                    Thread.sleep(5000);
                } catch (Exception err) {
                    System.out.println("Unable to click the Find a doctor button " + err);
                }

                //Close popup if there is one
                try {
                    System.out.println("Cosing popup");
                    driver.findElement(By.xpath("//*[@id='ip-close']")).click();
                } catch (Exception err) {
                    System.out.println("Unable to close popup or there wasn't one " + err);
                }

                jse.executeScript("scroll(0, 500)");
                Thread.sleep(1000);

                //Click the Select your plan to sign in button
                try {
                    System.out.println("Clicking the Select your plan to sign in button");
                    WebElement selectPlan = driver.findElement(By.xpath("//*[contains(@aria-labelledby,'Select your plan to sign in')]"));
                    selectPlan.click();
                    Thread.sleep(1000);
                } catch (Exception err) {
                    System.out.println("Unable to click the Select your plan to sign in button " + err);
                }

                //Click the Medicare plan link
                try {
                    System.out.println("Clicking the Medicare plan link");
                    WebElement mediCareLink = driver.findElement(By.xpath("//*[contains(@aria-label,'Medicare plan Opens a new window')]"));
                    mediCareLink.click();
                    Thread.sleep(1000);
                } catch (Exception err) {
                    System.out.println("Unable to click the Medicare plan link " + err);
                }

                ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
                driver.switchTo().window(tabs.get(1));
                Thread.sleep(3000);

                //Click the Register Now button
                try {
                    System.out.println("Clicking the Register Now button");
                    WebElement registerNow = driver.findElement(By.xpath("//button[contains(text(),'Register Now')]"));
                    registerNow.click();
                    Thread.sleep(3000);
                } catch (Exception err) {
                    System.out.println("Unable to click the Register Now button " + err);
                }

                //Enter first name
                try {
                    System.out.println("Entering first name");
                    WebElement firstNameField = driver.findElement(By.xpath("//*[@name='firstname']"));
                    firstNameField.sendKeys(firstNames.get(i));
                    //Thread.sleep(1000);
                } catch (Exception err) {
                    System.out.println("Unable to enter first name " + err);
                }

                //Enter last name
                try {
                    System.out.println("Entering last name");
                    WebElement lastNameField = driver.findElement(By.xpath("//*[@name='lastname']"));
                    lastNameField.sendKeys(lastNames.get(i));
                    //Thread.sleep(1000);
                } catch (Exception err) {
                    System.out.println("Unable to enter last name " + err);
                }

                //Enter dob
                try {
                    System.out.println("Entering dob");
                    WebElement dobField = driver.findElement(By.xpath("//*[@name='dob']"));
                    dobField.sendKeys(dobs.get(i));
                    //Thread.sleep(1000);
                } catch (Exception err) {
                    System.out.println("Unable to enter dob " + err);
                }

                //Enter zip code
                try {
                    System.out.println("Entering zip code");
                    WebElement zipCodeField = driver.findElement(By.xpath("//*[@name='zip']"));
                    zipCodeField.sendKeys(zipCodes.get(i));
                    //Thread.sleep(1000);
                } catch (Exception err) {
                    System.out.println("Unable to enter zip code " + err);
                }

                //Enter member id
                try {
                    System.out.println("Entering member id");
                    WebElement memberIdField = driver.findElement(By.xpath("//*[@name='memberId']"));
                    memberIdField.sendKeys(idNums.get(i));
                    Thread.sleep(1000);
                } catch (Exception err) {
                    System.out.println("Unable to enter member id " + err);
                }

                //Clicking continue
                try {
                    System.out.println("Clicking continue");
                    WebElement continueButton = driver.findElement(By.xpath("//*[@id='step1Btn']"));
                    continueButton.click();
                    Thread.sleep(3000);
                } catch (Exception err) {
                    System.out.println("Unable to click continue " + err);
                }

                //Capture error message
                try {
                    System.out.println("Capturing error message");
                    errorMessage = driver.findElement(By.xpath("//*[@id='pageErrors']")).getText();
                    System.out.println(errorMessage);
                } catch (Exception err) {
                    System.out.println("Unable to capture error message " + err);
                }

                driver.close();
                driver.switchTo().window(tabs.get(0));

            }//end of loop

            driver.quit();

        }//end of main
    }//end of class

}
