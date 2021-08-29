package Day3;

public class Loop_with_Conditional_Statement {
    public static void main(String[] args) {
        //define an Array list, iterate through each array value but print only when the
        //city is brooklyn or queens
        String[] cities = new String[4];
        cities[0] = "Brooklyn";
        cities[1] = "Queens";
        cities[2] = "Manhattan";
        cities[3] = "Staten Island";

        //using for loop to iterate through cities and only print when its Brooklyn or Queens
        for (int i = 0; i < cities.length; i++){
            if(cities[i] == "Brooklyn"){
                System.out.println("My city is" + cities[i]);
            } else if (cities[i] == "Queens"){
                System.out.println("My city is" + cities[i]);
            }//end of conditions
        }//end of loop
    }//end of main method
}//end of java class
