import java.util.*;

public class Marketplace {
    ArrayList<User> users = new ArrayList<>();
    ArrayList<Product> products = new ArrayList<>();
    ArrayList<Purchase> purchases = new ArrayList<>();

    public Marketplace() {
        users.add(new User(1,"Petra","Petrov", 1000f));
        users.add(new User(2,"Sasha","Aleksandrov", 10f));
        users.add(new User(3,"Kola","Oval", 2000f));

        products.add(new Product(1,"Gasoline", 65.5f));
        products.add(new Product(2,"Salt", 25f));
        products.add(new Product(3,"Dollar", 36.56f));

    }

    public ArrayList<User> getAllUsers() {
        return users;
    }

    public ArrayList<Product> getAllProducts() {
        return products;
    }
    public String buyProduct(int userId, int prodId) {
        try {
            User user = users.stream().filter(x->x.Id == userId).findFirst().orElse(null);
            if (user == null) {
                return "UserId is not found";
            }
            Product product = products.stream().filter(x->x.Id == prodId).findFirst().orElse(null);
            if (product == null) {
                return "ProductId is not found";
            }
            if (user.Money < product.Price) {
                throw new Exception("Not enough money");
            }
            user.Money -= product.Price;
            purchases.add(new Purchase(user,product));

            return "User "+ user.getFullName() + " bought " + product.Name +" for "+product.Price + "\nUser's balance: "+ user.Money;
        } catch (Exception e) {
            return e.toString();
        }
    }

    public ArrayList<Product> getProductsByUserId(int userId) {
        ArrayList<Product> prods = new ArrayList<>();
        for (Purchase purchase: purchases) {
            if (purchase.Buyer.Id == userId)
            {
                prods.add(purchase.BoughtProduct);
            }
        }
        return prods;
    }

    public ArrayList<User> getUsersByProductId(int userId) {
        ArrayList<User> users = new ArrayList<>();
        for (Purchase purchase: purchases) {
            if (purchase.BoughtProduct.Id == userId)
            {
                users.add(purchase.Buyer);
            }
        }
        return users;
    }


}
