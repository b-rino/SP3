import java.util.ArrayList;

public class Series extends Media {

    private String title;
    private int releaseYear;
    private String category;
    private float rating;
    private int seasons;
    private int episodes;

    public Series(String title, int releaseYear, String category, float rating, int seasons, int episodes) {
        super(title, releaseYear, category, rating);
        this.seasons = seasons;
        this.episodes = episodes;
    }

    @Override
    public String toString() {
        return super.toString() + "; " + seasons + "; " + episodes;
    }
}
