import java.util.*;
public class Menue {
    private List<String> usernames = new ArrayList<>();

    public void display() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to this shop ");
        System.out.println("Please enter your username");
        String username = scanner.nextLine();

        if (usernames.contains(username)) {
            System.out.println("Hey " + username);
            System.out.println("Please enter the password : ");
        } else {
            System.out.println("You are not authenticated yet. Enter a password to register :");
            usernames.add(username);
        }
    }
        public List<String> getUsernames(){
        return usernames;


    }


}
