import java.util.List;
public class Utils {
    public static void printStudents(List<Student> students) {
        for (Student student : students) {
            System.out.println(student.getFirstName() + " " + student.getLastName());}}}
