import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

       /*
       //Test af at skrive til alle Media txt --- VIRKER
        FileIO io = new FileIO();
        List<Media> movieList = new ArrayList<>();
        List<Media> seriesList = new ArrayList<>();
        List<Media> combiList = new ArrayList<>();
        List<Media> watchedList = new ArrayList<>();
        Movie movie = new Movie("Benjas Revenge", 2000, "COMEDY", 8);
        Series series = new Series("Benjas comeback", 2001, "COMEDY", 9, 22, 39);
        movieList.add(movie);
        seriesList.add(series);
        combiList.add(movie);
        combiList.add(series);
        watchedList.add(movie);
        watchedList.add(series);
        io.saveMediaData(movieList, enumPathing.MOVIE, "Title, Year, Category, Rating");
        io.saveMediaData(seriesList, enumPathing.SERIES, "Title, Year, Category, Rating, Seasons, Episodes");
        io.saveMediaData(combiList, enumPathing.COMBI, "Title, Year, Category, Rating, Seasons, Episodes");
        io.saveMediaData(watchedList, enumPathing.WATCHAGAIN, "Title, Year, Category, Rating, Seasons, Episodes");

        */




        /*
        //Test af at læse fra de forskellige Media txt --- VIRKER
        FileIO io = new FileIO();
        List<Media> newMedia = io.readMediaData(enumPathing.MOVIE);
        for (Media media : newMedia) {
            System.out.println(media);
        }
        */




        //Test af at skrive til userdata --- VIRKER
        /*
        FileIO io = new FileIO();
        List<UserList> users = new ArrayList<>();
        UserList user = new UserList("BingoHEJHEJ", "cannotremember");
        UserList user2 = new UserList("BingoBYEBYE", "STILLcannotremember");
        users.add(user);
        users.add(user2);
        io.saveUserData(users, enumPathing.USER, "username, password");
        */



        //Test af at læse fra userdata.txt --- VIRKER
        /*
        FileIO io = new FileIO();
        List<UserList> users = io.readUserData(enumPathing.USER);
        for (UserList user : users) {
            System.out.println(user);
        }
        */

    }
}
