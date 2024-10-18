package Models;
import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;

public class Artist implements Assessable{
    private List<Album> artistAlbuns = new ArrayList<Album>();
    private List<Music> singleMusics = new ArrayList<Music>();
    private List<Assessment> artistGrades = new ArrayList<Assessment>();
    private String artistName;
    private double average;

    public String getArtistName() {
        return artistName;
    }

    public List<Album> getArtistAlbuns() {
        return artistAlbuns;
    }

    public void calcAverage() {
        OptionalDouble optinalAvgGrades = artistGrades.stream()
                .mapToInt(Assessment::getGrade)
                .average();

        this.average = optinalAvgGrades.isPresent() ? optinalAvgGrades.getAsDouble() : 0;
    }

    public double getAverage() {
        return average;
    }

    public Artist(String artistName){
        this.artistName = artistName;
    }

    public void addAlbum(Album album){
        artistAlbuns.add(album);
    }

    public void addGrade(Assessment grade){
        artistGrades.add(grade);
    }

    public void addMusic(Music music){
        singleMusics.add(music);
    }


    public Album getAlbum(String albumName){
       return artistAlbuns.stream()
                .filter(a -> a.getAlbumName().equals(albumName))
                .findFirst().orElse(null);
    }

    public boolean musicAlreadyExist(String musicName){
        return singleMusics.stream()
                .anyMatch(m -> m.getMusicName().equals(musicName));
    }

    public boolean albumAlreadyExist(String albumName){
        return artistAlbuns.stream()
                .anyMatch(a -> a.getAlbumName().equals(albumName));
    }


}
