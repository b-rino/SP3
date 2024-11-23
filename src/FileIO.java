

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class FileIO {

    private String pathSeries = "data\\series.txt";
    private String pathMovie = "data\\movie.txt";
    private String pathUser = "data\\userdata.txt";
    private String pathCombi = "data\\allmedia.txt";

    //TODO Switch-case bør laves i denne metode
    public List<Media> readMediaData(enumPathing ePath) {
        String path = null;
        if(ePath == enumPathing.MOVIE )
            path = this.pathMovie;
        if (ePath == enumPathing.SERIES)
            path = this.pathSeries;
        if (ePath == enumPathing.COMBI)
            path = this.pathCombi;
        List<Media> mediaList = new ArrayList<>();
        File file = new File(path);
        try {
            Scanner scan = new Scanner(file);
            scan.nextLine();//skip header

            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                String[] splitData = line.split(";");

                if(ePath == enumPathing.MOVIE){
                    String title = splitData[0].trim();
                    int year = Integer.parseInt(splitData[1].trim());
                    String category = splitData[2].trim();
                    float rating = Float.parseFloat(splitData[3].trim());

                    Movie movie = new Movie(title, year, category, rating);
                    mediaList.add(movie);
                }
                if(ePath == enumPathing.SERIES){
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

    public static void saveData(List<String> items, String path, String header) {
        try {
            // Header should allow to split on ";".
            File file = new File(path);
            FileWriter writer = new FileWriter(path, true);
            if(file.length() == 0) {
                writer.write(header + "\n");
            }
            writer.write("\n");
            for (String s : items) {
                writer.write(String.join("; ",items ) + "\n");//"Title; year; genre; rating"
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("something went wrong when writing to file" + e.getMessage());
            e.printStackTrace();
        }
    }
    public List<String[]> readUserData(enumPathing ePath) {
        String path = null;
        if(ePath == enumPathing.USER )
            path = this.pathUser;
        List<String[]> data = new ArrayList<>();
        File file = new File(path);
        try {
            Scanner scan = new Scanner(file);
            scan.nextLine();//skip header

            while (scan.hasNextLine()) {
                String line = scan.nextLine();// "tess, 40000". Needs to split on ";" instead of comma
                String[] splitData = line.split(";");
                data.add(splitData);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File was not found");
        }
        return data;
    }
}
