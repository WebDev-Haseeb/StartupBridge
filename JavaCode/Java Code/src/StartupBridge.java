import java.util.*;

//User class (SuperClass for Admin, Startup and Investor) keeps track of the basic
//properties inherited by all three of them.
abstract class User {
    private int id;
    private String name;
    private String email;
    private String password;
    private String type;


    //Non-parametrized Constructor.
    User() {};

    //Parametrized Constructor.
    User(int id, String name, String email, String pass, String type) {

        //Validating Credentials.

        if (id<0 || id>9999) {
            throw new IllegalArgumentException("User ID must be a positive integer of at " +
                    "max 4 digits.");
        }

        if (name.isEmpty()) {
            throw new IllegalArgumentException("Name can't be empty");
        }

        if (!(validEmail(email))) {
            throw new IllegalArgumentException("Email invalid.");
        }

        if (pass.length()<8) {
            throw new IllegalArgumentException("Password must contain a minimum of 8 characters.");
        }

        if (!(validType(type))) {
            throw new IllegalArgumentException("Invalid Type.");
        }

        //Initialization.
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = pass;
        this.type = type;
    }

    //Type Validation.
    private boolean validType(String type) {
        return (type.equalsIgnoreCase("startup") ||
                type.equalsIgnoreCase("investor") ||
                type.equalsIgnoreCase("admin"));
    }

    //Email Validation.
    private boolean validEmail(String email) {
        String emailRegex = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";

        // Check if the email matches the regular expression
        return email.matches(emailRegex);
    }



    //Setters.
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setType(String type) {
        this.type = type;
    }



    //Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return this.password;
    }

    public String getType() {
        return type;
    }



    // Methods
    public void register() {
        // Implementation for user registration
    }

    public void login() {
        // Implementation for user login
    }

    public void logout() {
        // Implementation for user logout
    }

    public void updateProfile() {
        // Implementation for updating user profile
    }
};


class Startup extends User {
    private String companyName;
    private String description;
    private String industry;
    private double fundingGoal;
    private String pitchDeck;

    //Non Parametrized Constructor.
    Startup() {};

    //Parametrized Constructor.
    Startup(int id, String name, String email, String password, String type, String company, String des,
            String industry, double fundingGoal, String pitchDeck) {

        super(id, name, email, password ,"Startup");

        //Credentials Validation.
        if (company.isEmpty()) {
            throw new IllegalArgumentException("Company Name can't be empty.");
        }

        if (des.isEmpty()) {
            throw new IllegalArgumentException("Company Description can't be empty.");
        }

        if (industry.isEmpty()) {
            throw new IllegalArgumentException("Industry can't be empty.");
        }

        if (fundingGoal<0) {
            throw new IllegalArgumentException("Funding Goal can't be negative.");
        }

        if (pitchDeck.isEmpty()) {
            throw new IllegalArgumentException("Pitch Deck link can't be empty.");
        }

        //Initialization.
        this.companyName = company;
        this.description = des;
        this.industry = industry;
        this.fundingGoal = fundingGoal;
        this.pitchDeck = pitchDeck;

    }


    // Setters
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public void setFundingGoal(double fundingGoal) {
        this.fundingGoal = fundingGoal;
    }

    public void setPitchDeck(String pitchDeck) {
        this.pitchDeck = pitchDeck;
    }

    // Getters
    public String getCompanyName() {
        return companyName;
    }

    public String getDescription() {
        return description;
    }

    public String getIndustry() {
        return industry;
    }

    public double getFundingGoal() {
        return fundingGoal;
    }

    public String getPitchDeck() {
        return pitchDeck;
    }


    //Methods.

    //Super Class Method.
    @Override
    public void register() {
        super.register();
        System.out.println("User Registration Successful!");
    }

    @Override
    public void login() {
        super.login();
        System.out.println("Logged in Successfully!");
    }

    @Override
    public void logout() {
        super.logout();
        System.out.println("Logged out Successfully!");
    }

    @Override
    public void updateProfile() {
        super.updateProfile();
        System.out.println("Profile has been updated!");
    }


    //Native Methods.
    public void viewInvestorProfiles() {
        // Display investor profiles (replace with actual data retrieval)
        System.out.println("Displaying investor profiles...");
    }

    public void initiateFundingDiscussion() {
        // Success message
        System.out.println("Funding discussion initiated.");
    }

    public void closeFundingDeal() {
        // Success message
        System.out.println("Funding deal closed.");
    }
};



class Investor extends User {
    String investmentFocus;
    List<String> portfolio;
    double netWorth;

    //Non-Parametrized Constructor.
    Investor() {};

    //Parametrized Constructor.
    Investor(int id, String name, String email, String password, String type, String focus,
             List<String> portfolio, double worth) {

        //Using Super Attributes.
        super(id, name, email, password, "Investor");

        //Credentials Validation.
        if (focus.isEmpty()) {
            throw new IllegalArgumentException("Investment Focus can't be empty.");
        }

        if (portfolio.isEmpty()) {
            throw new IllegalArgumentException("Portfolio can't be empty.");
        }

        if (worth<0) {
            throw new IllegalArgumentException("Net worth can't be negative.");
        }

        //Initialization.
        this.investmentFocus = focus;
        this.portfolio = portfolio;
        this.netWorth = worth;
    }

    // Getters
    public String getInvestmentFocus() {
        return this.investmentFocus;
    }

    public List<String> getPortfolio() {
        return this.portfolio;
    }

    public double getNetWorth() {
        return this.netWorth;
    }

    // Setters
    public void setInvestmentFocus(String investmentFocus) {
        this.investmentFocus = investmentFocus;
    }

    public void setPortfolio(List<String> portfolio) {
        this.portfolio = portfolio;
    }

    public void setNetWorth(double netWorth) {
        this.netWorth = netWorth;
    }



    //Methods.

    //Super Class Method.
    @Override
    public void register() {
        super.register();
        System.out.println("User Registration Successful!");
    }

    @Override
    public void login() {
        super.login();
        System.out.println("Logged in Successfully!");
    }

    @Override
    public void logout() {
        super.logout();
        System.out.println("Logged out Successfully!");
    }

    @Override
    public void updateProfile() {
        super.updateProfile();
        System.out.println("Profile has been updated!");
    }

    //Native Methods.
    public void browseStartupProfiles() {
        // Display startup profiles (replace with actual data retrieval)
        System.out.println("Displaying startup profiles...");
    }

    public void viewStartupPitches() {
        // Display startup pitch deck (replace with actual data retrieval)
        System.out.println("Displaying startup pitch deck...");
    }

    public void engageFundingDiscussion() {
        // Success message
        System.out.println("Funding discussion initiated.");
    }

    public void closeFundingDeal() {
        // Success message
        System.out.println("Funding deal closed.");
    }
};


class Admin extends User {
    String adminType;

    //Non-parametrized Constructor.
    Admin() {};

    //Parametrized Constructor.
    Admin (int id, String name, String email, String password, String type, String adminType) {
        super(id, name, email, password, "Admin");

        //Validation.
        if (!(adminType.equalsIgnoreCase("SuperAdmin") || (adminType.equalsIgnoreCase("RegularAdmin")))) {
            throw new IllegalArgumentException("Invalid Choice.");
        }

        this.adminType = adminType;
    }

    //Setter.
    public void setAdminType(String adminType) {
        this.adminType = adminType;
    }

    //Getter.
    public String getAdminType() {
        return this.adminType;
    }



    //Methods.


    //Super Class Method.
    @Override
    public void register() {
        super.register();
        System.out.println("User Registration Successful!");
    }

    @Override
    public void login() {
        super.login();
        System.out.println("Logged in Successfully!");
    }

    @Override
    public void logout() {
        super.logout();
        System.out.println("Logged out Successfully!");
    }

    @Override
    public void updateProfile() {
        super.updateProfile();
        System.out.println("Profile has been updated!");
    }

    //Native Methods.
    public void manageUsers() {
        // Display user management options (replace with actual data retrieval)
        System.out.println("User management options:");
        System.out.println("1. View all users");
        System.out.println("2. Edit user profile");
        System.out.println("3. Delete user");
        System.out.println("4. Manage user roles");
        System.out.println("5. Back to main menu");

        Scanner console = new Scanner(System.in);
        int choice = console.nextInt();

        switch (choice) {
            case 1:
                //View All Users.
                System.out.println("Displaying all users...");
                break;

            case 2:
                //Edit User Profile.
                System.out.println("User Profile has been updated.");
                break;

            case 3:
                //Delete User.
                System.out.println("User has been deleted.");
                break;

            case 4:
                // Manage user roles (database interaction).
                System.out.println("Enter user ID to manage roles:");
                //Implementation.
                break;
            case 5:
                // Back to main menu
                System.out.println("Returning to main menu...");
                break;
            default:
                System.out.println("Invalid option. Please try again.");
        }
    }

    public void manageStartups() {
        // Display startup management options
        System.out.println("Startup management options:");
        System.out.println("1. View all startups");
        System.out.println("2. Approve startup registration");
        System.out.println("3. Suspend startup account");
        System.out.println("4. View startup funding progress");
        System.out.println("5. Back to main menu");

        // Get user input
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                //View All Startups.
                System.out.println("Viewing all startups...");
                //Implementation...
                break;
            case 2:
                // Approve startup registration.
                System.out.println("Enter startup ID to approve:");
                //Implementation...
                break;
            case 3:
                // Suspend startup account.
                System.out.println("Enter startup ID to suspend:");
                //Implementation...
                break;
            case 4:
                // View startup funding progress.
                System.out.println("Enter startup ID to view funding progress:");
                //Implementation...
                break;
            case 5:
                // Back to main menu
                System.out.println("Returning to main menu...");
                break;
            default:
                System.out.println("Invalid option. Please try again.");
        }
    }

    public void manageInvestors() {
        // Display investor management options
        System.out.println("Investor management options:");
        System.out.println("1. View all investors");
        System.out.println("2. Verify investor accreditation");
        System.out.println("3. Restrict investor access");
        System.out.println("4. View investor investment history");
        System.out.println("5. Back to main menu");

        // Get user input
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                // View all investors.
                System.out.println("Viewing all investors...");
                //Implementation...
                break;
            case 2:
                // Verify investor accreditation.
                System.out.println("Enter investor ID to verify accreditation:");
                //Implementation...
                break;
            case 3:
                // Restrict investor access.
                System.out.println("Enter investor ID to restrict access:");
                //Implementation...
                break;
            case 4:
                // View investor investment history.
                System.out.println("Enter investor ID to view investment history:");
                //Implementation...
                break;
            case 5:
                // Back to main menu
                System.out.println("Returning to main menu...");
                break;
            default:
                System.out.println("Invalid option. Please try again.");
        }
    }

    public void generateReports() {
        // Display report generation options
        System.out.println("Report generation options:");
        System.out.println("1. User activity report");
        System.out.println("2. Startup funding report");
        System.out.println("3. Investor investment report");
        System.out.println("4. Back to main menu");

        // Get user input
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                // Generate user activity report.
                System.out.println("Generating user activity report...");
                //Implementation...
                break;
            case 2:
                // Generate startup funding report.
                System.out.println("Generating startup funding report...");
                //Implementation...
                break;
            case 3:
                // Generate investor investment report.
                System.out.println("Generating investor investment report...");
                //Implementation...
                break;
            case 4:
                // Back to main menu
                System.out.println("Returning to main menu...");
                break;
            default:
                System.out.println("Invalid option. Please try again.");
        }
    }
};

class SecureCommunication {
    String senderID;
    String receiverID;
    String message;
    String timeStamp;

    //Non-parametrized Constructor.
    SecureCommunication() {};

    //Parametrized Constructor.
    SecureCommunication (String senderID, String receiverID, String message, String timeStamp) {
        //Validation...
        if (senderID.isEmpty()) {
            throw new IllegalArgumentException("Sender ID can't be empty.");
        }

        if (receiverID.isEmpty()) {
            throw new IllegalArgumentException("Receiver ID can't be empty.");
        }

        if (message.length()<100) {
            throw new IllegalArgumentException("Message must at least have 100 characters.");
        }

        //Time stamp validation.
        String[] timeComponents = timeStamp.split(":");

        if(timeComponents.length != 3) {
            throw new IllegalArgumentException("Time stamp must be in HH:MM:SS format");
        }

        int hours = Integer.parseInt(timeComponents[0]);
        int minutes = Integer.parseInt(timeComponents[1]);
        int seconds = Integer.parseInt(timeComponents[2]);

        if(hours > 23) {
            throw new IllegalArgumentException("Hours in time stamp cannot be greater than 23");
        }

        if(minutes > 59) {
            throw new IllegalArgumentException("Minutes in time stamp cannot be greater than 59");
        }

        if(seconds > 59) {
            throw new IllegalArgumentException("Seconds in time stamp cannot be greater than 59");
        }


        //Initialization...
        this.senderID = senderID;
        this.receiverID = receiverID;
        this.message = message;
        this.timeStamp = timeStamp;
    }


    //Setters.
    public void setSenderID(String senderID){
        this.senderID = senderID;
    }

    public void setReceiverID(String receiverID){
        this.receiverID = receiverID;
    }

    public void setMessage(String message){
        this.message = message;
    }

    public void setTimeStamp(String timeStamp){
        this.timeStamp = timeStamp;
    }


    //Getters.
    public String getSenderID(){
        return this.senderID;
    }

    public String getReceiverID(){
        return this.receiverID;
    }

    public String getMessage(){
        return this.message;
    }

    public String getTimeStamp(){
        return this.timeStamp;
    }

    public void sendMessage() throws Exception {
        // Logic to send the message securely.
    }

};