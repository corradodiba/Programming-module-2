import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = Menu.scanIn();
        char choice = '0';

        ArrayList teams = new ArrayList<Team>();


        do {
            System.out.println("\n*************** Menu ***************");
            System.out.println("1. Create a new team");
            System.out.println("2. Create a new player");
            System.out.println("3. View team information");
            System.out.println("4. Find player by last name or role");
            System.out.println("9. Automatic team builder");

            System.out.print("\nYour choice ==> ");
            choice = input.next().charAt(0);;

            Menu.switchCase(choice, teams);
        }
        while(choice != '0');


    }
}
