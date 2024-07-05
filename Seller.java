import java.util.ArrayList;
import java.util.List;

public class Seller extends BaseInfo{
    private String companyName;
    private List<Product> productList;
    private double wallet;
    private boolean isApproved;
    public Seller(String username,String password,String email,String companyName){
        super(username,password,email);
        this.companyName=companyName;
        this.productList=new ArrayList<>();
        this.wallet=0.0;
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
    public double getWallet(){
        return wallet;
    }
    public void setWallet(double wallet){
        this.wallet=wallet;
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
    @Override
    public void displayAccountDetails(){
        System.out.println("Seller user Account : ");
        System.out.println("Company NAME : "+companyName);
        System.out.println("Email : "+getEmail());
        System.out.println("Wallet balance : $" +wallet);
        System.out.println("Approved status : " + isApproved);
    }





}