public class User {
    int Id;
    String Name;
    String LastName;
    float Money;

    public User(int id, String name, String lastName, float money) {
        Id = id;
        Name = name;
        LastName = lastName;
        Money = money;
    }
    public String getFullName() {
        return Name + " " + LastName;
    }
    public String getFullInfo() {
        return Id +" : "+ Name + " " + LastName + ", balance = " + Money;
    }

    public int getUserId() {
        return Id;
    }

}
