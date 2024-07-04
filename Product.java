import java.util.ArrayList;
import java.util.List;
public class Product {
    private String name;
    private double price;
    private int quantityAvailable;
    private String additionalData;
    public Product(String name, double price, int quantityAvailable) {
        this.name = name;
        this.price = price;
        this.quantityAvailable = quantityAvailable;
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
    public String getAdditionalData() {
        return additionalData;}
    public void setAdditionalData(String additionalData) {
        this.additionalData = additionalData; }
    @Override
    public String toString() {
        return "Product: " + name + "\n" + "Price: " + price +
                "\n" + "Available Quantity: " + quantityAvailable; }
    }
