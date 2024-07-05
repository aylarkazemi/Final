import java.util.*;
public class Shop {
    public String name;
    public String website;
    public String supportNumber;
    private List<Product> products;
    private List<Order> orders;
    private List<BaseInfo> baseInfos;
    private double totalProfit;
    public Shop(String name,String website,String supportNumber){
        this.name=name;
        this.website=website;
        this.supportNumber=supportNumber;
        this.products=new ArrayList<>();
        this.orders=new ArrayList<>();
        this.baseInfos=new ArrayList<>();
        this.totalProfit=0.0 ;
        addPredefinedAdmin();
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name=name;
    }
    public String getWebsite(){
        return website;
    }
    public void setWebsite(String website){
        this.website=website;
    }
    public String getSupportNumber(){
        return supportNumber;
    }
    public void setSupportNumber(String supportNumber){
        this.supportNumber=supportNumber;
    }
    public List<BaseInfo> getBaseInfos(){
        return baseInfos;
    }
    public void setBaseInfos(List<BaseInfo> baseInfos){
        this.baseInfos=baseInfos;
    }
    public List<Product> getProducts(){
        return products;
    }
    public void setProducts(List<Product> products){
        this.products=products;
    }
    public List<Order> getOrders(){
        return orders;
    }
    public void setOrders(List<Order> orders){
        this.orders=orders;
    }
    public void setTotalProfit(double totalProfit){
        this.totalProfit=totalProfit;
    }
    public double getTotalProfit(){
        return totalProfit;
    }
    public void addProduct(Product product){
        this.products.add(product);
    }
    public void addOrder(Order order){
        this.orders.add(order);
        this.totalProfit+=order.getTotalPrice();
    }
    //ezafe kardane accounte paye :
    public void addBaseInfo(BaseInfo baseInfo){
        this.baseInfos.add(baseInfo);
    }
    public void displayShopDetails(){
        System.out.println("Shop name : "+name);
        System.out.println("Web Address : "+website);
        System.out.println("Support Number : " + supportNumber);
        System.out.println("Total Profit: $" + totalProfit);

    }
    public void displayAllAccounts(){
        for (BaseInfo base : baseInfos){
            base.displayAccountDetails();
            System.out.println();
        }
    }
    //ezafe kardane admine asli va avvalie
    private void addPredefinedAdmin(){
        Admin predefinedAdmin= new Admin("Admin1",
                "1234","a@shop.com");
        addBaseInfo(predefinedAdmin);
    }
    public void addAdmin(Admin requestedAdmin,String username,String password,
                         String email){
        if (baseInfos.contains(requestedAdmin)){
            Admin newAdmin = new Admin(username,password,email);
            addBaseInfo(newAdmin);
            System.out.println("New admin added by : "+ requestedAdmin.getUsername());
        }
        else {
            System.out.println("Only existing admin can add new admin account");
        }
    }
    //ezafe kardane frushande
    public void addSeller(Seller seller){
        this.baseInfos.add(seller);
    }
    public void approveSeller(Admin admin, Seller seller){
        if (baseInfos.contains(admin) && admin instanceof Admin){
            admin.approveSeller(seller);
            System.out.println("Seller approved by admin : "+admin.getUsername());
        }
        else {
            System.out.println("Only existing admins can approve sellers.");
        }
    }
}