import java.util.ArrayList;
import java.util.List;

public class UserList {
    private List<User> users;
    private String username;
    private String password;
    private boolean adult;
    private List<Media> watchLater;
    private List<Media> watchAgain;


    /*public void setPassword() {
        password = ui.promptText("Please enter your password: ");
        if(password == null || password.equals("")){
            throw new IllegalArgumentException("Password cannot be empty");
        }
        else {
            this.password = password;
        }
    }
    public void setUsername() {
        username = ui.promptText("Please enter your username: ");
        if(username == null || username.equals("")){
            throw new IllegalArgumentException("Username cannot be empty");
        }
        else {
            this.username = username;
        }
    }*/
}
