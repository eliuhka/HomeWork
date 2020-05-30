package HW.data;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.ZonedDateTime;
import java.util.Collections;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class CourseTest {

    ZonedDateTime courseStartDate = ZonedDateTime.parse("2020-02-23T00:00:00.000+00:00[UTC]");
    ZonedDateTime courseEndDate = ZonedDateTime.parse("2020-02-29T00:00:00.000+00:00[UTC]");

    @Mock
    private PublicHolidayService service = new PublicHolidayService();

    @InjectMocks
    private Course course = new Course(courseStartDate, courseEndDate);

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }


    @Test
    public void gets_length() {

        ZonedDateTime courseStartDate = ZonedDateTime.parse("2020-02-23T00:00:00.000+00:00[UTC]");
        ZonedDateTime courseEndDate = ZonedDateTime.parse("2020-02-29T00:00:00.000+00:00[UTC]");
        Course course = new Course(courseStartDate, courseEndDate);

        long result = course.getNumberOfWorkDays();

        assertEquals(5L, result);


    }

    @Test(expected = IllegalArgumentException.class)
    public void throws_exception_when_end_and_start_dates_are_reversed() {
        //given
        ZonedDateTime startDate = ZonedDateTime.parse("2020-12-29T00:00:00.000+00:00[UTC]");
        ZonedDateTime endDate = ZonedDateTime.parse("2020-02-01T00:00:00.000+00:00[UTC]");
        Course course = new Course(startDate, endDate);

        //when
        course.getNumberOfWorkDays();
    }

    @Test(expected = IllegalArgumentException.class)
    public void throws_exception_when_end_and_start_date_year_are_different() {
        //given
        ZonedDateTime startDate = ZonedDateTime.parse("2020-01-01T00:00:00.000+00:00[UTC]");
        ZonedDateTime endDate = ZonedDateTime.parse("2021-01-01T00:00:00.000+00:00[UTC]");
        Course course = new Course(startDate, endDate);

        //when
        course.getNumberOfWorkDays();
    }

    @Test
    public void getWorkingDaysWhileServiceReturnNormalNumber() {

        Course course = new Course(courseStartDate, courseEndDate);

        when(service.getPublicHolidays("2020")).thenReturn(Collections.singletonList(courseStartDate));


        long workingDays = course.getNumberOfWorkDays();


        assertEquals(5, workingDays);

    }







}
