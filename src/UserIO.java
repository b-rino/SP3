import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserIO implements FileIO<User> {

    private String pathUser = "data\\userdata.txt";



    public List<User> readData(enumPathing ePath) {
        String path = this.pathUser;
        List<User> userData = new ArrayList<>();
        File file = new File(path);
        try {
            Scanner scan = new Scanner(file);
            scan.nextLine();//skip header

            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                String[] splitData = line.split(";");
                String username = splitData[0];
                String password = splitData[1];
                User user = new User(username, password);
                userData.add(user);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File was not found");
        }
        return userData;
    }

    public void saveData(List<User> userData, enumPathing ePath, String header) {
        String path = this.pathUser;
        try {
            FileWriter writer = new FileWriter(path, true);
            if(new File(path).length() == 0) {
                writer.write(header + "\n");
            }
            writer.write("\n");
            for (User user : userData) {
                writer.write(user.toString() + "; ");
            }

            writer.close();
        } catch (IOException e) {
            System.out.println("something went wrong when writing to file");
        }
    }
}
