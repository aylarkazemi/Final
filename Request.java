public class Request {
    private User user;
    private double amount;
    private boolean isApproved;
    public Request(User user, double amount){
        this.user=user;
        this.amount=amount;
        this.isApproved=false;
    }
    public User getUser(){
        return user;
    }
    public double getAmount(){
        return amount;
    }
    public boolean isApproved(){
        return isApproved;
    }
    public void approve(){
        this.isApproved=true;
        user.getWallet().addFunds(amount);
        System.out.println("Request approved for customer : "+user.getUsername()
        +" , Amount : "+amount);
    }
}
