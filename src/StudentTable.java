import class_supports.Student;
import class_supports.StudentList;
import class_supports.studentItem.personal.Date;
import class_supports.studentItem.personal.Name;
import class_supports.studentItem.personal.PersonalDetails;
import class_supports.studentItem.school.Classroom;
import class_supports.studentItem.school.Course;
import class_supports.studentItem.school.SchoolDetails;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Cursor;

import java.io.*;

import java.util.LinkedList;
import java.util.List;

public class StudentTable extends JFrame  {
    private JTable tblStudents;
    private TableRowSorter sorter;
    private DefaultTableModel model;
    private JTextField txtSearch;
    private JLabel lblSearch;
    private JButton btnAdd;
    private JButton btnEdit;
    private JButton btnDelete;
    private JButton btnExit;
    public int selectedRow = -1;
    public Student currentStudent;
    public StudentList students;
    String path = "src\\data\\students.text";
    StudentTable() throws IOException {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Student Frame");
        setSize(900, 510);
        setLayout(null);
        setVisible(true);

        students = new StudentList();
        String[][] studentsString = readCSV(path);
        for(String[] student: studentsString){
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

            students.add(studentObject);
        }

        String[] columnNames = {"ID Number", "Student Name", "Course"};
        Object[][] dataTable = new Object[students.size()][3];
        int itr = 0;
        for (Student item : students) {
            dataTable[itr][0] = item.getIdNum();
            dataTable[itr][1] = item.getFullName();
            dataTable[itr][2] = item.getCourseYearLevel();
            itr++;
        }

        model = new DefaultTableModel(dataTable, columnNames);
        sorter = new TableRowSorter<>(model);


        tblStudents = new JTable(model) { //Disable Cell Editing 
            public boolean editCellAt(int row, int column, java.util.EventObject e) {
                return false;
            }
        };
        tblStudents.setRowSorter(sorter);


        lblSearch = new JLabel("Search:");
        txtSearch = new JTextField();


        JScrollPane scrollPane = new JScrollPane(tblStudents);
        
        add(lblSearch).setBounds(200, 0, 50, 20);
        add(txtSearch).setBounds(250, 0, 250, 20);
        add(scrollPane).setBounds(20,30,700,420);


        btnAdd = new JButton("Add");
        btnEdit = new JButton("Edit");
        btnDelete = new JButton("Delete");
        btnExit = new JButton("Exit");


        btnAdd.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnEdit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnDelete.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnExit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));


        add(btnAdd).setBounds(740,30,125,30);
        add(btnEdit).setBounds(740,70,125,30);
        add(btnDelete).setBounds(740,110,125,30);
        add(btnExit).setBounds(740,150,125,30);


        txtSearch.getDocument().addDocumentListener(new DocumentListener(){
            @Override
            public void insertUpdate(DocumentEvent e) {
                search(txtSearch.getText());
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                search(txtSearch.getText());
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                search(txtSearch.getText());
            }

            public void search(String str) throws IndexOutOfBoundsException{
                if (str.length() == 0) {
                   sorter.setRowFilter(null);
                } else {
                   sorter.setRowFilter(RowFilter.regexFilter(str));
                }
             }
        });

        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(btnAdd.getModel().isArmed()){
                    setVisible(false);
                    new StudentFrameAdd();
                    dispose();
                }
            }
        });

        btnEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(btnEdit.getModel().isArmed()){
                    if(selectedRow == -1){
                        JOptionPane.showMessageDialog(null, "Choose a student to edit", "Error", JOptionPane.ERROR_MESSAGE);
                    }else {
                        setVisible(false);
                        new StudentFrameEdit(currentStudent, students);
                        dispose();
                    }
                }
            }
        });

        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(btnDelete.getModel().isArmed()) {
                    if(selectedRow == -1){
                        System.out.println("Cant delete");
                    }else {
                        students.remove(selectedRow);

                        try {
                            FileWriter csvWriter = new FileWriter("src\\data\\students.text");

                            for(Student studentObject: students){
                                List<String> studentString = List.of(
                                        studentObject.getIdNum()+"",
                                        studentObject.getFirstName(),
                                        studentObject.getMiddleInitial(),
                                        studentObject.getLastName(),
                                        studentObject.getPhoneNumber()+"",
                                        studentObject.getEmail(),
                                        studentObject.getSex(),

                                        studentObject.getBirthMonth()+"",
                                        studentObject.getBirthDay()+"",
                                        studentObject.getBirthYear()+"",

                                        studentObject.getNationality(),
                                        studentObject.getClassroomLetter(),
                                        studentObject.getClassroomNumber()+"",
                                        studentObject.getCourse(),
                                        studentObject.getYearLevel()+"",
                                        studentObject.getStatus(),
                                        studentObject.getEntryMonth()+"",
                                        studentObject.getEntryDay()+"",
                                        studentObject.getEntryYear()+"",
                                        studentObject.getEmergencyFirstName(),
                                        studentObject.getEmergencyMiddleInitial(),
                                        studentObject.getEmergencyName().getLastName(),
                                        studentObject.getEmergencyPhoneNumber()
                                );

                                csvWriter.write(String.join(",", studentString));
                                csvWriter.write("\n");
                            }
                            csvWriter.flush();
                        } catch (IOException error){
                            error.printStackTrace();
                        }

                        setVisible(false);
                        dispose();
                        try {
                            new StudentTable();
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }
                    }
                }
            }
        });

        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(btnExit.getModel().isArmed()) {
                    setVisible(false);
                    dispose();
                }
            }
        });

        tblStudents.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                selectedRow = tblStudents.getSelectedRow();
                currentStudent = students.get(selectedRow);
            }
        });
    }

    public String[][] readCSV(String path) throws FileNotFoundException, IOException {
        try (FileReader fr = new FileReader(path);
             BufferedReader br = new BufferedReader(fr)) {
            LinkedList<Object> students = new LinkedList<>();
            for (String line = br.readLine(); line != null; line = br.readLine()) {
                students.add(line.split(","));
            }
            return students.toArray(new String[students.size()][]);
        }
    }

    public static void main(String[] args) throws IOException {
        new StudentTable();
    }
}


