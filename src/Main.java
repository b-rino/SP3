import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        FileIO fileIO = new FileIO();
        List<String[]> test = fileIO.readMediaData(enumPathing.COMBI);
        for (String[] entry : test) {
            System.out.println(String.join(", ", entry));
        }
    }
}
