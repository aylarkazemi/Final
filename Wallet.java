public class Wallet {
    private double balance;
    public Wallet(){
        this.balance=0.0;
    }
    public double getBalance(){
        return balance;
    }
    public void addFunds(double amount){
        this.balance+=amount;
    }
    public void deductFunds(double amount) {
        this.balance -= amount;
    }

    @Override
    public String toString(){
        return "Wallet { balance ="+balance+" }";
    }
}
