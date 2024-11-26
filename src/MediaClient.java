import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MediaClient {
    private String name;
    private List<User> users;
    private String userDataPath;
    private TextUI ui = new TextUI();
    private FileIO io = new FileIO();
    private List<Media> allMedia = io.readMediaData(enumPathing.COMBI);
    private List<Media> movie = io.readMediaData(enumPathing.MOVIE);
    private List<Media> series  = io.readMediaData(enumPathing.SERIES);
    private User currentUser;

    public MediaClient(User currentUser) {
        this.currentUser = currentUser;
    }

    public void displayMenu() {
        ArrayList<String> options = new ArrayList<>();
        options.add("1. Search for content: ");
       // options.add("2. Search for a series: ");
        options.add("2. Display your watched list: ");
        options.add("3. Display your saved list: ");
        options.add("4. Exit");

        for (int i = 0; i < options.size(); i++) {
            System.out.println(options.get(i));
        }

        int answer = ui.promptNumeric("Please choose a number ");

        switch (answer) {
            case 1:
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
            case 2:
                // mediaAction.displayWatchAgain();
                break;
            case 3:
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
                    currentUser.addToWatchAgain(media);
                System.out.println(media.getTitle() + " has been added to you watched list");
                // TODO: If Y add to watchAgain
                if (selection.equalsIgnoreCase("N"))
                    // TODO: Prompt user for another search or back to menu
                    // System.out.println("Do you want to search for a different title or return to menu? ");
                    searchByTitle();
            }
        }
    }
    public void searchByCategory() {
        List<Media> chosenCategory = new ArrayList<>();
        String answer = ui.promptText("Please enter a category: ");
        for (Media media : allMedia) {
            String[] categories = media.getCategory().split(", ");
            for (String category : categories) {
                if (category.equalsIgnoreCase(answer)) {
                    chosenCategory.add(media);
                }
            }
        }

        for (int i = 0; i < chosenCategory.size(); i++) {
            Media media = chosenCategory.get(i);
            System.out.println((i + 1) +": " + media.getTitle());
        }

        int selection = ui.promptNumeric("Please type the number of the movie or series you want to watch");
        System.out.println("You are now watching " + chosenCategory.get(selection-1).getTitle());
                currentUser.addToWatchAgain(chosenCategory.get(selection-1));
                System.out.println(chosenCategory.get(selection-1).getTitle() + " has been added to you watched list");
    }


    public void displayWatchLater() {
        List<Media> watchLaterList = io.readMediaData(enumPathing.COMBI);
    }

    public void displayWatchAgain() {
        List<Media> watchAgainList = io.readMediaData();
    }

    public User getCurrentUser() {
        return currentUser;
    }
}
