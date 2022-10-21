package class_supports.studentItem.personal;

public class PersonalDetails {
    private Name name;
    private String phoneNumber;
    private String email;
    private String sex;
    private Date birthDate;
    private String nationality;

    public PersonalDetails(Name name, String phoneNumber, String email, String sex, Date birthDate, String nationality) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.sex = sex;
        this.birthDate = birthDate;
        this.nationality = nationality;
    }

    public PersonalDetails(Name name, String phoneNumber) {
        this(name, phoneNumber, null, null, null, null);
    }

    public Name getName() {
        return this.name;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSex() {
        return this.sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getBirthDate() {
        return this.birthDate;
    }

    public String getNationality() {
        return this.nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }
}
