import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        FileIO fileIO = new FileIO();
        List<Media> test = fileIO.readMediaData(enumPathing.SERIES);
        for (Media media : test) {
            System.out.println(media);
        }
    }
}
