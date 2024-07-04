import java.util.*;
public class Shop {
    public String name;
    public String website;
    public String supportNumber;
    private List<Product> products;
    private List<Order> orders;
    private List<User> users;
    private List<Seller> sellers;
    private List<Admin> admins;
    private double totalProfit;
    public void setTotalProfit(double totalProfit){
        this.totalProfit=totalProfit;
    }
    public double getTotalProfit(){
        return totalProfit;
    }
    public Shop(String name,String website,String supportNumber){
        this.name=name;
        this.website=website;
        this.supportNumber=supportNumber;
        this.products=new ArrayList<>();
        this.orders=new ArrayList<>();
        this.users=new ArrayList<>();
        this.sellers=new ArrayList<>();
        this.admins=new ArrayList<>();
    }
}