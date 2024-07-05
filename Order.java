import java.util.*;
public class Order {
    private int orderId;
    private User user;
    private List<Product> products;
    private double totalAmount;
    private Date orderDate;
    private boolean isConfirmed;
    public double getTotalPrice(){
        double totalPrice=0.0;
        for (Product product : products){
            totalPrice+=product.getPrice();
        }
        return totalPrice;
    }
    public Order(int orderId, User user) {
        this.orderId = orderId;
        this.user = user;
        this.products = new ArrayList<>();
        this.totalAmount = 0.0;
        this.orderDate = new Date();
        this.isConfirmed = false; }
    public void addProduct(Product product, int quantity) {
        if (quantity > 0 && product.getQuantityAvailable() >= quantity) {
            for (int i = 0; i < quantity; i++) {
                products.add(product); }
            totalAmount += product.getPrice() * quantity;
            System.out.println(quantity + " " + product.getName() +
                    "(s) added to your cart."); }
        else {
            System.out.println("Failed to add " + product.getName() +
                    " to your cart. Insufficient stock.");
        } }
    public void removeProduct(Product product, int quantity) {
        int count = 0;
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).equals(product)) {
                products.remove(i); count++;
                if (count == quantity) break; }
        }
        totalAmount -= product.getPrice() * quantity;
        System.out.println(quantity + " " + product.getName() +
                "(s) removed from your cart."); }
    public void displayOrderDetails() {
        System.out.println("Order ID: " + orderId);
        System.out.println("Order Date: " + orderDate);
        System.out.println("User: " + user.getUsername());
        System.out.println("Products in Order:");
        for (Product product : products) {
            System.out.println("- " + product.getName() + " - Price: " +
                    product.getPrice()); }
        System.out.println("Total Amount: " + totalAmount);
        System.out.println("Order Status: " + (isConfirmed ? "Confirmed" : "Not Confirmed"));
    }
    public void confirmOrder() {
        if (!products.isEmpty()) {
            isConfirmed = true;
            System.out.println("Order confirmed successfully."); }
        else {
            System.out.println("Failed to confirm order. Your cart is empty.");
        }
    }
    public double getTotalAmount() {
        return totalAmount;
    }
    public boolean isConfirmed() {
        return isConfirmed; }
    }

