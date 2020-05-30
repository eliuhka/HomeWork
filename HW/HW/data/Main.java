package HW.data;

import java.time.ZonedDateTime;

public class Main {

    public static void main(String[] args) {
        ZonedDateTime courseStartDate = ZonedDateTime.parse("2020-01-02T00:00:00.000+00:00[UTC]");
        ZonedDateTime courseEndDate = ZonedDateTime.parse("2020-12-31T00:00:00.000+00:00[UTC]");
        Course course = new Course(courseStartDate, courseEndDate);
        System.out.println(course.courseStartDate + " " + course.courseEndDate);
    }
}
