import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class User {
    private String password;
    private String username;
    private List<Media> watchAgain = new ArrayList<>();
    private List<Media> watchLater = new ArrayList<>();
    private String path = "data\\userdata.txt";

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }


    /*
    public void setPassword() {
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
    }

     */

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return username.equals(user.username) && password.equals(user.password);
    }

    @Override
    public String toString() {
        return  username + "; " + password;
    }

    @Override public int hashCode() {
        return Objects.hash(username, password);
    }
}
