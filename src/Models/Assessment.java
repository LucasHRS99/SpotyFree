package Models;

public class Assessment {
    private int grade;

    public Assessment(int grade){
        this.grade = grade;
    }

    public static Assessment parse(String text){
        int grade = Integer.parseInt(text);
        return new Assessment(grade);
    }

    public int getGrade() {
        return grade;
    }
}
