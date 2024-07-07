import java.util.*;
public class Main {
    private static List<User> users = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Shop shop = new Shop("** AYLAR KAZEMI COMPANY **", "WWW.Aylar.com", "123456");
        Admin predefinedAdmin = new Admin("Admin", "1234", "admin@shop.com");
        shop.addBaseInfo(predefinedAdmin);
        while (true) {
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. About us");
            System.out.println("4. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine();
            if (choice == 1) {
                System.out.println("Customer(Press1) or Seller(Press2) or Admin(press3)?");
                int i = scanner.nextInt();
                if (i == 1) {
                    System.out.println("Okey, let's get started ...");
                    scanner.nextLine();
                    System.out.println("Please, enter a username : ");
                    String username = scanner.nextLine();
                    System.out.println("Please, enter a password : ");
                    String password = scanner.nextLine();
                    System.out.println("Please, enter an e-mail : ");
                    String email = scanner.nextLine();
                    System.out.println("Please, enter a phone number : ");
                    String phonenumber = scanner.nextLine();
                    System.out.println("Please, enter an address : ");
                    String address = scanner.nextLine();
                    User newUser = new User(username, password, email, phonenumber, address);
                    shop.addUser(newUser);
                } else if (i == 2) {
                    System.out.println("Okey, let's get started ...");
                    scanner.nextLine();
                    System.out.println("Please, enter a username : ");
                    String username = scanner.nextLine();
                    System.out.println("Please, enter a password : ");
                    String password = scanner.nextLine();
                    System.out.println("Please, enter an e-mail : ");
                    String email = scanner.nextLine();
                    System.out.println("Please, enter your company name : ");
                    String company = scanner.nextLine();
                    Seller newSeller = new Seller(username, password, email, company);
                    shop.addSeller(newSeller);
                } else if (i == 3) {
                    System.out.println("Okey, let's get started ...");
                    scanner.nextLine();
                    System.out.println("Please, enter a username : ");
                    String username = scanner.nextLine();
                    System.out.println("Please, enter a password : ");
                    String password = scanner.nextLine();
                    System.out.println("Please, enter an e-mail : ");
                    String email = scanner.nextLine();
                    Admin admin = new Admin(username, password, email);
                    shop.addAdminRequest(admin);
                    System.out.println("Admin account request sent for approval.");
                } else {
                    System.out.println("Invalid choice");
                }
                System.out.println("Registration successful!");
            } else if (choice == 2) {
                System.out.println("Please, enter your username: ");
                String username = scanner.nextLine();
                System.out.println("Please, enter your password: ");
                String password = scanner.nextLine();
                BaseInfo baseInfo = shop.authenticate(username, password);
                if (baseInfo != null) {
                    BaseInfo base = shop.getUserAccountByUsername(username);
                    if (base instanceof Admin) {
                        System.out.println("You are an Admin and logged in successfully:-)");
                        adminMenu(scanner, shop, (Admin) baseInfo);
                    } else if (base instanceof Seller) {
                        System.out.println("You are a Seller and logged in successfully:-)");
                        sellerMenu(scanner, (Seller) baseInfo, shop);
                    } else if (base instanceof User) {
                        System.out.println("You are a customer and logged in successfully:-)");
                        userMenu(scanner, shop, (User) baseInfo);
                    }
                } else {
                    System.out.println("Invalid username or password.");
                }
            } else if (choice == 3) {
                System.out.println("Name : " + shop.getName());
                System.out.println("Website : " + shop.getWebsite());
                System.out.println("Contact us : " + shop.getSupportNumber());
                System.out.println(" ");
            } else if (choice == 4) {
                break;
            } else {
                System.out.println("Invalid choice. please try again.");
            }
        }
    }

    private static void userMenu(Scanner scanner, Shop shop, User user) {
        while (true) {
            System.out.println("1. Edit profile");
            System.out.println("2. Search products");
            System.out.println("3. View Cart");
            System.out.println("4. Request Add Funds");
            System.out.println("5. Log out");
            int choice = scanner.nextInt();
            scanner.nextLine();
            if (choice == 1) {
                editProfile(scanner, user);
            } else if (choice == 2) {
                searchProducts(scanner, shop, user);
            } else if (choice == 3) {
                viewCart(user);
            } else if (choice == 4) {
                requestAddFunds(scanner, shop, user);
            } else if ((choice == 5)) {
                break;
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public static void requestAddFunds(Scanner scanner, Shop shop, User user) {
        System.out.println("Enter amount to add to wallet:");
        double amount = Double.parseDouble(scanner.nextLine());
        AddFundsRequest request = new AddFundsRequest(user, amount);
        shop.addFundsRequest(request);
        System.out.println("Funds request sent to admin.");
    }

    private static void editProfile(Scanner scanner, User user) {
        System.out.println("Enter new Username : ");
        String username = scanner.nextLine();
        System.out.println("Enter new Password : ");
        String password = scanner.nextLine();
        System.out.println("Enter new Email : ");
        String email = scanner.nextLine();
        System.out.println("Enter new phone number : ");
        String phonenumber = scanner.nextLine();
        System.out.println("Enter new address : ");
        String address = scanner.next();
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        user.setPhoneNumber(phonenumber);
        user.setAddress(address);
        System.out.println("Profile updated.");
        System.out.println("New inserted data : ");
        System.out.println("Username: " + username + " Password: " + password
                + " Email: " + email + " Phone number: " + phonenumber + " Address: " + address);
    }

    private static void searchProducts(Scanner scanner, Shop shop, User customer) {
        System.out.println("Enter keyword to search: ");
        String keyword = scanner.nextLine();
        List<Product> products = shop.searchProducts(keyword);

        if (products.isEmpty()) {
            System.out.println("No products found.");
        } else {
            for (Product product : products) {
                System.out.println(product);
            }
            System.out.println("Enter product ID to add to cart or press 0 to return.");
            int productID = Integer.parseInt(scanner.nextLine());

            if (productID != 0) {
                for (Product product : products) {
                    if (product.getId() == productID) {
                        System.out.println("Enter quantity: ");
                        int quantity = Integer.parseInt(scanner.nextLine());

                        if (quantity > 0 && quantity <= product.getQuantityAvailable()) {
                            customer.getCart().addItem(product, quantity);
                            product.reduceQuantity(quantity);
                            System.out.println("Product added to cart.");
                        } else {
                            System.out.println("Invalid quantity.");
                        }
                        break;
                    }
                }
            }
        }
    }


    private static void viewCart(User user) {
        System.out.println("Your cart : ");
        for (CartItem item : user.getCart().getItems()) {
            System.out.println("Product: " + item.getProduct().getName()
                    + "Quantity: " + item.getQuantity());
        }
        System.out.println("Total price : " + user.getCart().getTotalPrice());
        System.out.println(" ");
    }

    private static void adminMenu(Scanner scanner, Shop shop, Admin admin) {
        while (true) {
            System.out.println("1.View somebody's profile");
            System.out.println("2.Approve Seller");
            System.out.println("3.Approve admin");
            System.out.println("4.Approve Add Funds");
            System.out.println("5.Logout");
            int choice = scanner.nextInt();
            if (choice == 1) {
                System.out.print("Enter username to view profile: ");
                scanner.nextLine();
                String username = scanner.nextLine();
                BaseInfo baseInfo = shop.getUserAccountByUsername(username);
                if (baseInfo != null && baseInfo instanceof User) {
                    ((User) baseInfo).displayAccountDetails();
                } else {
                    System.out.println("User not found or not a customer.");
                }
            } else if (choice == 2) {
                approveSeller(scanner, admin);
            } else if (choice == 3) {
                approveAdmin(scanner, shop);
            } else if (choice == 4) {
                approveAddFunds(scanner, shop);
                break;
            } else if (choice == 5) {
                break;
            } else {
                System.out.println("Invalid choice. Try again.");
            }
        }
    }

    public static void approveAddFunds(Scanner scanner, Shop shop) {
        List<AddFundsRequest> requests = shop.getFundsRequests();
        if (requests.isEmpty()) {
            System.out.println("No funds requests.");
            return;
        }

        for (int i = 0; i < requests.size(); i++) {
            AddFundsRequest request = requests.get(i);
            System.out.println((i + 1) + ". User: " + request.getUser().getUsername() + ", Amount: " + request.getAmount());
        }

        int choice = -1;
        while (choice < 0 || choice >= requests.size()) {
            System.out.println("Select a request to approve (enter number):");
            String input = scanner.nextLine().trim();

            if (input.isEmpty() || !input.matches("\\d+")) {
                System.out.println("Invalid input. Please enter a number.");
            } else {
                choice = Integer.parseInt(input) - 1;
                if (choice >= 0 && choice < requests.size()) {
                    AddFundsRequest requestToApprove = requests.get(choice);
                    BaseInfo baseInfo = requestToApprove.getUser();
                    if (baseInfo instanceof User) {
                        User customer = (User) baseInfo;
                        customer.getWallet().addFunds(requestToApprove.getAmount());
                        System.out.println("Funds approved successfully.");
                    }
                    shop.getFundsRequests().remove(choice);
                } else {
                    System.out.println("Invalid choice. Please select a number between 1 and " + requests.size());
                }
            }
        }
    }



    private static void sellerMenu(Scanner scanner,Seller seller,Shop shop) {
        while (true) {
            if (!seller.isApproved()) {
                System.out.println("You are not certified yet. Do you want to send a request? (yes/no)");
                String response = scanner.nextLine();
                if (response.equalsIgnoreCase("yes")) {
                    sendApprovalRequest(seller,shop);
                }
                break;
            }
            else {
                System.out.println("1. Add Product");
                System.out.println("2. View Products");
                System.out.println("3. Logout");
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();
                scanner.nextLine();
                if (choice == 1) {
                    addProduct(scanner,seller,shop);}
                else if (choice==2){
                    System.out.println("Products:");
                    for (Product prod : seller.getProductList()) {
                        System.out.println("Name: " + prod.getName() + ", Price: " + prod.getPrice() + ", Quantity: " + prod.getQuantityAvailable() + ", Category: " + prod.getCategory());
                    }
                    System.out.println("Wallet Balance: " + seller.getWallet().getBalance());
                    break;
                }
                else if (choice == 3) {
                    break;
                }
            }
        }
    }
    private static void addProduct(Scanner scanner,Seller seller,Shop shop) {
        System.out.print("Enter product name: ");
        String name = scanner.nextLine();
        System.out.print("Enter product price: ");
        double price = scanner.nextDouble();
        System.out.print("Enter product stock: ");
        int stock = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter product category: ");
        String categoryName = scanner.nextLine();

        Product product = new Product(name, price, stock, new Category(categoryName));
        seller.addProduct(product);
        shop.addProduct(product);
        System.out.println("Product added successfully.");
    }
    private static void approveSeller(Scanner scanner,Admin loggedInUser){
        Admin admin = (Admin) loggedInUser;
        List<Seller> requests = admin.getApprovalRequests();

        if (requests.isEmpty()) {
            System.out.println("No approval requests found.");
            return;
        }

        System.out.println("Approval Requests:");
        for (int i = 0; i < requests.size(); i++) {
            System.out.println((i + 1) + ". " + requests.get(i).getUsername());
        }
        System.out.print("Enter the number of the seller to approve: ");
        int index = scanner.nextInt() -1;
        scanner.nextLine();

        if (index >= 0 && index < requests.size()) {
            Seller seller = requests.get(index);
            System.out.print("Approve this seller? (yes/no): ");
            String response = scanner.nextLine();
            if (response.equalsIgnoreCase("yes")) {
                admin.approveSellers(seller);
                System.out.println("Seller approved.");
            } else {
                admin.denySeller(seller);
                System.out.println("Seller not approved.");
            }
        }
    }
    private static void sendApprovalRequest(Seller seller,Shop shop) {
        for (BaseInfo baseInfo : shop.getBaseInfos()) {
            if (baseInfo instanceof Admin) {
                ((Admin) baseInfo).approveSeller(seller);
                System.out.println("Approval request sent to admin : "+baseInfo.getUsername());
                return;
            }
        }
        System.out.println("No admin found to sendApproval request.");
    }
    public static void approveAdmin(Scanner scanner, Shop shop) {
        List<Admin> adminRequests = shop.getAdminApprovalRequests();
        if (adminRequests.isEmpty()) {
            System.out.println("No admin approval requests.");
            return;
        }

        for (int i = 0; i < adminRequests.size(); i++) {
            Admin admin = adminRequests.get(i);
            System.out.println((i + 1) + ". Username: " + admin.getUsername() + ", Email: " + admin.getEmail());
        }

        int choice = -1;
        boolean validInput = false;

        while (!validInput) {
            System.out.println("Select an admin to approve (enter number):");
            String input = scanner.nextLine().trim();

            if (input.isEmpty() || !input.matches("\\d+")) {
                System.out.println("Invalid input. Please enter a number.");
            } else {
                choice = Integer.parseInt(input) - 1;
                if (choice >= 0 && choice < adminRequests.size()) {
                    validInput = true;
                } else {
                    System.out.println("Invalid choice. Please select a number between 1 and " + adminRequests.size());
                }
            }
        }

        Admin adminToApprove = adminRequests.get(choice);
        shop.approveAdmin(adminToApprove);
        System.out.println("Admin approved successfully.");
    }


}

