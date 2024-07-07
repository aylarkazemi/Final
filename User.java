import java.util.*;

public class User extends BaseInfo {
    private String phoneNumber;
    private String address;

    private Cart cart;
    private Wallet wallet;
    private List<Product> shoppingCart;
    private List<Order> orders;
    private List<Product> purchasedProducts;
    public User(String username , String password , String email ,
                    String phoneNumber, String address){
        super(username,password,email);
        this.phoneNumber=phoneNumber;
        this.address=address;
        this.shoppingCart=new ArrayList<>();
        this.orders=new ArrayList<>();
        this.purchasedProducts=new ArrayList<>();
        this.wallet=new Wallet();
        this.cart=new Cart();

    }
    public String getPhoneNumber(){
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber=phoneNumber;
    }
    public String getAddress(){
        return address;
    }
    public void setAddress(String address){
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
    public Wallet getWallet(){
        return wallet;
    }
    public Request createAddFundsRequest(double amount){
        return new Request(this,amount);
    }
    public Cart getCart(){
        return cart;
    }
    public void addOrder(Order order){
        orders.add(order);
        purchasedProducts.addAll(order.getProducts());
    }

    @Override
    public void displayAccountDetails(){
        System.out.println("Username : "+getUsername());
        System.out.println("Email : "+getEmail());
        System.out.println("Password : "+getPassword());
        System.out.println("Phone number : " +getPhoneNumber());
        System.out.println("Address : " + getAddress());
        System.out.println("Wallet Balance: $"+wallet);
        System.out.println("Cart: " + getCart());
        System.out.println("Orders: " + orders);
        System.out.println("Purchased Products: " + purchasedProducts);
    }

}