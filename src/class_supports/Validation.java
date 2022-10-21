package class_supports;

import java.awt.event.KeyEvent;
import java.awt.Color;
import java.awt.event.FocusEvent;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.border.Border;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Validation {

    Border normal = BorderFactory.createLineBorder(Color.black);
    Border error = BorderFactory.createLineBorder(Color.red);
    Border debug = BorderFactory.createLineBorder(Color.green);

    String empty = " field is empty!";

    public void isFocusedOn(FocusEvent e, JTextField field, JLabel label) {
        if (e.getSource().equals(field)) {
            if (!field.getText().isEmpty()) {
                field.setBorder(normal);
                label.setText(field.getName());

            } else {
                field.setBorder(error);
                label.setText("<html><font color=red>*</font>" + field.getName() + "</html>");

            }
        }
    }

    public void isFocusedLost(FocusEvent e, JTextField field, JLabel label) {
        if (e.getSource().equals(field)) {
            if (!field.getText().isEmpty()) {
                field.setBorder(normal);
                label.setText(field.getName());

            }

            else {

                field.setBorder(error);
                label.setText("<html><font color=red>*</font>" + field.getName() + "</html>");

            }
        }
    }

    public void isDigit(KeyEvent e, JTextField field, JLabel label) {
        if (e.getSource().equals(field)) {
            if ((!(Character.isDigit(e.getKeyChar())) && (e.getKeyChar() != (KeyEvent.VK_BACK_SPACE)))) {
                field.setBorder(error);
                e.consume();
            } else if (field.getText().isEmpty()) {
                field.setBorder(error);
                label.setText("<html><font color=red>*</font>" + field.getName() + "</html>");
            }

            else {
                field.setBorder(normal);
                label.setText(field.getName());

            }
        }
    }

    public void isLetterWithSpace(KeyEvent e, JTextField field, JLabel label) {
        if (e.getSource().equals(field)) {
            if ((!(Character.isLetter(e.getKeyChar())) && !(Character.isWhitespace(e.getKeyChar()))
                    && (e.getKeyChar() != (KeyEvent.VK_BACK_SPACE)))) {
                e.consume();
                field.setBorder(error);
            } else if (field.getText().isEmpty()) {
                field.setBorder(error);
                label.setText("<html><font color=red>*</font>" + field.getName() + "</html>");
            }

            else {
                field.setBorder(normal);
                label.setText(field.getName());

            }

        }

        
    }

    

    public void isEmail(KeyEvent e, JTextField field, JLabel label) {
        if (e.getSource().equals(field)) {
            if ((Character.isWhitespace(e.getKeyChar()))) {
                e.consume();
                field.setBorder(error);
            } else if (field.getText().isEmpty()) {
                field.setBorder(error);
                label.setText("<html><font color=red>*</font>" + field.getName() + "</html>");
            }

            else {
                field.setBorder(normal);
                label.setText(field.getName());

            }

        }
    }

    public boolean validField(JTextField field, String fldName, JLabel label) {
        boolean isEmpty = false;
        // Personal

        if (field.getText().isEmpty()) {
            field.setBorder(error);
            label.setText("<html><font color=red>*</font>" + fldName + "</html>");

            // errorMessage("(Personal Details) " + fldName + empty);
            isEmpty = true;

        }
        return !isEmpty;
    }

    public boolean validEmail(JTextField email, String fldName, JLabel label) {
        final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matchEmail = pattern.matcher(email.getText());

        if (email.getText().isEmpty()) {
            email.setBorder(error);
            label.setText("<html><font color=red>*</font>" + fldName + "</html>");

            // errorMessage("(Personal Details) " + fldName + empty);
            return false;

        }

        else if (!matchEmail.matches()) {
            email.setBorder(error);
            errorMessage("Wrong Email Format");

            return false;

        } else {
            return true;
        }
    }

    private void errorMessage(String string) {
        JOptionPane.showMessageDialog(null, string, "Add class_supports.Student", 0);
    }
}
