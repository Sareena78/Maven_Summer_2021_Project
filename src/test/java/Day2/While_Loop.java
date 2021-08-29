package Day2;

public class While_Loop {
    public static void main(String[] args) {

        //Declaring Arrays
        String[] countries;
        countries = new String[5];
        countries[0] = "pakistan";
        countries[1] = "Bangladesh";
        countries[2] = "China";
        countries[3] = "Russia";
        countries[4] = "Turkey";

        int[] zipCodes;
        zipCodes = new int[5];
        zipCodes[0] = 11218;
        zipCodes[1] = 11219;
        zipCodes[2] = 11220;
        zipCodes[3] = 11221;
        zipCodes[4] = 11222;
        /*
        for(int i = 0;i< countries.length;i++){
            System.out.println("My country is " + countries[i] + " My zipcode is " + zipCodes[i]);

        }
        */
        //Declaration of Counter (Set the initializer first)
        int i = 0;
        //call the while loop and define the end point
        while (i < countries.length) {
            System.out.println("My country is " + countries[i] + " My zipcode is " + zipCodes[i]);
            //incrementation;
            i++;
        }

    }//end of main method
}//End of class
