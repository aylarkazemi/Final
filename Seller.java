import java.util.ArrayList;
import java.util.List;

public class Seller extends BaseInfo{
    private String companyName;
    private List<Product> productList;
    private Wallet wallet;
    private boolean isApproved;
    public Seller(String username,String password,String email,String companyName){
        super(username,password,email);
        this.companyName=companyName;
        this.productList=new ArrayList<>();
        this.wallet=new Wallet();
        this.isApproved=false;
    }
    public String getCompanyName(){
        return companyName;
    }
    public void setCompanyName(String companyName){
        this.companyName=companyName;
    }
    public List<Product> getProductList(){
        return productList;
    }
    public void setProductList(List<Product> productList){
        this.productList=productList;
    }
    public Wallet getWallet(){
        return wallet;
    }
    public void setWallet(Wallet wallet){
        this.wallet=wallet;
    }
    public void approve() {
        this.isApproved = true;
    }
    public boolean isApproved(){
        return isApproved;
    }
    public void setApproved(boolean isApproved){
        this.isApproved=isApproved;
    }
    public void addProduct(Product product){
        if(isApproved){
            this.productList.add(product);
            System.out.println("Product added to the seller's product list");
        }
        else {
            System.out.println("Seller is not approved to add products");
        }
    }
    public void requestApproval() {
        // Logic to send a request for approval can be implemented here
        System.out.println("Request for approval has been sent to the admin.");}

        @Override
    public void displayAccountDetails(){
        System.out.println("Seller user Account : ");
        System.out.println("Company NAME : "+companyName);
        System.out.println("Email : "+getEmail());
        System.out.println("Wallet balance : $" +wallet);
        System.out.println("Approved: " + (isApproved ? "Yes" : "No"));
    }





}