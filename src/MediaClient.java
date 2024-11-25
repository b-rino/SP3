import java.util.List;

public class MediaClient {
    private String name;
    List<User> users;
    User currentUser;
    String userDataPath;
    TextUI ui;
    FileIO io;

    public MediaClient(String name, List<User> users, User currentUser, String userDataPath, TextUI ui, FileIO io) {
        this.name = name;
        this.users = users;
        this.currentUser = currentUser;
        this.userDataPath = userDataPath;
        this.ui = ui;
        this.io = io;
    }

}
