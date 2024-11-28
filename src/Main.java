import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        UserClient userClient = new UserClient();
        User currentUser = userClient.login();
        MediaClient mediaclient = new MediaClient(currentUser);
        mediaclient.displayMenu();
    }
}
