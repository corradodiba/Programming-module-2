import java.util.ArrayList;
import java.util.Scanner;

public class Team {

    private String name;
    ArrayList <Player> players;

    public enum role{
        loose_head_prop, hooker, tight_head_prop, second_row, empty, blind_side_flanker, open_side_flanker, number_8,
        scrum_half, fly_half, left_wing, inside_center, outside_center, right_wing, full_back;  //in order from 1 to 15, empty is second_row(2)
    }

    public Team(String name) {
        this.name = name;
        this.players = new ArrayList<Player>();
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public void addPlayer(){

        Scanner input = Menu.scanIn();
        Team.role[] roles = Team.role.values();

        if(players.size() > 22){
            System.out.println("[***] the team is full, you cannot add other players");
        }
        else{
            System.out.println("\n[***] Inserting a player");
            System.out.print("name ==> ");
            String name = input.next();
            System.out.print("surname ==> ");
            String surname = input.next();
            System.out.print("taxCode ==> ");
            String taxCode = input.next();
            System.out.print("Shirt Number(1/22) ==> ");  // also identifies the role

            int shirtNumber = input.nextInt();
            int roleNumber = shirtNumber;
            if(shirtNumber == 5){
                roleNumber--;
            }

            String role = String.valueOf(roles[roleNumber - 1]);
            players.add(new Player(name, surname, taxCode, shirtNumber, role));
        }
    }

    public int findPlayerByName(String surnamePlayer, String namePlayer) {
        int found = 9999;

        for (int i = 0; i < players.size(); i++) {
            if((players.get(i).getSurname().equals(surnamePlayer)) && (players.get(i).getName().equals(namePlayer))){
               found = i;
            }
        }
        return found;
    }

    public int findPlayerByRole(String role){
        int found = 9999;

        for (int i = 0; i < players.size(); i++) {

            if(players.get(i).getRole().equals(role)){
                found = i;
            }
        }
        return found;
    }

    @Override
    public String toString() {
        return name + "Players: " + players;
    }

}
