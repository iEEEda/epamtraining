package kz.eduard.optional.entity;

import kz.eduard.optional.action.Faculty;

import java.time.LocalDate;

public class Student {
    private int id;
    private String familyName;
    private String firstName;
    private String fatherName;
    private LocalDate dateOfBirth;
    private String address;
    private String phone;
    private Faculty faculty;
    private byte yearOfStudy;
    private int group;

    public Student(int id, String familyName, String firstName, String fatherName, int year, int month, int dayOfMonth,
                   String address, String phone, Faculty faculty, int yearOfStudy, int group) {
        this.id = id;
        this.familyName = familyName;
        this.firstName = firstName;
        this.fatherName = fatherName;
        this.dateOfBirth = LocalDate.of(year, month, dayOfMonth);
        this.address = address;
        this.phone = phone;
        this.faculty = faculty;
        this.yearOfStudy = (byte)yearOfStudy;
        this.group = group;
    }

    public Student(int id, String familyName, String firstName,
                   String address, Faculty faculty, int yearOfStudy, int group) {
        this.id = id;
        this.familyName = familyName;
        this.firstName = firstName;
        this.address = address;
        this.faculty = faculty;
        this.yearOfStudy = (byte)yearOfStudy;
        this.group = group;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    public byte getYearOfStudy() {
        return yearOfStudy;
    }

    public void setYearOfStudy(byte yearOfStudy) {
        this.yearOfStudy = yearOfStudy;
    }

    public int getGroup() {
        return group;
    }

    public void setGroup(int group) {
        this.group = group;
    }

    public String toString(){
        StringBuilder result = new StringBuilder("[ ");
        result.append("ID: ");
        result.append(id);
        result.append(", ");
        result.append(familyName);
        result.append(" ");
        result.append(firstName);
        result.append(" ");
        if (fatherName != null) {
            result.append(fatherName);
            result.append(", ");
        }
        if (dateOfBirth != null) {
            result.append(dateOfBirth.toString()) ;
            result.append(", ");
        }
        result.append(address);
        result.append(", ");
        if (phone != null) {
            result.append(phone);
            result.append(", ");
        }
        result.append(faculty.getFacultyName());
        result.append(", ");
        result.append("year of study: " + yearOfStudy + ", ");
        result.append("group# " + group + " ]");
        return result.toString();
    }
}
