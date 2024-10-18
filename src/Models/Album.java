package Models;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;

public class Album implements Assessable {
    private List<Music> albumMusics = new ArrayList<Music>();
    private List<Assessment> albumGrades = new ArrayList<Assessment>();

    private String albumName;
    private double average;

    public String getAlbumName() {
        return albumName;
    }

    public double getAverage() {
        return average;
    }

    public void calcAverage(){
        OptionalDouble optinalAvgGrades = albumGrades.stream()
                .mapToInt(Assessment::getGrade)
                .average();

        this.average = optinalAvgGrades.isPresent() ? optinalAvgGrades.getAsDouble() : 0;
    }

    public Album(String albumName){
        this.albumName = albumName;
    }

    public void addMusic(Music music){
        albumMusics.add(music);
    }

    public void addGrade(Assessment grade){
        albumGrades.add(grade);
    }

    public void showMusicsAlbum(){
        System.out.println("Musicas do Album");
        albumMusics.forEach(music -> System.out.println("Musica: " + music.getMusicName()));
    }

}
