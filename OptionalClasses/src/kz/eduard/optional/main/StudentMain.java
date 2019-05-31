package kz.eduard.optional.main;

import kz.eduard.optional.action.Faculty;
import kz.eduard.optional.action.StudentAction;
import kz.eduard.optional.entity.Student;

public class StudentMain {
    public static void main(String[] args) {
        Student aida = new Student(128, "Eduard", "Aida", "Nurlanovna",
                1998, 7, 21, "Astana", "88005553535", Faculty.COMPUTER_SCIENCE,
                3, 5);
        System.out.println(aida.toString());

        Student allan = new Student(319, "Richardson", "Allan", "London", Faculty.LITERATURE,
                2, 6);

        Student kate = new Student(156, "Some", "Kate", "New York", Faculty.COMPUTER_SCIENCE,
                3, 10);

        Student arrayOfStudents[] = {aida, allan, kate};

        StudentAction action = new StudentAction();
        System.out.println(action.studentsBornAfterYear(arrayOfStudents,1997));
        System.out.println(action.studentsOfFaculty(arrayOfStudents, Faculty.COMPUTER_SCIENCE));
        System.out.println(action.studentsOfFacultyAndYear(arrayOfStudents, Faculty.COMPUTER_SCIENCE, 3));
        System.out.println(action.studentsOfGroup(arrayOfStudents, 6));
    }
}
