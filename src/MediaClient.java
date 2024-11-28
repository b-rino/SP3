import java.util.ArrayList;
import java.util.List;

public class MediaClient {
    private String name;
    private List<User> users;
    private String userDataPath;
    private TextUI ui = new TextUI();
    private FileIO io = new FileIO();
    private List<Media> allMedia;
    // Movie and series are currently redundant but saved for future expansion.
    private List<Media> movie;
    private List<Media> series;
    private User currentUser;

    // Reads the specific user's .txt file.
    public MediaClient(User currentUser) {
        this.currentUser = currentUser;
        allMedia = io.readMediaData("combi", currentUser);
        movie = io.readMediaData("movie", currentUser);
        series = io.readMediaData("series", currentUser);
    }

    public void displayMenu() {
        ArrayList<String> options = new ArrayList<>();
        System.out.println("\nMAIN MENU\n");
        options.add("1. Search for content: ");
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
                displayWatchAgain();
                break;
            case 3:
                displayWatchLater();
                break;
            case 4:
                System.out.println("Thank you for using CHILL");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid choice - please choose a number between 1 and 4");
                displayMenu();
        }
    }

    public void searchByTitle() {
        String answer = ui.promptText("Please enter a title: ");
        for (Media media : allMedia) {
            if (media.getTitle().equalsIgnoreCase(answer)) {
                int selection = ui.promptNumeric("You have chosen " + media.getTitle() +
                        "\n1. Watch media\n2. Save to watch later\n3. Main Menu");
                if (selection == 1) {
                    System.out.println("You're now watching " + media.getTitle());
                    currentUser.addToWatchAgain(media);
                    System.out.println(media.getTitle() + " has been added to your watched list");
                    displayMenu();
                }
                if (selection == 2) {
                    currentUser.addToWatchLater(media);

                    }
                if (selection == 3) {
                    displayMenu();
                }
            }
        }
    }

    public void searchByCategory() {
        List<Media> chosenCategory = new ArrayList<>();
        System.out.println("You can chose between: Comedy, Drama, Horror, Romance, Film-Noir, Adventure, Family, Fantasy, Thriller" +
                " Sport, Action, Biography, Western, History, Crime\n");
        String answer = ui.promptText("Please enter a category: ");
        for (Media media : allMedia) {
            String[] categories = media.getCategory().split(", ");
            for (String category : categories) {
                if (category.equalsIgnoreCase(answer)) {
                    chosenCategory.add(media);
                }
            }
        }
        if(chosenCategory.isEmpty()){
            System.out.println("Category " + answer + " not found" );
            searchByCategory();
        }
        for (int i = 0; i < chosenCategory.size(); i++) {
            Media media = chosenCategory.get(i);
            System.out.println((i + 1) +": " + media.getTitle());
        }

        int selection = ui.promptNumeric("Please type the number of the movie or series, you want to select");
        System.out.println("You have chosen " + chosenCategory.get(selection-1).getTitle());
                int selected = ui.promptNumeric("\n1. Watch media\n2. Save to watch later\n3. Main Menu");
                if (selected == 1){
                    System.out.println("You're now watching " + chosenCategory.get(selection-1).getTitle());
                    currentUser.addToWatchAgain(chosenCategory.get(selection-1));
                    System.out.println(chosenCategory.get(selection-1).getTitle() + " has been added to you watched list");
                    displayMenu();
                }
                else if(selected == 2){
                    currentUser.addToWatchLater(chosenCategory.get(selection-1));
                    System.out.println(chosenCategory.get(selection-1).getTitle() + " has been added to your watch-later list");
                    displayMenu();
                }
                else if(selected == 3){
                    displayMenu();
                }
                else {
                    System.out.println("Invalid choice");
                    displayMenu();
                }

                currentUser.addToWatchAgain(chosenCategory.get(selection-1));
                System.out.println(chosenCategory.get(selection-1).getTitle() + " has been added to you watched list");
    }


    public void displayWatchLater() {
        List<Media> watchLaterList = io.readMediaData("watchLater", currentUser);
        for (int i = 0; i < watchLaterList.size(); i++) {
            Media media = watchLaterList.get(i);
            System.out.println((i + 1) +": " + media.getTitle());
        }
        if(watchLaterList.isEmpty()){
            System.out.println("You have no current saved media");
            displayMenu();
        }
        int answer = ui.promptNumeric("Please type a number to select the media ");
        System.out.println("You have chosen " + watchLaterList.get(answer-1).getTitle());
        int choice = ui.promptNumeric("\n1. Watch media\n2. Main Menu");
        if (choice == 1){
            System.out.println("You're now watching " + watchLaterList.get(answer-1).getTitle());
            currentUser.addToWatchAgain(watchLaterList.get(answer-1));
            System.out.println(watchLaterList.get(answer-1).getTitle() + " has been added to you watched list");
            displayMenu();
        }
       else if (choice == 2) {
            displayMenu();
        }
       else {
           System.out.println("Invalid choice");
           displayMenu();
        }
    }

    public void displayWatchAgain() {
        List<Media> watchAgainList = io.readMediaData("watchAgain", currentUser);
        System.out.println("\nYou have previously watched: \n");
        for (int i = 0; i < watchAgainList.size(); i++) {
            Media media = watchAgainList.get(i);
            System.out.println((i + 1) +": " + media.getTitle());
        }
        if(watchAgainList.isEmpty()){
            System.out.println("You have no current saved media");
            displayMenu();
        }
        int answer = ui.promptNumeric("Please type a number to select the media ");
        System.out.println("You have chosen " + watchAgainList.get(answer-1).getTitle());
        int choice = ui.promptNumeric("\n1. Watch media\n2. Main Menu");
        if (choice == 1){
            System.out.println("You're now watching " + watchAgainList.get(answer-1).getTitle());
            displayMenu();
        }
        else if (choice == 2) {
            displayMenu();
        }
        else {
            System.out.println("Invalid choice");
            displayMenu();
        }
    }

    public User getCurrentUser() {
        return currentUser;
    }
}
