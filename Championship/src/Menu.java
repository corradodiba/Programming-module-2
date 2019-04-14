import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {


    public static void switchCase(char choice, ArrayList<Team> teams){
        try {
            switch (choice) {


                case '1':
                    teams.add(Menu.addTeam());
                break;

                case '2':
                    searchTeam(teams).addPlayer();
                break;

                case '3': printAllTeam(teams);
                break;

                case '4': searchPlayer(teams);
                break;

                case '5': teamBuilder(teams);
                break;

                case '0': System.exit(0);
                break;

                default: System.out.println("\n[***] An error has occurred try again");
                break;
            }
        }
        catch(NullPointerException nullException){
            System.out.println("[***] Error: you cannot enter a player, without first creating a team!");
        }
        catch (InputMismatchException inputException){
            System.out.println("[***] Error: you have entered an invalid type!");
        }
        catch (ArrayIndexOutOfBoundsException indexArrayException){
            System.out.println("[***] Error: you entered a wrong number");
        }
        catch (IndexOutOfBoundsException indexException){
            System.out.println("[***] Error: you entered a wrong number");
        }
    }


    private static Team addTeam(){

        Scanner input = scanIn();

        System.out.println("[***] New team creation: ");

        System.out.print("name ==> ");
        String name = input.nextLine();

        return (new Team(name));
    }
    
    private static void printAllTeam(ArrayList<Team> teams){

        if(teams.isEmpty()){
            System.out.println("\n[***] No team is present");
        }
        else {
            System.out.println("[***] I'm viewing all the teams");
            for (int i = 0; i < teams.size(); i++) {
                System.out.println((i + 1) + ". " + teams.get(i).toString());
            }
        }
    }


    public static Team searchTeam(ArrayList<Team> teams){

        Scanner input = scanIn();
        int found = -1;

        if (teams.isEmpty()) {
            System.out.println("[***] No team is present!");
        }
        else {
            printAllTeam(teams);
            System.out.print("Select a team ==> ");
            found = input.nextInt() - 1;
        }

        if(found == -1){
            return null;
        }
        else{
            return teams.get(found);
        }
    }

    public static void searchPlayer(ArrayList<Team> teams){

        Scanner input = scanIn();


        if(teams.isEmpty()){
            System.out.println("[***] No team is present");
        }
        else{
            System.out.println("[***] Find by: ");
            System.out.println("1. Surname");
            System.out.println("2. Role");
            char choice = input.next().charAt(0);
            if(choice == '1'){
                System.out.print("Enter the surname ==> ");
                String surname = input.next();
                System.out.print("Enter the name ==> ");
                String name = input.next();

                for(int i = 0; i < teams.size(); i++){
                    if(teams.get(i).findPlayerByName(surname, name) != 9999){
                        int idPlayerFound = teams.get(i).findPlayerByName(surname, name);
                        System.out.println("[***] Player found");
                        System.out.println("Team: " + teams.get(i).toString() + " ==> " + teams.get(i).getPlayers().get(idPlayerFound).toString());
                        break;
                    }
                    else if(i == (teams.size() - 1)){
                        System.out.println("[***] Player not found");
                    }
                }
            }
            else if(choice == '2'){

                printAllRoles();
                System.out.print("\nChoose a number ==> ");
                int idRole = input.nextInt() - 1;

                if(idRole == 4){
                    idRole--;
                }

                Team.role[] roles = Team.role.values();

                for(int i = 0; i < teams.size(); i++){
                    if(teams.get(i).findPlayerByRole(roles[idRole].toString()) != 9999){
                        int idPlayerFound = teams.get(i).findPlayerByRole(roles[idRole].toString());
                        System.out.println("[***] Player found");
                        System.out.println("Team: " + teams.get(i).toString() + " ==> " + teams.get(i).getPlayers().get(idPlayerFound).toString());
                        break;
                    }
                    else if(i == (teams.size() - 1)){
                        System.out.println("[***] Player not found");
                    }
                }
            }
            else{
                System.out.println("[***] Error: Invalid Option!");
            }

        }
    }

    private static void printAllRoles(){

        Scanner input = scanIn();
        Team.role[] roles = Team.role.values();

        System.out.println("\n[***] I'm visualizing the list of roles");
        for(int i = 0; i < roles.length; i++){
            System.out.println((i + 1) + " - " + roles[i]);
        }

    }

    private static void teamBuilder(ArrayList<Team> teams){

        teams.add(new Team("All Blacks"));
        teams.add(new Team("Springboks"));
        teams.add(new Team("Wallabies"));
        teams.add(new Team("London Broncos"));
        teams.add(new Team("Leicester"));

        teams.get(0).getPlayers().add(new Player("James","Allan", "null", 1, "loose_head_prop"));
        teams.get(0).getPlayers().add(new Player("Henry","Braddon", "null", 2, "hooker"));
        teams.get(0).getPlayers().add(new Player("George","Carter", "null", 3, "tight_head_prop"));
        teams.get(0).getPlayers().add(new Player("Jonh","Dumbell", "null", 4, "second_row"));
        teams.get(0).getPlayers().add(new Player("George","Helmore", "null", 5, "second_row"));

        System.out.println("[***] Operation completed successfully");
    }

    public static Scanner scanIn(){

        return (new Scanner(System.in));
    }

}
