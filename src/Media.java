import java.util.Objects;

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

    public String getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return title + "; " + releaseYear + "; " + category +"; " + rating;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Media media = (Media) obj;
        return releaseYear == media.releaseYear && Double.compare(media.rating, rating) == 0 && Objects.equals(title, media.title) && Objects.equals(category, media.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, releaseYear, category, rating);
    }
}


