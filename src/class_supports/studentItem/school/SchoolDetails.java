package class_supports.studentItem.school;

import class_supports.studentItem.personal.Date;

public class SchoolDetails {
    private Classroom assignedClassroom;
    private Course course;
    private String status;
    private Date entryDate;

    public SchoolDetails(Classroom assignedClassroom, Course course, String status, Date entryDate) {
        this.assignedClassroom = assignedClassroom;
        this.course = course;
        this.status = status;
        this.entryDate = entryDate;
    }

    public Classroom getAssignedClassroom() {
        return this.assignedClassroom;
    }

    public Course getCourse() {
        return this.course;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getEntryDate() {
        return this.entryDate;
    }
}
