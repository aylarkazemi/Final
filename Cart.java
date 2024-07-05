import java.util.*;
public class Cart {
    private Map<Product,Integer> products;
    public Cart(){
        this.products=new HashMap<>();
    }
    public void addProduct(Product product, int quantity){
        if (products.containsKey(product)){
            products.put(product,products.get(product)+quantity);
        }
        else {
            products.put(product,quantity);
        }
        System.out.println(quantity+" units of "+product.getName()+" added to cart.");
    }
    public void displayCartDetails(){
        System.out.println("Cart details : ");
        for (Map.Entry<Product,Integer> entry : products.entrySet()){
            Product product = entry.getKey();
            int quantity = entry.getValue();
            System.out.println("Product: "+product.getName()
            + ", Quantity : "+quantity);
        }
    }
}
