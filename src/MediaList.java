import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class MediaList {

    private List<Media> mediaList;

    public MediaList() {
        this.mediaList = new ArrayList<>();
    }

    public void playMedia(Media media) {
        // todo skal fortælle user at der afspilles et medie tilfæj til watched media (lav en ny liste af sete film)
    }

    public void saveToWatchLater(){
        // todo skal gennem i en ny fil hos brugern
    }

    public void removeFromWatchLater(){
        //todo skal fjerne et medie fra filen
    }

    public void searchByCategory(String category){
        //todo skal søge i medialisten på kategoti
    }

    public void searchByTitle(String title){
        // todo skal kunne søge efter en film i media
    }

    public void displayWatchAgain(){
        // todo skal kunne hente fra filen der er gemt af sete film
    }

    public void displayWatchLater(){
        // todo skal vise users liste
    }

    public static void welcome(){
        String welcometext = "Welcome to Chill";
        JOptionPane.showMessageDialog(null, welcometext);
    }
}