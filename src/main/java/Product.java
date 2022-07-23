public class Product {
    int Id;
    String Name;
    float Price;

    public Product(int id, String name, float price) {
        Id = id;
        Name = name;
        Price = price;
    }

    public String getFullInfo() {
        return Id +" : "+ Name + ", Price = " + Price;
    }

}
