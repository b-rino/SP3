public class Series extends Media {

    private String title;
    private int year;
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
    public String getMediaDetails(Media media) {
        return super.getMediaDetails(media) + this.seasons + this.episodes;
    }

    public void setSeasons(int seasons) {
        this.seasons = seasons;
    }

    public void setEpisodes(int episodes) {
        this.episodes = episodes;
    }

    public int getSeasons() {
        return seasons;
    }

    public int getEpisodes() {
        return episodes;
    }
}
