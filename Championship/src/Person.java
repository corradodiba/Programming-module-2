public class Person {

    private String name;
    private String surname;
    private String taxCode;

    public Person(String name, String surname, String taxCode) {
        this.name = name;
        this.surname = surname;
        this.taxCode = taxCode;
    }

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return surname + " " + name;
    }
}
