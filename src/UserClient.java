import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class UserClient {
    private FileIO io = new FileIO();
    private TextUI ui = new TextUI();

    public void createUser() {

      /*  userlist.setUsername();
        userlist.setPassword();
        //userCredentials.put(this.username, this.password); flex only
        ui.displayMsg("You have successfully created a user and are now logged in");
        List<User> saveUserData = new ArrayList<>();
        saveUserData.add(this.username);
        saveUserData.add(this.password);
        io.saveData(savedData, enumPathing.USER, "username, password");
    }


       */
    public void login(){
        List<UserList> users = io.readUserData(enumPathing.USER);

        String answerAlreadyUser = ui.promptText("Do you already have a user? Y / N ?");

        if(answerAlreadyUser.equalsIgnoreCase("Y")) {
                String username = ui.promptText("Enter your username: ");
                if (users.contains(username)) {
                    String password = ui.promptText("Enter your password: ");
                    if(users.contains(password)) {
                        System.out.println("You have successfully logged in!");
                    }
                }
            }
        else if(answerAlreadyUser.equalsIgnoreCase("N")) {
            String createUser = ui.promptText("Would you like to create a new user? Y / N ?");
            if(createUser.equalsIgnoreCase("Y")) {
                String username = ui.promptText("Enter your username: ");
                String password = ui.promptText("Enter your password: ");
                List <UserList> saveNewUser = new ArrayList <>();
                UserList newUser = new UserList(username, password);
                io.saveUserData(saveNewUser, enumPathing.USER, "username, password");
            }
        }
        }


    }
}
