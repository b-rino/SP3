import java.util.ArrayList;
import java.util.List;

public class MediaClient {
    private String name;
    List<User> users;
    User currentUser;
    String userDataPath;
    TextUI ui = new TextUI();
    FileIO io = new FileIO();

    public List<Media> loadAllMediaData(){
        List<Media> loadedData = io.readMediaData(enumPathing.COMBI);
        return loadedData;
    }

    public void displayMenu() {
        ArrayList<String> options = new ArrayList<>();
        options.add("1. Search for a movie: ");
        options.add("2. Search for a series: ");
        options.add("3. Display your watched list: ");
        options.add("4. Display your saved list: ");
        options.add("5. Exit");

        for (int i = 0; i < options.size(); i++) {
            System.out.println(options.get(i));
        }

        int answer = ui.promptNumeric("Please choose a number ");

        switch (answer) {
            case 1:
            case 2:
                int choice = ui.promptNumeric("1. Search by title\n2. Search by category ");
                if (choice == 1)
                    searchByTitle();
                else if (choice == 2)
                    searchByCategory();
                else {
                    System.out.println("Invalid choice");
                    displayMenu();
                }
                break;
            case 3:
                // mediaAction.displayWatchAgain();
                break;
            case 4:
                displayWatchLater();
                break;
        }
    }
    public void searchByTitle() {

    }
    public void searchByCategory() {

    }

    public void displayWatchLater() {

    }
}
