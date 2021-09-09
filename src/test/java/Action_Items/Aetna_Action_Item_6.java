package Action_Items;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Aetna_Action_Item_6 {
    public static void main(String[] args) {
        //define the webdriver
        WebDriverManager.chromedriver();









    }//end of main


}//end of class

//**when selecting a mile in Aetna website, it's a slider bar so I want you to google how to handle slider
// in selenium and java and once you figure it out you can use that slider concept in your code by creating
// a reusable method for it** watch the video

//Steps:
//1. go to aetna.com and verify the title is Health Insurance Plans | Aetna
//2. click on Sho for a plan
//3. click on Medicare
//4. on the suggestion click on Find a Doctor
//5. click on 2021 medicare plans you purchase yourself
//6. enter a zipcode //pass values from zipcode column here
//7. click on zipcode suggested on the dropdown menu
//8. now on the slider bar select a mile //this is what you have to research to figure it out then store
    // the miles on mile column and pass it on your method
//9. click on skip plan selection
//10. click on medial doctors & specialist
//11. click on all primary care physicians
//12. now capture the first result and send it back to excel doctorLocation column
//
//**put it in xml suite and send screenshot of the results and xml**
//you can either send the code in email and attach it as a notepad