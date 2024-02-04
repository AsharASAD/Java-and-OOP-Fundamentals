//Ashar Asad
//Date:February,4,2024
//Description:To create a program that takes user input to calculate  the position
//of a projectile after a specific period of time


//import our scanner utility
import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // setting our constants
        double gravity = -9.87;


        //setting our variables to take value  prompted by user
        //Also validating the input entered by user, using  our new method at the end of program created for input
        double initialDegree = validateNumericInput("Enter the initial angle of the projectile in degrees: ");
        double velocity = validateNumericInput("Enter the initial velocity of the projectile in m/s: ");
        double time = validateNumericInput("Enter the instance of time in which the position of the projectile will be calculated: ");



        //Taking input entered and using it in a formula to get vertical answers using math functions
        double vertical_Answer = (velocity * Math.sin(Math.toRadians(initialDegree)) * time)
                - (0.5 * gravity * Math.pow(time, 2));
        //printing out results and adding round_decimal to round  output
        System.out.println("Your Vertical Distance travelled is  " + round_Decimal (vertical_Answer));

        //Taking input entered and using it in a formula to get horizontal answers using math functions
        double horizontal_Answer = velocity * Math.cos(Math.toRadians(initialDegree)) * time;
        //Printing out results
        System.out.println("Your Horizontal  Distance travelled is  " +  round_Decimal (horizontal_Answer));
    }


        //creating a validation method for inputs
    private static double validateNumericInput(String prompt) {
        //reading input from keyboard
        Scanner input = new Scanner(System.in);
        //using a while loop to loop back prompt if input is invalid
        while (true) {
            System.out.print(prompt);
                //Using try and catch for exceptions that may happen
            try {
                //Reads the input entered bys user and then converts it into a double
                return Double.parseDouble(input.next());
                //In the catch block if input is not a double we will prompt error message stored in e
            } catch (NumberFormatException e) {
                //error message
                System.out.println("Invalid input. Please enter a valid numeric entry.");
                //Gets rid of the invalid input
                input.nextLine(); // consume the invalid input to avoid an infinite loop
            }
        }
    }

    // create new method to round output to 2 decimals
    private  static String round_Decimal(double number){
        // using the variable round to store the DecimalFormat we wish to convert and output
        DecimalFormat round = new DecimalFormat("#.##");
        //Returning the number converted
        return round.format(number);
    }
}

