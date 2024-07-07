import java.util.*;
abstract class BaseInfo {
    public String username;
    protected String password;
    protected String email;
    private double walletBalance;
    private List<AddFundsRequest> addFundsRequests;

    public BaseInfo(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.walletBalance = 0;
        this.addFundsRequests = new ArrayList<>();
    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String username) {
        this.email = email;
    }


    public void addFundsRequest(AddFundsRequest request) {
        addFundsRequests.add(request);
    }

    public List<AddFundsRequest> getAddFundsRequests() {
        return addFundsRequests;
    }

    public void addToWallet(double amount) {
        this.walletBalance += amount;
    }

    public double getWalletBalance() {
        return walletBalance;
    }

    public void viewProfile() {
        System.out.println("Username : " + getUsername());
        System.out.println("Password : " + getPassword());
        System.out.println("Email : " + getEmail());
    }

    public void displayAccountDetails() {
        System.out.println("Username: " + username);
        System.out.println("Email: " + email);
        System.out.println("Wallet Balance: " + walletBalance);
    }
}