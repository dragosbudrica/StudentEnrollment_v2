package com.kepler.rominfo.action;

import com.kepler.rominfo.dto.CourseDto;
import com.kepler.rominfo.service.CourseService;
import com.opensymphony.xwork2.ActionSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TimetableAction extends ActionSupport {

    private CourseService courseService;

    private boolean rendered;

    public boolean isRendered() {
        return rendered;
    }

    public void setRendered(boolean rendered) {
        this.rendered = rendered;
    }

    @Autowired
    public void setCourseService(CourseService courseService) {
        this.courseService = courseService;
    }

    private List<CourseDto> events = new ArrayList<CourseDto>();

    public void setEvents(List<CourseDto> events) {
        this.events = events;
    }

    public List<CourseDto> getEvents() {
        return events;
    }

    public String events() {
        boolean timetableUnderConstruction = false;
        for (CourseDto course : courseService.getAllCoursesWithDates()) {
            if (course.getStartTime() == null) {
                timetableUnderConstruction = true;
            }
        }

        if (timetableUnderConstruction) {
            rendered = false;
            return "Under Construction";
        } else {
            for(CourseDto currentCourseDto : courseService.getAllCoursesWithDates()) {
                List<CourseDto> reccurentCourses = courseService.getAllRecurrentCourses(currentCourseDto);
                events.addAll(reccurentCourses);
            }
            rendered = true;
            return SUCCESS;
        }
    }
}
