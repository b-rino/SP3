

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class FileIO {

    public static List<String[]> readUserData(String path) {
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
    public static HashSet<mediaClient> readMediaData (String path){
        HashSet<String[]> mediaData = new HashSet<>();
        File file = new File(path);
        try {
            Scanner scan = new Scanner(file);
            scan.nextLine();//skip header

            while (scan.hasNextLine()) {
                String line = scan.nextLine();// "tess, 40000". Needs to split on ";" instead of comma
                String[] splitData = line.split(";");
            if (splitData.length >= 6) {
                String title = splitData[0].trim();
                int year = Integer.parseInt(splitData[1].trim());
                String category = splitData[2].trim();
                double rating = Double.parseDouble(splitData[3].trim());
                int seasons = Integer.parseInt(splitData[4].trim());
                int episodes = Integer.parseInt(splitData[5].trim());
                // lavet ved hjælp af chat og matador i matador havde vi ingen abstrakte klasser

                Media mediaClient = new Media(title,year,category,rating,seasons,episodes);
                mediaData.add(mediaClient);
                // løsningen kan være at lave det via. mediaclienten og ikke den abstrate media klasse

            }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File was not found");
        }

        return mediaData;
        // vi kan ikke lave objekter af Media, fordi den er abstrakt klasse..
    }

}
