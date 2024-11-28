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

    public void addToWatchAgain (Media media) {
        FileIO fileio = new FileIO();
        fileio.saveMediaData(media, this.pathWatchAgain, "title, year, category, rating, seasons, episodes");
    }

    public void addToWatchLater (Media media) {
        MediaClient mediaClient = new MediaClient(User.this);
        FileIO fileio = new FileIO();
        List<Media> alreadyOnList = fileio.readMediaData("watchLater", this);
        if (alreadyOnList.contains(media)) {
            System.out.println(media.getTitle() + " already exists on your list");
            mediaClient.displayMenu();
        }else {
            System.out.println(media.getTitle() + " has been added to your watch-later list");
            fileio.saveMediaData(media, this.pathWatchLater, "title, year, category, rating, seasons, episodes");
            mediaClient.displayMenu();
        }
    }

    public String getUsername() {
        return username;
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
