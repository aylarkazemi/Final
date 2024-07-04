public class Admin extends BaseIntro {
    private String email;
    public Admin(String username, String password, String email) {
        super(username, password);
        this.email=email;
    }
    public void setEmail(String email){
        this.email=email;
    }
}