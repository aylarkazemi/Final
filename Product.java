import java.util.*;
public class Product {
    private String name;
    private double price;
    private int quantityAvailable;
    private List<String> reviews;
    private Category category;
    private Map<String,String> additionalData;

    public Product(String name, double price, int quantityAvailable , Category category) {
        this.name = name;
        this.price = price;
        this.quantityAvailable = quantityAvailable;
        this.reviews=new ArrayList<>();
        this.category=category;
        this.additionalData=new HashMap<>();
    }
    public String getName() {
        return name;}
    public void setName(String name) {
        this.name = name; }
    public double getPrice() {
        return price; }
    public void setPrice(double price) {
        this.price = price; }
    public int getQuantityAvailable() {
        return quantityAvailable; }
    public void setQuantityAvailable(int quantityAvailable) {
        this.quantityAvailable = quantityAvailable;
    }
    public List<String> getReviews(){
        return reviews;
    }
    public void addReviews(String review){
        this.reviews.add(review);
    }
    public Category getCategory(){
        return category;
    }
    public void setCategory(Category category){
        this.category=category;
    }
    public Map<String,String> getAdditionalData(){
        return additionalData;
    }
    public void addAdditionalData(String key , String value){
        this.additionalData.put(key,value);
    }
    public void displayProductDetails(){
    System.out.println("Product Name : "+name);
    System.out.println("Price : $"+price);
    System.out.println("Available amount : "+quantityAvailable);
    System.out.println("Category : "+category.getName());
    System.out.println("Reviews : ");
    for(String review : reviews){
        System.out.println("-"+review);
        }
    }
    public boolean addToCart(int quantity , Cart cart){
        if (quantity<= quantityAvailable){
            cart.addProduct(this,quantity);
            quantityAvailable-=quantity;
            return true;
        }
        else {
            System.out.println("Not enough stock for product: "+name);
            return false;
        }
    }
}
