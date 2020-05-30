package HW.data;


import java.time.DayOfWeek;
import java.time.Period;
import java.time.ZonedDateTime;
import java.util.List;
public class Course {
    private PublicHolidayService publicHolidayService = new PublicHolidayService();
    public String courseName;
    public Integer courseEAP;
    public ZonedDateTime courseStartDate;
    public ZonedDateTime courseEndDate;
    public Teacher teacher;
    public Course(String courseName, Integer courseEAP, ZonedDateTime courseStartDate, ZonedDateTime courseEndDate) {
        this.courseName = courseName;
        this.courseEAP = courseEAP;
        this.courseStartDate = courseStartDate;
        this.courseEndDate = courseEndDate;
    }
    public Course(ZonedDateTime courseStartDate, ZonedDateTime courseEndDate) {
        this.courseStartDate = courseStartDate;
        this.courseEndDate = courseEndDate;
    }

    public String getCourseName() {
        return courseName; }
    public Integer getCourseEAP() {
        return courseEAP; }
    public Teacher getTeacher() {
        return teacher; }


    public long getNumberOfWorkDays() {
        if (courseEndDate.isAfter(courseStartDate) && courseEndDate.getYear() == courseStartDate.getYear()) {
            ZonedDateTime date = courseStartDate;
            long result = 0;
            String yearString = String.valueOf(courseStartDate.getYear());
            List<ZonedDateTime> publicHolidays = publicHolidayService.getPublicHolidays(yearString);
            Period period = Period.parse("P1D");
            while (date.isBefore(courseEndDate) || date.isEqual(courseEndDate)) {
                System.out.println(date);
                date = date.plus(period);
                if (date.getDayOfWeek() != DayOfWeek.SATURDAY && date.getDayOfWeek() != DayOfWeek.SUNDAY && !publicHolidays.contains(date)) {
                    result += 1; }}
            return result;
        } else {
            throw new IllegalArgumentException("error"); }}
    @Override
    public String toString() {
        return "Course{" +
                "courseName='" + courseName + '\'' +
                ", courseEAP=" + courseEAP +
                ", courseStartDate=" + courseStartDate +
                ", courseEndDate=" + courseEndDate +
                '}';}}
