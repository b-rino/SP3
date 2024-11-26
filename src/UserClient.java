import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class UserClient {
    private FileIO io = new FileIO();
    private TextUI ui = new TextUI();
    protected User currentUser = null;


    public User login() {
        List<User> users = io.readUserData(enumPathing.USER);

        String answerAlreadyUser = ui.promptText("Do you already have a user? Y / N ?");

        if (answerAlreadyUser.equalsIgnoreCase("Y")) {
            String username = ui.promptText("Enter your username: ");
            String password = ui.promptText("Enter your password: ");
            User user = new User(username, password);

            if (users.contains(user)) {
                System.out.println("You have successfully logged in!");
                currentUser = user;
                return user;
            } else {
                System.out.println("You have entered a invalid username or password!");
               return login();
            }

            // Creating new user
        }
        else if (answerAlreadyUser.equalsIgnoreCase("N")) {
            System.out.println("Creating an account ");
            // TODO: Search userdata if username already exists
            String username = ui.promptText("Enter your username: ");
            String password = ui.promptText("Enter your password: ");
            List<User> saveNewUser = new ArrayList<>();
            User newUser = new User(username, password);
            saveNewUser.add(newUser);
            io.saveUserData(saveNewUser, enumPathing.USER, "username, password");
            System.out.println("You have successfully created an account! ");
            currentUser = newUser;
            return newUser;
        }
        return null;
    }

    public void displayCurrentUser() {
        System.out.println("Current user: " + currentUser.getUsername());
    }
}


