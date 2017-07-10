package com.kepler.rominfo.action;

import com.kepler.rominfo.dto.CourseDto;
import com.kepler.rominfo.model.Course;
import com.kepler.rominfo.service.CourseService;
import com.opensymphony.xwork2.ActionSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dragos on 10.07.2017.
 */
@Component
public class CourseAction extends ActionSupport {

    private CourseService courseService;

    @Autowired
    public void setCourseService(CourseService courseService) {
        this.courseService = courseService;
    }

    public List<CourseDto> getAllCourses() {

        List<Course> allCourses = courseService.getAllCourses();
        List<CourseDto> courses = new ArrayList<CourseDto>();

        for (Course currentCourse : allCourses) {
            CourseDto courseDto = new CourseDto();
            courseDto.setCourseName(currentCourse.getCourseName());
            courseDto.setCategory(currentCourse.getCategory());
            courseDto.setProfessor(currentCourse.getProfessor().getFullName());
            courses.add(courseDto);
        }
        return courses;
    }
}
