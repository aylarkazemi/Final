public class AddFundsRequest {
    private BaseInfo baseInfo;
    private double amount;

    public AddFundsRequest(BaseInfo baseInfo, double amount) {
        this.baseInfo = baseInfo;
        this.amount = amount;
    }

    public BaseInfo getUser() {
        return baseInfo;
    }

    public double getAmount() {
        return amount;
    }
}

