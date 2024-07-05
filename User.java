import java.util.*;

public class User extends BaseInfo {
    private String phoneNumber;
    private String address;
    private List<Product> shoppingCart; //==سبدخرید
    private List<Order> orders;//==لیست سفارشات
    private List<Product> purchasedProducts;//==لیست محصولات خریداری شده
    private double wallet;//==کیف پول
    public User(String username , String password , String email ,
                    String phoneNumber, String address){
        super(username,password,email);
        this.phoneNumber=phoneNumber;
        this.address=address;
        this.shoppingCart=new ArrayList<>();
        this.orders=new ArrayList<>();
        this.purchasedProducts=new ArrayList<>();
        this.wallet=0.0;

    }
    public String getPhoneNumber(){
        return phoneNumber;
    }
    public void setPhoneNumber(){
        this.phoneNumber=phoneNumber;
    }
    public String getAddress(){
        return address;
    }
    public void setAddress(){
        this.address=address;
    }
    public List<Product> getShoppingCart(){
        return shoppingCart;
    }
    public void setShoppingCart(List<Product>shoppingCart){
        this.shoppingCart=shoppingCart;
    }
    public List<Order>getOrders(){
        return orders;
    }
    public void setOrders(List<Order> orders){
        this.orders=orders;
    }
    public List<Product> getPurchasedProducts(){
        return purchasedProducts;
    }
    public void setPurchasedProducts(List<Product> purchasedProducts){
        this.purchasedProducts=purchasedProducts;
    }
    public double getWallet(){
        return wallet;
    }
    public void setWallet(double wallet){
        this.wallet=wallet;
    }
    @Override
    public void displayAccountDetails(){
        System.out.println("Customer user Account : ");
        System.out.println("Username : "+getUsername());
        System.out.println("Email : "+getEmail());
        System.out.println("Phone number : " +getPhoneNumber());
        System.out.println("Address" + address);
        System.out.println("Wallet Balance: $"+wallet);
    }

}