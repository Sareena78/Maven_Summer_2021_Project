package Day3;

public class Reusable_Methods {
    //create a void method for adding two integer values
    public static void addTwoNumbers(int num1, int num2){
        System.out.println("My result is " + (num1+num2));
    }//end of add two numbers method

    public static void subtractTwoNumber(int num1, int num2){
        System.out.println("My result is " + (num1-num2));
    }//end of add two numbers method

    //Create a return method that will add two numbers and also you can return the result of the
    //numbers
    public static int addTwoNumbersForReturn(int i, int i1) {
        int result = i + i1;
        System.out.println("My result is " + (result));
        return result;
    }//end of add two numbers
}//end of java class
