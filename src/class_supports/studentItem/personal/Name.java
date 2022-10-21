package class_supports.studentItem.personal;

public class Name {
    private String firstName;
    private String middleInitial;
    private String lastName;

    public Name(String firstName, String middleInitial, String lastName) {
        this.firstName = firstName;
        this.middleInitial = middleInitial;
        this.lastName = lastName;
    }

    public Name(String firstName, String lastName) {
        this(firstName, null, lastName);
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getMiddleInitial() {
        return this.middleInitial;
    }

    public void setMiddleInitial(String middleInitial) {
        this.middleInitial = middleInitial;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFullName() {
        return (middleInitial != null) ?
                firstName + " " + middleInitial + " " + lastName : firstName + " " + lastName;
    }
}
