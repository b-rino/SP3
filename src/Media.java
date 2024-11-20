public class Media {
    private String title;
    private int year;
    private String category;
    private float rating;

    public Media(String title, int year, String category, float rating) {
        this.title = title;
        this.year = year;
        this.category = category;
        this.rating = rating;
    }

    public String getMediaDetails(Media media) {
        return this.title + this.year + this. category + this.rating;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    public String getCategory() {
        return category;
    }

    public float getRating() {
        return rating;
    }
}
