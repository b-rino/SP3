import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        MediaIO mediaIO = new MediaIO();
        UserIO userIO = new UserIO();
        List<User> userTest = userIO.readData(enumPathing.USER);
        List<Media> mediaTest = mediaIO.readData(enumPathing.MOVIE);
        for (Media media : mediaTest) {
            System.out.println(media);
        }
      for (User user : userTest) {
            System.out.println(user);
        }
    }
}
