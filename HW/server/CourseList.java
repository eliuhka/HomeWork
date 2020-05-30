package server;

import HW.data.Course;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class CourseList extends HttpServlet {

    ZonedDateTime courseStartDate = ZonedDateTime.parse("2020-01-01T00:00:00.000+00:00[UTC]");
    ZonedDateTime courseEndDate = ZonedDateTime.parse("2020-01-03T00:00:00.000+00:00[UTC]");
    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    private Course course = new Course("Automaattestimine", 6, courseStartDate, courseEndDate);
    private Course course2 = new Course("Lineaaralgebra", 5, courseStartDate.plusDays(11), courseEndDate.plusDays(15));
    private Course course3 = new Course("Praktika", 10, courseStartDate.plusMonths(1), courseEndDate.plusMonths(2));
    Course [] courses = {course, course2, course3};
    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        response.setStatus(HttpServletResponse.SC_OK);
        for (Course course : courses){
            response.getWriter().println("<html>"+ course.courseName + ", " + course.getCourseEAP() + " EAP, starting on " + course.courseStartDate.toLocalDateTime().format(dateTimeFormatter) +  " and finishes " + course.courseEndDate.toLocalDateTime().format(dateTimeFormatter) +"</html>");
        }

    }

}
