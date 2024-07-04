import javax.management.BadStringOperationException;
public class BaseIntro {
    private String username;
    private String password;
    public void setUsername(String username){
        this.username=username;
    }
    public String getUsername() {
        return username;
    }
    public void setPassword(){
        this.password=password;
    }
    public String getPassword(){
        return password;
    }
    public BaseIntro(String username,String password){
        this.password=password;
        this.username=username;
    }
}
