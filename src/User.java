import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.io.File;

public class User {
    private String password;
    private String username;
    private String pathWatchAgain;
    private String pathWatchLater;
    File fileWatchAgain;
    File fileWatchLater;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.pathWatchAgain = "data//" + username + "WatchAgain.txt";
        this.pathWatchLater = "data//" + username + "WatchLater.txt";
        this.fileWatchAgain = new File(pathWatchAgain);
        this.fileWatchLater = new File(pathWatchLater);

        try {
            // Tries to create a file. Checks if it already exists
           fileWatchAgain.createNewFile();
           fileWatchLater.createNewFile();

        } catch (IOException e) {
            System.out.println("An error occurred while creating the files!");
            e.printStackTrace();
        }
    }


    public String getPathWatchAgain() {
        return pathWatchAgain;
    }

    public String getPathWatchLater() {
        return pathWatchLater;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return username.equals(user.username) && password.equals(user.password);
    }

    @Override
    public String toString() {
        return  username + "; " + password;
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, password);
    }
}
