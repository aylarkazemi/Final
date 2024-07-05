public class Admin extends BaseInfo {
    public Admin(String username,String password, String email){
        super(username,password,email);
    }
    public void approveSeller(Seller seller){
        seller.setApproved(true);
    }
    @Override
    public void displayAccountDetails(){
        System.out.println("Admin user account : ");
        System.out.println("Username :" + getUsername());
        System.out.println("Email : "+getEmail());
    }
    public void approvedSeller(Seller seller ){
        seller.setApproved(true);
    }
}