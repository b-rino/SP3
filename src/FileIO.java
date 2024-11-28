import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileIO {
    private String pathUser = "data//userdata.txt";
    private String pathSeries = "data//series.txt";
    private String pathMovie = "data//movie.txt";
    private String pathCombi = "data//allmedia.txt";


    // Method used for reading userdata .txt file.
    public List<User> readUserData() {
        String path = this.pathUser;
        List<User> userData = new ArrayList<>();
        File file = new File(path);
        try {
            Scanner scan = new Scanner(file);
            scan.nextLine();//skip header

            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                String[] splitData = line.split(";"); // Splits on semicolon to differentiate username/password
                String username = splitData[0].trim();
                String password = splitData[1].trim();
                User user = new User(username, password);
                userData.add(user);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File was not found");
        }
        return userData;
    }

    // For when creating a new user. Writes the username and password to .txt file.
    public void saveUserData(List<User> userData, String header) {
        String path = this.pathUser;
        try {
            FileWriter writer = new FileWriter(path, true);
            if(new File(path).length() == 0) {
                writer.write(header + "\n");
            }
            for (User user : userData) {
                writer.write(user.toString() + "\n");
            }

            writer.close();
        } catch (IOException e) {
            System.out.println("something went wrong when writing to file");
        }
    }

    // Method for reading .txt files.
    public List<Media> readMediaData(String path, User user) {
        String usernamePath = user.getUsername();
        String actualPath = null;
        // Sets file pathing for different .txt files.
        switch (path) {
            case "movie":
                actualPath = this.pathMovie;
                break;
            case "series":
                actualPath = this.pathSeries;
                break;
            case "combi":
                actualPath = this.pathCombi; // Primary list used throughout program
                break;
            case "watchAgain":
                actualPath = "data//" + usernamePath + "WatchAgain.txt"; // Creates file path based on user info
                break;
            case "watchLater":
                actualPath = "data//" + usernamePath + "WatchLater.txt"; // Creates file path based on user info
                break;
        }
        List<Media> mediaList = new ArrayList<>();
        File file = new File(actualPath);

        try {
            Scanner scan = new Scanner(file);
            if (scan.hasNextLine()) { // To avoid issue with empty file.
                scan.nextLine();//skip header
            }
            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                String[] splitData = line.split(";");

                // Splits on ; and assigns datatypes. Type of media created is based on pathing and number of indexes.
                if(splitData.length == 4 && (path.equals("movie") || path.equals("combi")|| path.equals("watchAgain") || path.equals("watchLater"))) {
                    String title = splitData[0].trim();
                    int year = Integer.parseInt(splitData[1].trim());
                    String category = splitData[2].trim();
                    float rating = Float.parseFloat(splitData[3].trim());

                    Movie movie = new Movie(title, year, category, rating);
                    mediaList.add(movie); // Adds media to the chosen list.
                }
                if(splitData.length  == 6 && (path.equals("series") || path.equals("combi")|| path.equals("watchAgain") || path.equals("watchLater"))){
                    String title = splitData[0].trim();
                    int year = Integer.parseInt(splitData[1].trim());
                    String category = splitData[2].trim();
                    float rating = Float.parseFloat(splitData[3].trim());
                    int season = Integer.parseInt(splitData[4].trim());
                    int episode = Integer.parseInt(splitData[5].trim());

                    Series series = new Series(title, year, category, rating, season, episode);
                    mediaList.add(series);
                }
            }
            scan.close();
        } catch (FileNotFoundException e) {
            System.out.println("File was not found");
        }
        return mediaList; // Returns list created based on chosen path, user and its content
    }

    // Our method for writing to our .txt files.
    public void saveMediaData(List<Media> items, String path, String header) {
        try {
            FileWriter writer = new FileWriter(path, true); // Secures that we don't overwrite
            if(new File(path).length() == 0) {
                writer.write(header + "\n");
            }
            for (Media media : items) {
                // Writing the modified toString with ; so that it works with our read method. 
                writer.write(media.toString() + "\n"); // "Title; year; genre; rating; Seasons; Episodes"
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("something went wrong when writing to file");
        }
    }

}