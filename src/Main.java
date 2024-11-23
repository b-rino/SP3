import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        /*
        FileIO fileIO = new FileIO();
        List<Media> test = fileIO.readMediaData(enumPathing.SERIES);
        for (Media media : test) {
            System.out.println(media);
        }
         */

        MediaList.welcome();
        User user = new User();
        user.createUser();
        //user.login();
    }

}

