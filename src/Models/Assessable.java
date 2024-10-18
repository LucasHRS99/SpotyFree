package Models;

public interface Assessable {
    double average = 0;
    void addGrade(Assessment grade);
    void calcAverage();
}
