import java.util.ArrayList;
import java.util.List;

public class Movie extends Media{

    private String title;
    private int releaseYear;
    private String category;
    private float rating;

    public Movie(String title, int releaseYear, String category, float rating) {
        super(title, releaseYear, category, rating);
    }

    public String getMediaDetails(Media media) {
        return super.getMediaDetails(media);
    }


}
