import java.util.ArrayList;

public class Media {
    private String title;
    private int releaseYear;
    private String category;
    private float rating;

    public Media(String title, int releaseYear, String category, float rating) {
        this.title = title;
        this.releaseYear = releaseYear;
        this.category = category;
        this.rating = rating;
    }


    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return title + "; " + releaseYear + "; " + category +"; " + rating;
    }
}


