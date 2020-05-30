package HW.data;


import java.time.ZonedDateTime;

public class Teacher extends PersonImpl {
    public Teacher(String name, String surname, ZonedDateTime dateOfBirth) {
        super(name, surname, dateOfBirth);}

    @Override
    public void sayHello() {
        super.sayHello();
        System.out.println(" Override");}}
