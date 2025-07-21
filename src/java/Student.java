import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Student {
    public String name;
    public int group;
    public int course;
    public Map<String, Integer> subjectGrades;

    public Student(String name, int group, int course, Map<String, Integer> subjectGrades) {
        this.name = name;
        this.group = group;
        this.course = course;
        this.subjectGrades = subjectGrades;
    }

    public static List<Student> dismissBadStudents(List<Student> students) {
        List<Student> badStudents = new ArrayList<>();
        for (Student student : students) {
            int sumOfGrades = 0;
            int numberOfSubjects = 0;
            for (Map.Entry<String, Integer> entry : student.subjectGrades.entrySet()) {
                sumOfGrades = sumOfGrades + entry.getValue();
                numberOfSubjects++;
            }
            int averageGrade = sumOfGrades / numberOfSubjects;
            if (averageGrade < 3) {
                badStudents.add(student);
            }
        }
        students.removeAll(badStudents);
        return students;
    }

    public int getAverageGrade() {
        int sum = 0;
        for (Map.Entry<String, Integer> entry : subjectGrades.entrySet()) {
            sum += entry.getValue();
        }
        return sum / subjectGrades.size();
    }

    public boolean isGoodStudent() {
        return getAverageGrade() >= 3;
    }

    public boolean promoteStudentNextYear() {
        if (isGoodStudent()) {
            course++;
            return true;
        }
        return false;
    }

    public static void printStudents(Set<Student> students, int course){
        for (Student student : students) {
            if (student.course == course) {
                System.out.println(student.toString() + "The course is " + course + ".");
            }
        }
    }

    @Override
    public String toString() {
        return "Student " + name + " has " + getAverageGrade() + " average grade.";
    }
}
