package class_supports.studentItem.school;

public class Classroom {
    private String letter;
    private int number;

    public Classroom(String letter, int number) {
        this.letter = letter.toUpperCase();
        this.number = number;
    }

    public String getLetter() {
        return this.letter;
    }

    public void setLetter(String letter) {
        this.letter = letter;
    }

    public int getNumber() {
        return this.number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getClassroom() {
        return letter + number;
    }
}
