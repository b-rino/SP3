import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MediaIO implements FileIO<Media>{

    private String pathSeries = "data\\series.txt";
    private String pathMovie = "data\\movie.txt";
    private String pathCombi = "data\\allmedia.txt";

    public List<Media> readData(enumPathing ePath) {
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
        }
        List<Media> mediaList = new ArrayList<>();
        File file = new File(path);
        try {
            Scanner scan = new Scanner(file);
            scan.nextLine();//skip header

            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                String[] splitData = line.split(";");

                //Mangler Combi. kan fixes med If statement
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

    public void saveData(List<Media> items, enumPathing ePath, String header) {
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
        }
        try {
            FileWriter writer = new FileWriter(path, true);
            if(new File(path).length() == 0) {
                writer.write(header + "\n");
            }
            writer.write("\n");
            for (Media media : items) {
                writer.write(media.toString() + "; ");//"Title; year; genre; rating"
            }

            writer.close();
        } catch (IOException e) {
            System.out.println("something went wrong when writing to file");
        }
    }
}
