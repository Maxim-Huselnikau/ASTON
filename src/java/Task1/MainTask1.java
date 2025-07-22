package Task1;

import java.util.*;

public class MainTask1 {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>(List.of(
                new Student("Maksim", 2, 5, new HashMap<>(Map.of("Math", 10, "physics", 8, "philosophy", 9))),
                new Student("Kirill", 2, 5, new HashMap<>(Map.of("Math", 10, "physics", 8, "philosophy", 9))),
                new Student("Alesia", 2, 4, new HashMap<>(Map.of("Math", 10, "physics", 8, "philosophy", 9))),
                new Student("Vas9", 1, 4, new HashMap<>(Map.of("Math", 4, "physics", 2, "philosophy", 2))),
                new Student("Nina", 3, 2, new HashMap<>(Map.of("Math", 5, "physics", 1, "philosophy", 3)))
        ));

        //dismiss Bad Students
        List<Student> onlyGoodStudents = Student.dismissBadStudents(students);
        System.out.println("Printing only GOOD students:");
        for (Student goodStudent : onlyGoodStudents) {
            System.out.println("This is GOOD student. " + goodStudent.toString());
        }

        System.out.println();

        //promote only good students to the Next Year
        for (Student student : students) {
            if (student.promoteStudentNextYear()) {
                System.out.println("Promoted to the next course " + student.course + ". " + student.toString());
            }

            System.out.println();

            //print students 4 course
            Set<Student> myStudents = new HashSet<>(List.of(
                    new Student("Maksim", 2, 5, new HashMap<>(Map.of("Math", 10, "physics", 8, "philosophy", 9))),
                    new Student("Kirill", 2, 5, new HashMap<>(Map.of("Math", 10, "physics", 8, "philosophy", 9))),
                    new Student("Alesia", 2, 4, new HashMap<>(Map.of("Math", 10, "physics", 8, "philosophy", 9))),
                    new Student("Vas9", 1, 4, new HashMap<>(Map.of("Math", 4, "physics", 2, "philosophy", 2))),
                    new Student("Nina", 3, 2, new HashMap<>(Map.of("Math", 5, "physics", 1, "philosophy", 3)))
            ));
            Student.printStudents(myStudents, 4);

            System.out.println();

        }
    }
}
