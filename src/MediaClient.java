import java.util.ArrayList;
import java.util.List;

public class MediaClient {
    private String name;
    List<User> users;
    User currentUser;
    String userDataPath;
    TextUI ui = new TextUI();
    FileIO io = new FileIO();
    List<Media> allMedia = io.readMediaData(enumPathing.COMBI);
    User user;

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
        String answer = ui.promptText("Please enter a title: ");
        for (Media media : allMedia) {
            if (media.getTitle().equalsIgnoreCase(answer)) {
                String selection = ui.promptText("Do you want to watch? " + media.getTitle() + " Y / N");
                // TODO: Should this be made in playMedia method indstead?
                if (selection.equalsIgnoreCase("Y"))
                    System.out.println("You're now watching " + media.getTitle());

                // TODO: If Y add to watchAgain
                else if (selection.equalsIgnoreCase("N"))
                    // TODO: Prompt user for another search or back to menu
                    // System.out.println("Do you want to search for a different title or return to menu? ");
                    searchByTitle();
            }
        }
    }
    public void searchByCategory() {

    }

    public void displayWatchLater() {

    }
}
