import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class UserClient {
    private FileIO io = new FileIO();
    private TextUI ui = new TextUI();


    public void login(){
        List<User> users = io.readUserData(enumPathing.USER);

        String answerAlreadyUser = ui.promptText("Do you already have a user? Y / N ?");

        if(answerAlreadyUser.equalsIgnoreCase("Y")) {
                String username = ui.promptText("Enter your username: ");
                    String password = ui.promptText("Enter your password: ");
                    User user = new User(username, password);
                    if(users.contains(user)) {
                        System.out.println("You have successfully logged in!");
                    }
                    else System.out.println("You have entered a unvalid username or password!");
                }
            }
       /* else if(answerAlreadyUser.equalsIgnoreCase("N")) {
            String createUser = ui.promptText("Would you like to create a new user? Y / N ?");
            if(createUser.equalsIgnoreCase("Y")) {
                String username = ui.promptText("Enter your username: ");
                String password = ui.promptText("Enter your password: ");
                List <User> saveNewUser = new ArrayList <>();
                UserList newUser = new User(username, password);
                saveNewUser.add(newUser);
                io.saveUserData(saveNewUser, enumPathing.USER, "username, password");
            }
        }
        }

    }

        */
}