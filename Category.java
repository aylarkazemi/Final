import java.util.*;
public class Category {
    private String name;
    private List<Product> products;
    public Category(String name){
        this.name=name;
        this.products=new ArrayList<>();
    }
    public String getName(){
        return name;
    }
    public List<Product> getProducts(){
        return products;
    }
    public void addProduct(Product product){
        this.products.add(product);
    }
    public void displayCategoryDetails(){
        System.out.println("Category : "+name);
        System.out.println("Products: ");
        for (Product product : products){
            System.out.println(" - "+product.getName());
        }
    }
    @Override
    public String toString() {
        return name;
    }

}