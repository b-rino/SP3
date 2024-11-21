import java.util.ArrayList;
import java.util.List;

public class MediaClient {
    private String name;
    List<Media> mediaList = new ArrayList<Media>(); // TODO: Settle on what collection to use.
    List<User> users;
    User currentUser;
    String userDataPath;
    TextUI ui;
    FileIO io;

    public MediaClient(String name, List<Media> mediaList, List<User> users, User currentUser, String userDataPath, TextUI ui, FileIO io) {
        this.name = name;
        this.mediaList = mediaList;
        this.users = users;
        this.currentUser = currentUser;
        this.userDataPath = userDataPath;
        this.ui = ui;
        this.io = io;
    }

    public void createMedia(String[] data){
        // Reading the file. Indexing and assigning datatypes.
        for (int i = 0; i < data.length; i++){
            String[] values = data[i].split(";");
            String title = values[0];
            int releaseYear = Integer.parseInt(values[1].trim());
            String category = values[2];
            float rating = Float.parseFloat(values[3].trim());
            int seasons = Integer.parseInt(values[4].trim());
            int episodes = Integer.parseInt(values[5].trim());

            // Creating objects. Media class is abstract - instantiate on subclasses
            // TODO: Figure out how we want to differentiate between media forms. If / else?
            Media series = new Series(title,releaseYear,category,rating,seasons,episodes);
            Media movie = new Movie(title,releaseYear,category,rating);
            mediaList.add(series);
            mediaList.add(movie);
        }
    }





    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Media> getMediaList() {
        return mediaList;
    }

    public void setMediaList(List<Media> mediaList) {
        this.mediaList = mediaList;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }

    public String getUserDataPath() {
        return userDataPath;
    }

    public void setUserDataPath(String userDataPath) {
        this.userDataPath = userDataPath;
    }

    public TextUI getUi() {
        return ui;
    }

    public void setUi(TextUI ui) {
        this.ui = ui;
    }

    public FileIO getIo() {
        return io;
    }

    public void setIo(FileIO io) {
        this.io = io;
    }

    @Override
    public String toString() {
        return "MediaClient{" +
                "name='" + name + '\'' +
                ", mediaList=" + mediaList +
                ", users=" + users +
                ", currentUser=" + currentUser +
                ", userDataPath='" + userDataPath + '\'' +
                ", ui=" + ui +
                ", io=" + io +
                '}';
    }
}
