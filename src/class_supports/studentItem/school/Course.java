package class_supports.studentItem.school;

public class Course {
    private String course;
    private int yearLevel;

    public Course(String course, int yearLevel) {
        this.course = course.toUpperCase();
        this.yearLevel = yearLevel;
    }

    public String getCourse() {
        return this.course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public int getYearLevel() {
        return this.yearLevel;
    }

    public void setYearLevel(int yearLevel) {
        this.yearLevel = yearLevel;
    }

    public String yearLevelToString() {
        String yearLevelString = "";
        switch(yearLevel) {
            case 1 -> yearLevelString = "1st Year";
            case 2 -> yearLevelString = "2nd Year";
            case 3 -> yearLevelString = "3rd Year";
            case 4 -> yearLevelString = "4th Year";
        }
        return yearLevelString;
    }

    public String getCourseYearLevel() {
        return course + "-" + yearLevelToString();
    }
}
