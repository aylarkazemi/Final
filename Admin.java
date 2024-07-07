import java.util.ArrayList;
import java.util.List;

public class Admin extends BaseInfo {
    private List <Seller> approvalRequests;
    private boolean approved;
    private List<AddFundsRequest> aprq;
    public Admin(String username,String password, String email){
        super(username,password,email);
        this.approvalRequests = new ArrayList<>();
        this.aprq = new ArrayList<>();
    }
    public void approveSeller(Seller seller){
        approvalRequests.add(seller);
    }
    public List<Seller> getApprovalRequests() {
        return approvalRequests;
    }
    @Override
    public void displayAccountDetails(){
        System.out.println("Admin user account : ");
        System.out.println("Username :" + getUsername());
        System.out.println("Email : "+getEmail());
    }
    public void approveSellers(Seller seller) {
        seller.setApproved(true);
        approvalRequests.remove(seller);
    }
    public void denySeller(Seller seller) {
        approvalRequests.remove(seller);
    }
    public void setApproved(boolean approved) {
        this.approved = approved;

    }
    public void approveFundsRequest(AddFundsRequest request) {
        request.getUser().addToWallet(request.getAmount());
        aprq.remove(request);
    }

    public void addApprovalRequest(AddFundsRequest request) {
        aprq.add(request);
    }

    public List<AddFundsRequest> getAprq() {
        return aprq;
    }

}