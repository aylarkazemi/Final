import java.util.*;
public class Cart {
    private List<CartItem> items;
    public Cart(){
        this.items=new ArrayList<>();
    }
    public void addItem(Product product, int quantity){
        items.add(new CartItem(product, quantity));
    }
    public void addItem(CartItem item) {
        items.add(item);
    }
    public List<CartItem> getItems(){
        return items;
    }
    public double getTotalPrice(){
        double total=0;
        for (CartItem item :items){
            total+=item.getProduct().getPrice()*item.getQuantity();
        }
        return total;
    }
    public void clear(){
        items.clear();
    }
    @Override
    public String toString(){
        return "Cart{item="+items+"}";
    }

}
