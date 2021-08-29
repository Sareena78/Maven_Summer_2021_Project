package Day3;

public class Execution_Class {
    public static void main(String[] args) {
        //Process of calling static method to another class is known as inheritance
        //adding two numbers
        //Reusable_Methods Class1 = new Reusable_Methods(); practice with Azeem group study
        Reusable_Methods.addTwoNumbers(10,20);

        //subtracting two numbers

        Reusable_Methods.subtractTwoNumber(70,20);
        int result = Reusable_Methods.addTwoNumbersForReturn(14,20);
        System.out.println("New result is " + (result*2));
    }//end of main method
}//end of java class
