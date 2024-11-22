import java.util.ArrayList;

public class Movie extends Media{

    private String title;
    private int releaseYear;
    private String category;
    private float rating;
    private String path = "data\\movie.txt";

    public Movie(String title, int releaseYear, String category, float rating) {
        super(title, releaseYear, category, rating);
    }

    public String getMediaDetails(Media media) {
        return super.getMediaDetails(media);
    }

    @Override
    public ArrayList<String> createMedia(String path){
        path = this.path;
    }


}
