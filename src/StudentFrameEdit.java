import class_supports.*;
import class_supports.studentItem.personal.Date;
import class_supports.studentItem.personal.Name;
import class_supports.studentItem.personal.PersonalDetails;
import class_supports.studentItem.school.Classroom;
import class_supports.studentItem.school.Course;
import class_supports.studentItem.school.SchoolDetails;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.Cursor;

import java.io.*;
import java.util.*;

public class StudentFrameEdit extends JFrame implements KeyListener, FocusListener {

    private JLabel lblPersonal;
    private JLabel lblID;
    private JLabel lblFirstName;
    private JLabel lblMI;
    private JLabel lblLastName;
    private JLabel lblPhone;
    private JLabel lblEmail;
    private JLabel lblSex;
    private JLabel lblBirthDate;
    private JLabel lblNationality;
    private JLabel lblSchool;
    private JLabel lblClassroomLetter;
    private JLabel lblClassroomNumber;
    private JLabel lblCourse;
    private JLabel lblYearLevel;
    private JLabel lblStatus;
    private JLabel lblEntryDate;
    private JLabel lblEmergencyDetails;
    private JLabel lblEFirstName;
    private JLabel lblEMI;
    private JLabel lblELastName;
    private JLabel lblEPhone;

    private JTextField txtID;
    private JTextField txtFirstName;
    private JTextField txtMI;
    private JTextField txtLastName;
    private JTextField txtPhone;
    private JTextField txtEmail;
    private JTextField txtClassroomLetter;
    private JTextField txtClassroomNumber;
    private JTextField txtCourse;
    private JTextField txtYearLevel;
    private JTextField txtEFirstName;
    private JTextField txtEMI;
    private JTextField txtELastName;
    private JTextField txtEPhone;

    private JComboBox<String> cmbSex;
    private JComboBox<String> cmbNationality;
    private JComboBox<String> cmbStatus;
    private JComboBox<String> cmbYearLevel;
    private JComboBox<String> cmbCourse;
   
    private JDatePickerImpl datePickerBirthDate;
    private JDatePickerImpl datePickerEntryDate;

    private JButton btnProcess;
    private JButton btnClose;

    private int studentIndex;

    private String[] arrSSex = {"Male", "Female"};
    private String[] arrSNationality = { "Filipino", "American", "Japanese"};
    private String[] arrSStatus = {"Admit", "Conditional Admit", "Referred", "Deferred", "Waitlisted", "Denied", "Cancelled"};
    private String[] arrSYearLevel = { "1", "2", "3", "4" }; 
    private String[] arrSCourse = { "CS", "IS", "EMC" };


    Validation validate = new Validation();
    String path = "src\\data\\students.text";

    private JDatePickerImpl generateDatePicker(int month, int day, int year) {
        UtilDateModel model = new UtilDateModel();
        Properties properties = new Properties();
        properties.put("text.today", "Today");
        properties.put("text.month", "Month");
        properties.put("text.year", "Year");
        model.setDate(year, month, day);
        model.setSelected(true);
        JDatePanelImpl date = new JDatePanelImpl(model, properties);
        return new JDatePickerImpl(date, new DateLabelFormatter());
    }

    StudentFrameEdit(Student student, StudentList students){

        lblPersonal = new JLabel("Personal Details...");
        lblID = new JLabel("ID Number: ");
        lblFirstName = new JLabel("First Name: ");
        lblMI = new JLabel("M.I.: ");
        lblLastName = new JLabel("Last Name: ");
        lblPhone = new JLabel("Phone Number: ");
        lblEmail = new JLabel("Email: ");
        lblSex = new JLabel("Sex: ");
        lblBirthDate = new JLabel("Birth Date: ");
        lblNationality = new JLabel("Nationality: ");

        txtID = new JTextField();
        txtFirstName = new JTextField();

        txtMI = new JTextField();
        txtLastName = new JTextField();
        txtPhone = new JTextField();
        txtEmail = new JTextField();
        cmbSex = new JComboBox<>(arrSSex);
        datePickerBirthDate = generateDatePicker(11, 29, 2000);
        cmbNationality = new JComboBox<String>(arrSNationality);

        lblSchool = new JLabel("School Details...");
        lblClassroomLetter = new JLabel("Letter: ");
        lblClassroomNumber = new JLabel("Number: ");
        lblCourse = new JLabel("Course: ");
        lblYearLevel = new JLabel("Year: ");
        lblStatus = new JLabel("Status: ");
        lblEntryDate = new JLabel("Entry Date: ");

        txtClassroomLetter = new JTextField();
        txtClassroomNumber = new JTextField();

        cmbCourse = new JComboBox<>(arrSCourse);
        cmbYearLevel = new JComboBox<>(arrSYearLevel);
        // txtCourse = new JTextField();   
        // txtYearLevel = new JTextField();

        txtClassroomLetter.setDocument(new JTextFieldLimit(1));
        txtClassroomNumber.setDocument(new JTextFieldLimit(3));           
        // txtCourse.setDocument(new JTextFieldLimit(5)); 
        // txtYearLevel.setDocument(new JTextFieldLimit(1));

        cmbStatus = new JComboBox<String>(arrSStatus);
        datePickerEntryDate = generateDatePicker(10, 19, 2022);

        lblEmergencyDetails = new JLabel("Emergency Contact...");
        lblEFirstName = new JLabel("First Name: ");
        lblELastName = new JLabel("Last Name: ");
        lblEMI = new JLabel("M.I.: ");
        lblEPhone = new JLabel("Phone Number: ");

        txtEFirstName = new JTextField();
        txtELastName = new JTextField();
        txtEMI = new JTextField();
        txtEPhone = new JTextField();

        btnProcess = new JButton("Process");
        btnClose = new JButton("Close");

        btnProcess.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnClose.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        getKeyList();
        getFocusList();
        setJTextFieldNames();

        add(lblPersonal).setBounds(20, 5, 120, 20);
        add(lblID).setBounds(20, 30, 70, 20);
        add(txtID).setBounds(20, 50, 75, 25);
        add(lblFirstName).setBounds(20, 80, 70, 20);
        add(txtFirstName).setBounds(20, 100, 150, 25);
        add(lblLastName).setBounds(180, 80, 70, 20);
        add(txtLastName).setBounds(180, 100, 150, 25);
        add(lblMI).setBounds(340, 80, 70, 20);
        add(txtMI).setBounds(340, 100, 100, 25);
        add(lblPhone).setBounds(20, 130, 100, 20);
        add(txtPhone).setBounds(20, 150, 150, 25);
        add(lblEmail).setBounds(180, 130, 60, 20);
        add(txtEmail).setBounds(180, 150, 150, 25);
        add(lblSex).setBounds(340, 130, 50, 20);
        add(cmbSex).setBounds(340, 150, 70, 25);
        add(lblBirthDate).setBounds(20, 180, 70, 20);
        add(datePickerBirthDate).setBounds(20, 200, 150, 25);
        add(lblNationality).setBounds(180, 180, 70, 20);
        add(cmbNationality).setBounds(180, 200, 120, 25);

        add(lblSchool).setBounds(20, 250, 120, 20);
        add(lblClassroomLetter).setBounds(20, 275, 150, 20);
        add(txtClassroomLetter).setBounds(20, 295, 40, 25);
        add(lblClassroomNumber).setBounds(70, 275, 100, 20);
        add(txtClassroomNumber).setBounds(70, 295, 100, 25);
        add(lblYearLevel).setBounds(20, 325, 100, 20);
        add(cmbYearLevel).setBounds(20, 345, 40, 25);
        add(lblCourse).setBounds(70, 325, 100, 20);
        add(cmbCourse).setBounds(70, 345, 100, 25);
        add(lblEntryDate).setBounds(20, 375, 100, 20);
        add(datePickerEntryDate).setBounds(20, 395, 150, 25);
        add(lblStatus).setBounds(180, 375, 100, 20);
        add(cmbStatus).setBounds(180, 395, 100, 25);

        add(lblEmergencyDetails).setBounds(20, 445, 150, 20);
        add(lblEFirstName).setBounds(20, 470, 70, 20);
        add(txtEFirstName).setBounds(20, 490, 150, 25);
        add(lblELastName).setBounds(180, 470, 70, 20);
        add(txtELastName).setBounds(180, 490, 150, 25);
        add(lblEMI).setBounds(340, 470, 70, 20);
        add(txtEMI).setBounds(340, 490, 100, 25);
        add(lblEPhone).setBounds(20, 520, 120, 20);
        add(txtEPhone).setBounds(20, 540, 150, 25);

        add(btnProcess).setBounds(20, 600, 120, 25);
        add(btnClose).setBounds(150, 600, 120, 25);

        cmbNationality.setEditable(true);
        cmbCourse.setEditable(true);
        cmbStatus.setEditable(true);

        studentIndex = students.indexOf(student);

        txtID.setText(student.getIdNum()+"");
        txtFirstName.setText(student.getFirstName());
        txtLastName.setText(student.getLastName());
        txtMI.setText(student.getMiddleInitial());
        txtPhone.setText(student.getPhoneNumber());
        txtEmail.setText(student.getEmail());
        cmbSex.setSelectedItem(student.getSex());

        datePickerBirthDate.getModel().setDay(student.getBirthDay());
        datePickerBirthDate.getModel().setMonth(student.getBirthMonth());
        datePickerBirthDate.getModel().setYear(student.getBirthYear());
        datePickerBirthDate.getModel().setSelected(true);

        cmbNationality.setSelectedItem(student.getNationality());
        txtClassroomLetter.setText(student.getClassroomLetter()+"");
        txtClassroomNumber.setText(student.getClassroomNumber()+"");
        cmbCourse.setSelectedItem(student.getCourse());
        cmbYearLevel.setSelectedItem(student.getYearLevel()+"");
        datePickerEntryDate.getModel().setDay(student.getEntryDay());
        datePickerEntryDate.getModel().setMonth(student.getEntryMonth());
        datePickerEntryDate.getModel().setYear(student.getEntryYear());
        datePickerEntryDate.getModel().setSelected(true);
        cmbStatus.setSelectedItem(student.getStatus());
        txtEFirstName.setText(student.getEmergencyName().getFirstName());
        txtELastName.setText(student.getEmergencyName().getLastName());
        txtEMI.setText(student.getEmergencyName().getMiddleInitial());
        txtEPhone.setText(student.getEmergencyPhoneNumber());

        txtID.setEnabled(false);


        btnProcess.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

          
                if(inputValidation()){
                Name nameStudent = new Name(txtFirstName.getText(), txtMI.getText(), txtLastName.getText());
                String phoneStudent = txtPhone.getText();
                String emailStudent = txtEmail.getText();
                String genderStudent = cmbSex.getSelectedItem().toString();
                Date birthStudent = new Date(datePickerBirthDate.getModel().getMonth(), datePickerBirthDate.getModel().getDay(), datePickerBirthDate.getModel().getYear());
                String nationalityStudent = cmbNationality.getSelectedItem().toString();
                PersonalDetails personalStudent = new PersonalDetails(nameStudent, phoneStudent, emailStudent, genderStudent, birthStudent, nationalityStudent);

                Classroom classroomStudent = new Classroom(txtClassroomLetter.getText(), Integer.parseInt(txtClassroomNumber.getText()));
                Course courseStudent = new Course(cmbCourse.getSelectedItem().toString(), Integer.parseInt(cmbYearLevel.getSelectedItem().toString()));
                String statusStudent = cmbStatus.getSelectedItem().toString();
                Date entryStudent = new Date(datePickerEntryDate.getModel().getMonth(), datePickerEntryDate.getModel().getDay(), datePickerEntryDate.getModel().getYear());
                SchoolDetails schoolStudent = new SchoolDetails(classroomStudent, courseStudent, statusStudent, entryStudent);

                Name emergencyName = new Name(txtEFirstName.getText(), txtEMI.getText(), txtELastName.getText());
                String phoneEmergency = txtEPhone.getText();
                PersonalDetails emergencyStudent = new PersonalDetails(emergencyName, phoneEmergency);

                Student student = new Student(Integer.parseInt(txtID.getText()), personalStudent, schoolStudent, emergencyStudent);
                students.set(studentIndex, student);


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
                try {
                    new StudentTable();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                dispose();
            }
            else{ 
                JOptionPane.showMessageDialog(null, "Please Check the Required fields.");
            }
            }
        });

        btnClose.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (btnClose.getModel().isArmed()) {
                    setVisible(false);
                    try {
                        new StudentTable();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                    dispose();
                }
            }
        });

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("class_supports.Student Frame");
        setSize(500, 680);
        setLayout(null);
        setVisible(true);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        validate.isLetterWithSpace(e, txtFirstName, lblFirstName);
        validate.isLetterWithSpace(e, txtLastName, lblLastName);
        validate.isLetterWithSpace(e, txtMI, lblMI);
        validate.isLetterWithSpace(e, txtClassroomLetter, lblClassroomLetter);
        // validate.isLetterWithSpace(e, txtCourse, lblCourse);
        validate.isLetterWithSpace(e, txtEFirstName, lblEFirstName);
        validate.isLetterWithSpace(e, txtELastName, lblELastName);
        validate.isLetterWithSpace(e, txtEMI, lblEMI);

        validate.isEmail(e, txtEmail, lblEmail);

        validate.isDigit(e, txtPhone, lblPhone);
        validate.isDigit(e, txtEPhone, lblEPhone);
        validate.isDigit(e, txtClassroomNumber, lblClassroomNumber);
        // validate.isDigit(e, txtYearLevel, lblYearLevel);
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // Do nothing
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // Do nothing
        
    }

    @Override
    public void focusGained(FocusEvent e) {
        validate.isFocusedOn(e, txtFirstName, lblFirstName);
        validate.isFocusedOn(e, txtLastName, lblLastName);
        validate.isFocusedOn(e, txtMI, lblMI);
        validate.isFocusedOn(e, txtClassroomLetter, lblClassroomLetter);
        // validate.isFocusedOn(e, txtCourse, lblCourse);
        validate.isFocusedOn(e, txtEFirstName, lblEFirstName);
        validate.isFocusedOn(e, txtELastName, lblELastName);
        validate.isFocusedOn(e, txtEMI, lblEMI);

        validate.isFocusedOn(e, txtEmail, lblEmail);

        validate.isFocusedOn(e, txtPhone, lblPhone);
        validate.isFocusedOn(e, txtEPhone, lblEPhone);
        validate.isFocusedOn(e, txtClassroomNumber, lblClassroomNumber);
        // validate.isFocusedOn(e, txtYearLevel, lblYearLevel);
    }

    @Override
    public void focusLost(FocusEvent e) {
        validate.isFocusedLost(e, txtFirstName, lblFirstName);
        validate.isFocusedLost(e, txtLastName, lblLastName);
        validate.isFocusedLost(e, txtMI, lblMI);
        validate.isFocusedLost(e, txtClassroomLetter, lblClassroomLetter);
        // validate.isFocusedLost(e, txtCourse, lblCourse);
        validate.isFocusedLost(e, txtEFirstName, lblEFirstName);
        validate.isFocusedLost(e, txtELastName, lblELastName);
        validate.isFocusedLost(e, txtEMI, lblEMI);

        validate.isFocusedLost(e, txtEmail, lblEmail);

        validate.isFocusedLost(e, txtPhone, lblPhone);
        validate.isFocusedLost(e, txtEPhone, lblEPhone);
        validate.isFocusedLost(e, txtClassroomNumber, lblClassroomNumber);
        // validate.isFocusedLost(e, txtYearLevel, lblYearLevel);
        
    }

    private boolean inputValidation() {
        boolean isEmpty = false;
        
        //personal
        if (!validate.validField(txtFirstName, txtFirstName.getName(), lblFirstName)) {isEmpty = true;}
        if (!validate.validField(txtLastName, txtLastName.getName(), lblLastName))  {isEmpty = true;}
        if (!validate.validField(txtMI, txtMI.getName(), lblMI)) {isEmpty = true;}
        if (!validate.validField(txtPhone, txtPhone.getName(), lblPhone)) {isEmpty = true;}
        if (!validate.validEmail(txtEmail, txtEmail.getName(), lblEmail)) {isEmpty = true;}

        //school
        if (!validate.validField(txtClassroomLetter, txtClassroomLetter.getName(), lblClassroomLetter)) {isEmpty = true;}
        if (!validate.validField(txtClassroomNumber, txtClassroomNumber.getName(), lblClassroomNumber)) {isEmpty = true;}
        // if (!validate.validField(txtYearLevel, txtYearLevel.getName(), lblYearLevel)) {isEmpty = true;}
        // if (!validate.validField(txtCourse, txtCourse.getName(), lblCourse)) {isEmpty = true;}

        //Emergency
        if (!validate.validField(txtEFirstName, txtEFirstName.getName(), lblEFirstName)) {isEmpty = true;}
        if (!validate.validField(txtELastName, txtELastName.getName(), lblELastName)) {isEmpty = true;}
        if (!validate.validField(txtEMI, txtEMI.getName(), lblEMI)) {isEmpty = true;}
        if (!validate.validField(txtEPhone, txtEPhone.getName(), lblEPhone)) {isEmpty = true;}

        return !isEmpty;
    }

    public void setJTextFieldNames(){
        //Personal
        txtFirstName.setName("First Name:");
        txtLastName.setName("Last Name:");
        txtEmail.setName("Email:");
        txtPhone.setName("Phone Number:");      
        txtMI.setName("M.I.:");

        //school 
        txtClassroomLetter.setName("Letter: ");
        txtClassroomNumber.setName("Number: ");        
        // txtYearLevel.setName("Year:");
        // txtCourse.setName("Course:");

        //emergency
        txtEFirstName.setName("First Name:");
        txtELastName.setName("Last Name:");
        txtEPhone.setName("Phone Number:");        
        txtEMI.setName("M.I.:");
    }

    public void getKeyList(){
        txtFirstName.addKeyListener(this);
        txtLastName.addKeyListener(this);
        txtEmail.addKeyListener(this);
        txtPhone.addKeyListener(this);      
        txtMI.addKeyListener(this);

        txtClassroomLetter.addKeyListener(this);
        txtClassroomNumber.addKeyListener(this);        
        // txtYearLevel.addKeyListener(this);
        // txtCourse.addKeyListener(this);

        txtClassroomLetter.addKeyListener(this);
        txtClassroomNumber.addKeyListener(this);        
        // txtYearLevel.addKeyListener(this);
        // txtCourse.addKeyListener(this);

        txtEFirstName.addKeyListener(this);
        txtELastName.addKeyListener(this);
        txtEPhone.addKeyListener(this);        
        txtEMI.addKeyListener(this);
    }

    public void getFocusList(){   

        txtClassroomLetter.addFocusListener(this);
        txtClassroomNumber.addFocusListener(this);        
        // txtYearLevel.addFocusListener(this);
        // txtCourse.addFocusListener(this);

        txtEFirstName.addFocusListener(this);
        txtELastName.addFocusListener(this);
        txtEPhone.addFocusListener(this);        
        txtEMI.addFocusListener(this);

        txtFirstName.addFocusListener(this);
        txtLastName.addFocusListener(this);
        txtEmail.addFocusListener(this);
        txtPhone.addFocusListener(this);      
        txtMI.addFocusListener(this);

        txtClassroomLetter.addFocusListener(this);
        txtClassroomNumber.addFocusListener(this);        
        // txtYearLevel.addFocusListener(this);
        // txtCourse.addFocusListener(this);

     
    }
}