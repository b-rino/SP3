

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
    public List<String[]> readMediaData(enumPathing ePath) {
        String path = null;
        if(ePath == enumPathing.MOVIE )
            path = this.pathMovie;
        if (ePath == enumPathing.SERIES)
            path = this.pathSeries;
        if (ePath == enumPathing.COMBI)
            path = this.pathCombi;
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

    public static void saveData(List<String> items, String path, String header) {
        try {
            // Header should allow to split on ";".
            FileWriter writer = new FileWriter(path, true);
            if(new File(path).length() == 0) {
                writer.write(header + "\n");
            }
            writer.write("\n");
            for (String s : items) {
                writer.write(s + "; ");//"Title; year; genre; rating"
            }

            writer.close();
        } catch (IOException e) {
            System.out.println("something went wrong when writing to file");
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
