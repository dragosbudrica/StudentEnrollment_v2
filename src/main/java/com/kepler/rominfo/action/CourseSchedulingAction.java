package com.kepler.rominfo.action;

import com.kepler.rominfo.dto.CourseDto;
import com.kepler.rominfo.model.Course;
import com.kepler.rominfo.service.CourseService;
import com.kepler.rominfo.utils.InvalidDateException;
import com.opensymphony.xwork2.ActionSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Component
public class CourseSchedulingAction extends ActionSupport {

    private static final String UNIVERSITY_START_DATE = "2016-10-01";
    private static final String UNIVERSITY_END_DATE = "2017-06-30";

    private CourseService courseService;

    private List<CourseDto> events = new ArrayList<CourseDto>();

    public void setEvents(List<CourseDto> events) {
        this.events = events;
    }

    public List<CourseDto> getEvents() {
        return events;
    }

    @Autowired
    public void setCourseService(CourseService courseService) {
        this.courseService = courseService;
    }

    private List<String> courseTitles = new ArrayList<>();

    public void setCourseTitles(List<String> courseTitles) {
        this.courseTitles = courseTitles;
    }

    public List<String> getCourseTitles() {
        return courseTitles;
    }

    private String courseName;
    public String startTime;

    private String schedulingResult;

    public String getSchedulingResult() {
        return schedulingResult;
    }

    public void setSchedulingResult(String schedulingResult) {
        this.schedulingResult = schedulingResult;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String courseTitles() {
        try {
            courseTitles = courseService.getAllCourseTitles();
            return SUCCESS;
        } catch (Exception ex) {
            ex.printStackTrace();
            return ERROR;
        }
    }

    public String schedule() {
        try {
            if (validateDate(startTime)) {
                courseService.updateEvent(courseName, startTime);
                for (CourseDto currentCourseDto : courseService.getAllCoursesWithDates()) {
                    List<CourseDto> reccurentCourses = courseService.getAllRecurrentCourses(currentCourseDto);
                    events.addAll(reccurentCourses);
                }
                schedulingResult = "Scheduling successful!";
                return SUCCESS;
            } else {
                schedulingResult = "Invalid Date!";
                return ERROR;
            }
        } catch (Exception ex) {
            schedulingResult = ex.getMessage();
            return schedulingResult;
        }
    }

    private boolean validateDate(String startTime) throws InvalidDateException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date universityStartDate = null;
        Date univeristyEndDate = null;
        Date date = null;
        try {
            universityStartDate = sdf.parse(UNIVERSITY_START_DATE);
            univeristyEndDate = sdf.parse(UNIVERSITY_END_DATE);
            date = sdf.parse(startTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }


        Calendar c = Calendar.getInstance();
        c.setTime(date);
        int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);

        /* dayOfWeek=7 => SATURDAY
         dayOfWeek=1 => SUNDAY*/
        return !date.before(universityStartDate) && !date.after(univeristyEndDate) && dayOfWeek != 1 && dayOfWeek != 7;
    }

    public String events() {
        try {
            for (CourseDto currentCourseDto : courseService.getAllCoursesWithDates()) {
                List<CourseDto> reccurentCourses = courseService.getAllRecurrentCourses(currentCourseDto);
                events.addAll(reccurentCourses);
            }
            return SUCCESS;
        }catch(Exception ex) {
            ex.printStackTrace();
            return ERROR;
        }
    }

}
