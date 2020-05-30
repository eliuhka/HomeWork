package HW.data;

import java.time.ZonedDateTime;
import java.util.List;
public class Student extends PersonImpl {

    public List <Course> courses;
    public Student(String name, String surname, ZonedDateTime dateOfBirth) {
        super(name, surname, dateOfBirth);

    }
    @Override
    public void sayHello() {
        super.sayHello();
        System.out.println("The invention of a shovel was ground breaking!"); }}
