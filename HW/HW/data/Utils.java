package HW.data;


import java.util.List;

public class Utils {

    public static void printStudents(List<Student> students) {
        for (Student student : students) {
            System.out.println("First name: " + student.getFirstName());
            System.out.println("Last name: " + student.getLastName());
            System.out.println("Age: " + student.getAge());
        }
    }

}
