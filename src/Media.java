import java.util.ArrayList;

public class Media {
    private String title;
    private int releaseYear;
    private String category;
    private float rating;
    private FileIO fileIO;

    public Media(String title, int releaseYear, String category, float rating) {
        this.title = title;
        this.releaseYear = releaseYear;
        this.category = category;
        this.rating = rating;
    }

    public String getMediaDetails(Media media) {
        return this.title + this.releaseYear + this.category + this.rating;
    }


    public void setTitle(String title) {
        this.title = title;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public void setCategory(String category) {
        this.category = category;
    }


    public String getTitle() {
        return title;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public String getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return "Title: " + title + ", Year: " + releaseYear + ", Category: " + category + ", Rating: " + rating;
    }
}


