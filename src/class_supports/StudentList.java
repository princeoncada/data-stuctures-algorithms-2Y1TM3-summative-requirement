package class_supports;

import java.util.LinkedList;
public class StudentList extends LinkedList<Student>{
    private static StudentList list = new StudentList();
    public static StudentList getList() {
        return list;
    }
}
