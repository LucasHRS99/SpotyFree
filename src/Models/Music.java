package Models;

import java.util.ArrayList;
import java.util.List;

public class Music {
    private List<Assessment> musicGrades = new ArrayList<Assessment>();

    private String name;
    private int duraction;
    private Artist artist;

    public Music(String name) {
        this.name = name;
    }

    public String getMusicName() {
        return name;
    }

    public int getDuraction() {
        return duraction;
    }

}