import java.security.PrivateKey;
import java.util.*;
public class Shop {
    public String name;
    public String website;
    public String supportNumber;

    private List<Product> products;
    private List<Order> orders;
    private List<BaseInfo> baseInfos;

    private double totalProfit;
    private List<Admin> adminApprovalRequests;
    private List<AddFundsRequest> fundsRequests;
    public Shop(String name,String website,String supportNumber){
        this.name=name;
        this.website=website;
        this.supportNumber=supportNumber;
        this.products=new ArrayList<>();
        this.orders=new ArrayList<>();
        this.baseInfos=new ArrayList<>();
        this.totalProfit=0.0 ;
        this.adminApprovalRequests=new ArrayList<>();
        this.fundsRequests = new ArrayList<>();
        addDefaultProducts();
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
    public void addOrder(Order order){
        this.orders.add(order);
        this.totalProfit+=order.getTotalPrice();
    }
    public void addBaseInfo(BaseInfo baseInfo){
        this.baseInfos.add(baseInfo);
    }
    public BaseInfo authenticate(String username,String password){
        for (BaseInfo base : baseInfos){
            if (base.getUsername().equals(username) && base.getPassword().equals(password)){
                return base;
            }
        }
        return null;
    }
    public void addProduct(Product product){
        this.products.add(product);
    }

    private void addDefaultProducts() {
        Category electronics = new Electronics();
        Category clothing = new Cloths();
        Category cosmetics = new Cosmetics();
        Category goods = new Goods();
        Category sports = new Sports();
        products.add(new Product("Laptop", 1000, 10, electronics));
        products.add(new Product("T-Shirt", 20, 50, clothing));
        products.add(new Product("EyeLash", 15, 30, cosmetics));
        products.add(new Product("Smartphone", 500, 20, goods));
        products.add(new Product("Ball", 60, 40, sports));
    };
    public List<Product> searchProducts(String keyword){
        List<Product> result = new ArrayList<>();
        for (Product product : products){
            if (product.getName().toLowerCase().contains(keyword.toLowerCase())){
                result.add(product);
            }
        }
        return result;
    }
    public void displayAllAccounts(){
        for (BaseInfo base : baseInfos){
            base.displayAccountDetails();
            System.out.println();
        }
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
    public void addUser(User user){
        this.baseInfos.add(user);
    }
    public void approveSeller(Seller seller) {
        seller.setApproved(true);
    }
    public BaseInfo getUserAccountByUsername(String username){
        for (BaseInfo base : baseInfos){
            if (base.getUsername().equals(username)){
                return base;
            }
        }
        return null;
    }
    public void addAdminRequest(Admin admin) {
        adminApprovalRequests.add(admin);
    }

    public List<Admin> getAdminApprovalRequests() {
        return adminApprovalRequests;
    }

    public void approveAdmin(Admin admin) {
        admin.setApproved(true);
        baseInfos.add(admin);
        adminApprovalRequests.remove(admin);
    }
    public void addFundsRequest(AddFundsRequest request) {
        fundsRequests.add(request);
    }
    public List<AddFundsRequest> getFundsRequests() {
        return fundsRequests;
    }
    public void approveFundsRequest(AddFundsRequest request) {
        request.getUser().addToWallet(request.getAmount());
        fundsRequests.remove(request);
    }


}