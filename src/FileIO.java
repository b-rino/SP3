import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileIO {
    private String pathUser = "data//userdata.txt";
    private String pathWatchAgain;
    private String pathWatchLater;
    private String pathSeries = "data//series.txt";
    private String pathMovie = "data//movie.txt";
    private String pathCombi = "data//allmedia.txt";


    //TODO: Hvorfor give en path, når den altid er den samme?
    public List<User> readUserData(enumPathing ePath) {
        String path = this.pathUser;
        List<User> userData = new ArrayList<>();
        File file = new File(path);
        try {
            Scanner scan = new Scanner(file);
            scan.nextLine();//skip header

            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                String[] splitData = line.split(";");
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

    //TODO: Hvorfor give en path, når den altid er den samme?
    public void saveUserData(List<User> userData, enumPathing ePath, String header) {
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


    public List<Media> readMediaData(String path, User user) {
        String usernamePath = user.getUsername();
        String actualPath = null;
        switch (path) {
            case "movie":
                actualPath = this.pathMovie;
                break;
            case "series":
                actualPath = this.pathSeries;
                break;
            case "combi":
                actualPath = this.pathCombi;
                break;
            case "watchAgain":
                actualPath = "data//" + usernamePath + "WatchAgain.txt";
                break;
            case "watchLater":
                actualPath = "data//" + usernamePath + "WatchLater.txt";
                break;
        }
        List<Media> mediaList = new ArrayList<>();
        File file = new File(actualPath);

        // Debugging the file path
        //System.out.println("Reading from file: " + actualPath);

        try {
            Scanner scan = new Scanner(file);
            scan.nextLine();//skip header

            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                String[] splitData = line.split(";");

                if(splitData.length == 4 && (path.equals("movie") || path.equals("combi")|| path.equals("watchAgain") || path.equals("watchLater"))) {
                    String title = splitData[0].trim();
                    int year = Integer.parseInt(splitData[1].trim());
                    String category = splitData[2].trim();
                    float rating = Float.parseFloat(splitData[3].trim());

                    Movie movie = new Movie(title, year, category, rating);
                    mediaList.add(movie);
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
           // scan.close();
        } catch (FileNotFoundException e) {
            System.out.println("File was not found");
        }
        return mediaList;
    }


    public void saveMediaData(List<Media> items, String path, String header) {
        try {
            FileWriter writer = new FileWriter(path, true);
            if(new File(path).length() == 0) {
                writer.write(header + "\n");
            }
            for (Media media : items) {
                writer.write(media.toString() + "\n");//"Title; year; genre; rating; Seasons; Episodes"
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("something went wrong when writing to file");
        }
    }

}