

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
            FileWriter writer = new FileWriter(path);
            writer.write(header + "\n");
            for (String s : items) {
                writer.write(s + "\n"); //"Title; year; genre; rating"
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("something went wrong when writing to file");
        }
    }


}
