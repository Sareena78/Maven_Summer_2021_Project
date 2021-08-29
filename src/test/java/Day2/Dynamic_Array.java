package Day2;

public class Dynamic_Array {
    public static void main(String[] args) {
        //Declaring Arrays
        String[] countries;
        countries = new String[6];
        countries[0] = "pakistan";
        countries[1] = "Bangladesh";
        countries[2] = "China";
        countries[3] = "Russia";
        countries[4] = "Turkey";
        countries[5] = "Kashmir";

        int[] zipCodes;
        zipCodes = new int[6];
        zipCodes[0] = 11218;
        zipCodes[1] = 11219;
        zipCodes[2] = 11220;
        zipCodes[3] = 11221;
        zipCodes[4] = 11222;
        zipCodes[5] = 11226;

        //process of concatenation(combining)
        System.out.println("My country is " + countries[0] + " My zipcode is " + zipCodes[0]);
        System.out.println("My country is " + countries[1] + " My zipcode is " + zipCodes[1]);
        System.out.println("My country is " + countries[2] + " My zipcode is " + zipCodes[2]);
        System.out.println("My country is " + countries[3] + " My zipcode is " + zipCodes[3]);
        System.out.println("My country is " + countries[4] + " My zipcode is " + zipCodes[4]);
        System.out.println("My country is " + countries[5] + " My zipcode is " + zipCodes[5]);
        System.out.println("The zipCodes Array has " +zipCodes.length+ " indexes, and The Countries Array has " +countries.length+ " indexes") ;
        System.out.println("The countries Array has " + countries.length + " indexes");

    }//end of main method
}//end of class
