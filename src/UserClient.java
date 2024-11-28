import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class UserClient {
    private FileIO io = new FileIO();
    private TextUI ui = new TextUI();
    private String currentUsername;


    public User login() {
        List<User> users = io.readUserData();
        String answerAlreadyUser = ui.promptText("Do you already have a user? Y / N ?");
        // Login current user
        if (answerAlreadyUser.equalsIgnoreCase("Y")) {
            String username = ui.promptText("Enter your username: ");
            String password = ui.promptText("Enter your password: ");
            User user = new User(username, password);

            if (users.contains(user)) {
                System.out.println("You have successfully logged in!\nWelcome to CHILL");
                currentUsername = username;
                return user;
            } else {
                System.out.println("You have entered a invalid username or password!");
                return login();
            }

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
            List<User> saveNewUser = new ArrayList<>();
            User newUser = new User(username, password);
            saveNewUser.add(newUser);
            io.saveUserData(saveNewUser, "username, password");
            System.out.println("You have successfully created an account!\nWelcome to CHILL");
            currentUsername = username;
            return newUser;
        }
        else {
            System.out.println("You have entered an invalid choice!\nPlease try again!");
            return login();
        }
    }
}


