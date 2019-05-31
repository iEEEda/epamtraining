package kz.eduard.optional.action;
import kz.eduard.optional.entity.Student;

public class StudentAction {
    public String studentsOfFaculty(Student[] students, Faculty faculty){
        StringBuilder listOfStudents = new StringBuilder("|");
        for (int i = 0; i < students.length; i++) {
            if(students[i].getFaculty().getFacultyName() == faculty.getFacultyName()){
                listOfStudents.append(students[i].getFamilyName());
                listOfStudents.append(" ");
                listOfStudents.append(students[i].getFirstName());
                listOfStudents.append("|");
            }
        }
        return listOfStudents.toString();
    }

    public String studentsOfFacultyAndYear(Student[] students, Faculty faculty, int yearOfStudy){
        StringBuilder listOfStudents = new StringBuilder("|");
        for (int i = 0; i < students.length; i++) {
            if(students[i].getFaculty().getFacultyName() == faculty.getFacultyName() && students[i].getYearOfStudy() == yearOfStudy){
                listOfStudents.append(students[i].getFamilyName());
                listOfStudents.append(" ");
                listOfStudents.append(students[i].getFirstName());
                listOfStudents.append("|");
            }
        }
        return listOfStudents.toString();
    }

    public String studentsBornAfterYear(Student[] students, int year){
        StringBuilder listOfStudents = new StringBuilder("|");
        for (int i = 0; i < students.length; i++) {
            if(students[i].getDateOfBirth() != null){
                if(students[i].getDateOfBirth().getYear() > year){
                    listOfStudents.append(students[i].getFamilyName());
                    listOfStudents.append(" ");
                    listOfStudents.append(students[i].getFirstName());
                    listOfStudents.append("|");
                }
            }
        }
        return listOfStudents.toString();
    }

    public String studentsOfGroup(Student[] students, int group){
        StringBuilder listOfStudents = new StringBuilder("|");
        for (int i = 0; i < students.length; i++) {
            if(students[i].getGroup() == group){
                listOfStudents.append(students[i].getFamilyName());
                listOfStudents.append(" ");
                listOfStudents.append(students[i].getFirstName());
                listOfStudents.append("|");
            }
        }
        return listOfStudents.toString();
    }
}
