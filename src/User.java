import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import java.io.File;


public class User {
    private String password;
    private String username;
    private List<Media> watchAgain = new ArrayList<>();
    private List<Media> watchLater = new ArrayList<>();
    private String path = "data//userdata.txt";
    private String pathWatchAgain;
    private String pathWatchLater;
    File fileWatchAgain;
    File fileWatchLater;

    public User(String username, String password) {
        // TODO: Set username, set password.
        this.username = username;
        this.password = password;
        //TODO opret ny fil hver gang der bliver oprettet en ny User
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
        // TODO: Potentially move to userClient so that we dont use fileIO here."
        List<Media> saved = watchAgain;
        saved.add(media);
        FileIO fileio = new FileIO();
        fileio.saveMediaData(saved, this.pathWatchAgain, "title, year, category, rating, seasons, episodes");
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
