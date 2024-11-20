public class Movie extends Media{

    private String title;
    private int year;
    private String category;
    private float rating;

    public Movie(String title, int year, String category, float rating) {
        super(title, year, category, rating);
    }

    public String getMediaDetails(Media media) {
        return super.getMediaDetails(media);
    }


}
