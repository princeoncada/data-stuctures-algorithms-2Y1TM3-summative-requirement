package a_tests;

import class_supports.Student;
import class_supports.studentItem.personal.Date;
import class_supports.studentItem.personal.Name;
import class_supports.studentItem.personal.PersonalDetails;
import class_supports.studentItem.school.Classroom;
import class_supports.studentItem.school.Course;
import class_supports.studentItem.school.SchoolDetails;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

public class test {
    public static void main(String[] args) throws IOException {
        String path = "src\\data\\students.text";
        String[][] students = readCSV(path);
        for(String[] student: students){
//            System.out.println(student[0]);
//            System.out.println(student[1]);
//            System.out.println(student[2]);
//            System.out.println(student[3]);
//            System.out.println(student[4]);
//            System.out.println(student[5]);
//            System.out.println(student[6]);
//            System.out.println(student[7]);
//            System.out.println(student[8]);
//            System.out.println(student[9]);
//            System.out.println(student[10]);
//            System.out.println(student[11]);
//            System.out.println(student[12]);
//            System.out.println(student[13]);
//            System.out.println(student[14]);
//            System.out.println(student[15]);
//            System.out.println(student[16]);
//            System.out.println(student[17]);
//            System.out.println(student[18]);
//            System.out.println(student[19]);
//            System.out.println(student[20]);
//            System.out.println(student[21]);
//            System.out.println(student[22]);

            Name nameStudent = new Name(student[1], student[2], student[3]);
            String phoneStudent = student[4];
            String emailStudent = student[5];
            String genderStudent = student[6];
            Date birthStudent = new Date(
                    Integer.parseInt(student[7]),
                    Integer.parseInt(student[8]),
                    Integer.parseInt(student[9])
            );
            String nationalityStudent = student[10];
            PersonalDetails personalStudent = new PersonalDetails(
                    nameStudent,
                    phoneStudent,
                    emailStudent,
                    genderStudent,
                    birthStudent,
                    nationalityStudent
            );

            Classroom classroomStudent = new Classroom(student[11], Integer.parseInt(student[12]));
            Course courseStudent = new Course(student[13], Integer.parseInt(student[14]));
            String statusStudent = student[15];
            Date entryStudent = new Date(
                    Integer.parseInt(student[16]),
                    Integer.parseInt(student[17]),
                    Integer.parseInt(student[18])
            );
            SchoolDetails schoolStudent = new SchoolDetails(
                    classroomStudent,
                    courseStudent,
                    statusStudent,
                    entryStudent
            );

            Name emergencyName = new Name(student[19], student[20], student[21]);
            String phoneEmergency = student[22];
            PersonalDetails emergencyStudent = new PersonalDetails(emergencyName, phoneEmergency);

            Student studentObject = new Student(Integer.parseInt(student[0]), personalStudent, schoolStudent, emergencyStudent);
        }
    }

    public static String[][] readCSV(String path) throws FileNotFoundException, IOException {
        try (FileReader fr = new FileReader(path);
            BufferedReader br = new BufferedReader(fr)) {
            LinkedList<Object> students = new LinkedList<>();
            for (String line = br.readLine(); line != null; line = br.readLine()) {
                students.add(line.split(","));
            }
            return students.toArray(new String[students.size()][]);
        }
    }
}
