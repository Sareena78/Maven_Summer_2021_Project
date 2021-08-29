package Action_Items;

public class Action_Item_1_For_Automation {
    public static void main(String[] args) {

        //Set up variables for Dynamic Array

        int[] zipCodes;
        zipCodes = new int[5];
        zipCodes[0] = 66666;
        zipCodes[1] = 22222;
        zipCodes[2] = 33333;
        zipCodes[3] = 44444;
        zipCodes[4] = 77777;

        int[] streetNumber;
        streetNumber = new int[5];
        streetNumber[0] = 36;
        streetNumber[1] = 48;
        streetNumber[2] = 50;
        streetNumber[3] = 62;
        streetNumber[4] = 76;

        /*int i = 0;
        //call the while loop and define the end point
        while (i < streetNumber.length) {
            System.out.println("My street number is " + streetNumber[i] + " My zipcode is " + zipCodes[i]);
            //incrementation;
            i++;
        }

         */
        //I commented the while loop above and tried for loop instead
        for(int i = 0;i< zipCodes.length;i++){
            System.out.println("My street number is " + streetNumber[i] + " My zipcode is " + zipCodes[i]);
        }

    }//end of main method
}//end of java class
