import java.util.List;

public class UserClient {
    private FileIO io = new FileIO();
    private TextUI ui = new TextUI();
    List<User> users = io.readUserData();

    public User login() {
        String answerAlreadyUser = ui.promptText("Do you already have a user? Y / N ?");
        // Login current user
        if (answerAlreadyUser.equalsIgnoreCase("Y")) {
            String username = ui.promptText("Enter your username: ");
            String password = ui.promptText("Enter your password: ");
            for (User user : users) {
                if(user.getUsername().equals(username) && user.getPassword().equals(password)) {
                    System.out.println("You have successfully logged in!\nWelcome to CHILL");
                    return user;
                }
            }
                System.out.println("You have entered a invalid username or password!");
                return login();
            }

        // Creating new user
        else if (answerAlreadyUser.equalsIgnoreCase("N")) {
            System.out.println("Creating an account ");
            String username = ui.promptText("Enter your username: ");
            for (User user : users) {
                if (username.equals(user.getUsername())) {
                    System.out.println("The username already exists!");
                    return login();
                }
            }
            String password = ui.promptText("Enter your password: ");
            User newUser = new User(username, password);
            io.saveUserData(newUser, "username, password");
            System.out.println("You have successfully created an account!\nWelcome to CHILL");
            return newUser;
        }
        else {
            System.out.println("You have entered an invalid choice!\nPlease try again!");
            return login();
        }
    }
}


