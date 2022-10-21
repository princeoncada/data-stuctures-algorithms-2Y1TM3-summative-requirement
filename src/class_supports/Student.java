package class_supports;

import java.util.Arrays;
import java.util.stream.Collectors;

import class_supports.studentItem.personal.Name;
import class_supports.studentItem.personal.PersonalDetails;
import class_supports.studentItem.school.SchoolDetails;

public class Student{
    private final int idNum;
    private PersonalDetails personalDetails;
    private SchoolDetails schoolDetails;
    private PersonalDetails emergencyContactDetails;

    public Student(int idNum, PersonalDetails personalDetails,
                   SchoolDetails schoolDetails, PersonalDetails emergencyContactDetails) {

        this.idNum = idNum;
        this.personalDetails = personalDetails;
        this.schoolDetails = schoolDetails;
        this.emergencyContactDetails = emergencyContactDetails;
    }

    /**
     * para nice pud caps StriNG > String
     * 
     */
    private static String capitalizeEachWordFirst(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }

        return Arrays.stream(str.split("\\s+")).map(t -> t.substring(0, 1).toUpperCase() + t.substring(1).toLowerCase())
                .collect(Collectors.joining(" "));
    }




    public int getIdNum() {
        return this.idNum;
    }

// NAMES FUNCTIONS

    public Name getName() {
        return personalDetails.getName();
    }

    public String getFirstName() {
        return personalDetails.getName().getFirstName();
    }

    public String getMiddleInitial() {
        return personalDetails.getName().getMiddleInitial();
    }

    public String getLastName() {
        return personalDetails.getName().getLastName();
    }

    public String getFullName() {
        return capitalizeEachWordFirst(personalDetails.getName().getFullName());
    }

    public void setFirstName(String firstName) {
        personalDetails.getName().setFirstName(firstName);
    }

    public void setMiddleInitial(String middleInitial) {
        personalDetails.getName().setMiddleInitial(middleInitial);
    }

    public void setLastName(String lastName) {
        personalDetails.getName().setLastName(lastName);
    }

// PHONE FUNCTIONS

    public String getPhoneNumber() {
        return personalDetails.getPhoneNumber();
    }

    public void setPhoneNumber(String phoneNumber) {
        personalDetails.setPhoneNumber(phoneNumber);
    }

// EMAIL FUNCTIONS

    public String getEmail() {
        return capitalizeEachWordFirst(personalDetails.getEmail());
    }

    public void setEmail(String email) {
        personalDetails.setEmail(email);
    }

// SEX FUNCTIONS

    public String getSex() {
        return personalDetails.getSex();
    }

    public void setSex(String sex) {
        personalDetails.setSex(sex);
    }

// BIRTHDATE FUNCTIONS

    public String getBirthDate() {
        return personalDetails.getBirthDate().getDate();
    }

    public int getBirthDay() {
        return personalDetails.getBirthDate().getDay();
    }

    public int getBirthMonth() {
        return personalDetails.getBirthDate().getMonth();
    }

    public int getBirthYear() {
        return personalDetails.getBirthDate().getYear();
    }

    public void setBirthDay(int day) {
        personalDetails.getBirthDate().setDay(day);
    }

    public void setBirthMonth(int month) {
        personalDetails.getBirthDate().setMonth(month);
    }

    public void setBirthYear(int year) {
        personalDetails.getBirthDate().setYear(year);
    }

// NATIONALITY FUNCTIONS

    public String getNationality() {
        return personalDetails.getNationality();
    }

    public void setNationality(String nationality) {
        personalDetails.setNationality(nationality);
    }

// CLASSROOM FUNCTIONS

    public String getClassroom() {
        return schoolDetails.getAssignedClassroom().getClassroom();
    }

    public String getClassroomLetter() {
        return capitalizeEachWordFirst(schoolDetails.getAssignedClassroom().getLetter());
    }

    public int getClassroomNumber() {
        return schoolDetails.getAssignedClassroom().getNumber();
    }

    public void setClassroomLetter(String letter) {
        schoolDetails.getAssignedClassroom().setLetter(letter);
    }

    public void setClassroomNumber(int number) {
        schoolDetails.getAssignedClassroom().setNumber(number);
    }

// COURSE FUNCTIONS

    public String getCourseYearLevel() {
        return schoolDetails.getCourse().getCourseYearLevel();
    }

    public String getCourse() {
        return schoolDetails.getCourse().getCourse();
    }

    public String getYearLevelString() {
        return schoolDetails.getCourse().yearLevelToString();
    }

    public int getYearLevel() {
        return schoolDetails.getCourse().getYearLevel();
    }

    public void setCourse(String course) {
        schoolDetails.getCourse().setCourse(course);
    }

    public void setYearLevel(int level) {
        schoolDetails.getCourse().setYearLevel(level);
    }

// STATUS FUNCTIONS

    public String getStatus() {
        return schoolDetails.getStatus();
    }

    public void setStatus(String status) {
        schoolDetails.setStatus(status);
    }

// ENTRYDATE FUNCTIONS

    public String getEntryDate() {
        return schoolDetails.getEntryDate().getDate();
    }

    public int getEntryDay() {
        return schoolDetails.getEntryDate().getDay();
    }

    public int getEntryMonth() {
        return schoolDetails.getEntryDate().getMonth();
    }

    public int getEntryYear() {
        return schoolDetails.getEntryDate().getYear();
    }

    public void setEntryDay(int day) {
        schoolDetails.getEntryDate().setDay(day);
    }

    public void setEntryMonth(int month) {
        schoolDetails.getEntryDate().setMonth(month);
    }

    public void setEntryYear(int year) {
        schoolDetails.getEntryDate().setYear(year);
    }

// EMERGENCY NAME FUNCTIONS

    public Name getEmergencyName() {
        return emergencyContactDetails.getName();
    }

    public String getEmergencyFirstName() {
        return emergencyContactDetails.getName().getFirstName();
    }

    public String getEmergencyMiddleInitial() {
        return emergencyContactDetails.getName().getMiddleInitial();
    }

    public String geEmergencytLastName() {
        return emergencyContactDetails.getName().getLastName();
    }

    public String getEmergencyFullName() {
        return capitalizeEachWordFirst(emergencyContactDetails.getName().getFullName());
    }

    public void setEmergencyFirstName(String firstName) {
        emergencyContactDetails.getName().setFirstName(firstName);
    }

    public void setEmergencyMiddleInitial(String middleInitial) {
        emergencyContactDetails.getName().setMiddleInitial(middleInitial);
    }

    public void setEmergencyLastName(String lastName) {
        emergencyContactDetails.getName().setLastName(lastName);
    }

// EMERGENCY PHONE FUNCTIONS

    public String getEmergencyPhoneNumber() {
        return emergencyContactDetails.getPhoneNumber();
    }

    public void setEmergencyPhoneNumber(String phoneNumber) {
        emergencyContactDetails.setPhoneNumber(phoneNumber);
    }

// PROPERTIES FUNCTIONS

    public PersonalDetails getPersonalDetails() {
        return this.personalDetails;
    }

    public SchoolDetails getSchoolDetails() {
        return this.schoolDetails;
    }

    public PersonalDetails getEmergencyContactDetails() {
        return this.emergencyContactDetails;
    }
}