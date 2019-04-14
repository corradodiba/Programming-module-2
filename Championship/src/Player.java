public class Player extends Person {

    private int shirtNumber;
    private String role;

    public Player(String name, String surname, String taxCode, int shirtNumber, String role) {
        super(name, surname, taxCode);
        this.shirtNumber = shirtNumber;
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    @Override
    public String toString() {
        return "Player: " + super.toString() + ", " + role + "( " + shirtNumber + " )";
    }
}
