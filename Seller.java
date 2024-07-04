public class Seller extends BaseIntro{
    private String companyName;
    public Seller(String username , String password, String companyName){
        super(username,password);
        this.companyName=companyName;
    }
    public void setCompanyName(String companyName){
        this.companyName=companyName;
    }
    public String getCompanyName(){
        return companyName;
    }
}