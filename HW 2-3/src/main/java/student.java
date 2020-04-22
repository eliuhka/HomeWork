import java.util.ArrayList;
import java.util.List;
class Student extends PersonImpl {
    public String name;
    public String surname;
    public int age;
    public int course;
    public List <Course> courses;
    @Override
    public void sayHello() {
        super.sayHello();
        System.out.println("Hello");}
    public List<String> showCourseTeachersNames(List<Course> courses) {
        this.courses = courses;
        List<String> nameOfTeachers = new ArrayList<String>();
        for(Course course : courses) {
            nameOfTeachers.add(course.getTeacher().getFirstName());}
        return nameOfTeachers;}
    @Override
    public String getFirstName() {
        return String.format("Student first name: %s", name);}
    @Override
    public String getLastName() {
        return String.format("Student last name: %s", surname); }}


