import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileIO {

    private String pathUser = "data\\userdata.txt";
    private String pathWatchAgain = "data\\watchAgain.txt";
    private String pathWatchLater = "data\\watchLater.txt";
    private String pathSeries = "data\\series.txt";
    private String pathMovie = "data\\movie.txt";
    private String pathCombi = "data\\allmedia.txt";


    public List<UserList> readUserData(enumPathing ePath) {
        String path = this.pathUser;
        List<UserList> userData = new ArrayList<>();
        File file = new File(path);
        try {
            Scanner scan = new Scanner(file);
            scan.nextLine();//skip header

            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                String[] splitData = line.split(";");
                String username = splitData[0];
                String password = splitData[1];
                UserList user = new UserList(username, password);
                userData.add(user);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File was not found");
        }
        return userData;
    }


    public void saveUserData(List<UserList> userData, enumPathing ePath, String header) {
        String path = this.pathUser;
        try {
            FileWriter writer = new FileWriter(path, true);
            if(new File(path).length() == 0) {
                writer.write(header + "\n");
            }
            for (UserList user : userData) {
                writer.write(user.toString() + "\n");
            }

            writer.close();
        } catch (IOException e) {
            System.out.println("something went wrong when writing to file");
        }
    }


    public List<Media> readMediaData(enumPathing ePath) {
        String path = null;
        switch (ePath) {
            case MOVIE:
                path = this.pathMovie;
                break;
            case SERIES:
                path = this.pathSeries;
                break;
            case COMBI:
                path = this.pathCombi;
                break;
            case WATCHAGAIN:
                path = this.pathWatchAgain;
                break;
            case WATCHLATER:
                path = this.pathWatchLater;
                break;
        }
        List<Media> mediaList = new ArrayList<>();
        File file = new File(path);
        try {
            Scanner scan = new Scanner(file);
            scan.nextLine();//skip header

            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                String[] splitData = line.split(";");

                if(splitData.length == 4 && (ePath == enumPathing.MOVIE || ePath == enumPathing.COMBI || ePath == enumPathing.WATCHAGAIN || ePath == enumPathing.WATCHLATER)) {
                    String title = splitData[0].trim();
                    int year = Integer.parseInt(splitData[1].trim());
                    String category = splitData[2].trim();
                    float rating = Float.parseFloat(splitData[3].trim());

                    Movie movie = new Movie(title, year, category, rating);
                    mediaList.add(movie);
                }
                if(splitData.length  == 6 && (ePath == enumPathing.SERIES || ePath == enumPathing.COMBI|| ePath == enumPathing.WATCHAGAIN || ePath == enumPathing.WATCHLATER)){
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
        } catch (FileNotFoundException e) {
            System.out.println("File was not found");
        }
        return mediaList;
    }


    public void saveMediaData(List<Media> items, enumPathing ePath, String header) {
        String path = null;
        switch (ePath) {
            case MOVIE:
                path = this.pathMovie;
                break;
            case SERIES:
                path = this.pathSeries;
                break;
            case COMBI:
                path = this.pathCombi;
                break;
            case WATCHAGAIN:
                path = this.pathWatchAgain;
                break;
            case WATCHLATER:
                path = this.pathWatchLater;
                break;
        }
        try {
            FileWriter writer = new FileWriter(path, true);
            if(new File(path).length() == 0) {
                writer.write(header + "\n");
            }
            for (Media media : items) {
                writer.write(media.toString() + "\n");//"Title; year; genre; rating"
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("something went wrong when writing to file");
        }
    }

}