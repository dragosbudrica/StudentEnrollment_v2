package com.kepler.rominfo.action;

import com.kepler.rominfo.dto.CourseDto;
import com.kepler.rominfo.model.Course;
import com.kepler.rominfo.model.Professor;
import com.kepler.rominfo.model.Student;
import com.kepler.rominfo.model.User;
import com.kepler.rominfo.service.CourseService;
import com.kepler.rominfo.service.UserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Dragos on 10.07.2017.
 */
@Component
public class CourseAction extends ActionSupport {

    private static final Log LOGGER = LogFactory.getLog(CourseAction.class);

    private CourseService courseService;

    private List<CourseDto> professorCourses = new ArrayList<>();
    private List<CourseDto> studentCourses = new ArrayList<>();

    public List<CourseDto> getStudentCourses() {
        return studentCourses;
    }

    public void setStudentCourses(List<CourseDto> studentCourses) {
        this.studentCourses = studentCourses;
    }

    private List<CourseDto> allCourses = new ArrayList<>();

    public List<CourseDto> getAllCourses() {
        return allCourses;
    }

    public void setAllCourses(List<CourseDto> allCourses) {
        this.allCourses = allCourses;
    }

    public void setProfessorCourses(List<CourseDto> professorCourses) {
        this.professorCourses = professorCourses;
    }

    @Autowired
    public void setCourseService(CourseService courseService) {
        this.courseService = courseService;
    }


    public List<CourseDto> getProfessorCourses() {
        return professorCourses;
    }

    public String allCourses() {
        try {
            List<Course> courses = courseService.getAllCourses();

            for (Course currentCourse : courses) {
                CourseDto courseDto = new CourseDto();
                courseDto.setCourseCode(currentCourse.getCourseCode());
                courseDto.setCourseName(currentCourse.getCourseName());
                courseDto.setCategory(currentCourse.getCategory());
                courseDto.setProfessor(currentCourse.getProfessor().getFullName());
                allCourses.add(courseDto);
            }
            return SUCCESS;
        } catch (Exception ex) {
            return ERROR;
        }
    }

    public String professorCourses() {
        try {
            Map<String, Object> session = ActionContext.getContext().getSession();
            User user = (User) session.get("user");
            List<Course> courses = courseService.getProfessorCourses(user.getEmail());

            for (Course currentCourse : courses) {
                CourseDto courseDto = setCourseDtoProperties(currentCourse);
                professorCourses.add(courseDto);
            }
            return SUCCESS;
        } catch (Exception ex) {
            return ERROR;
        }
    }

    public String studentCourses() {
        try {
            Map<String, Object> session = ActionContext.getContext().getSession();
            User user = (User) session.get("user");
            List<Course> courses = courseService.getStudentCourses(user.getEmail());

            for (Course currentCourse : courses) {
                CourseDto courseDto = setCourseDtoProperties(currentCourse);
                studentCourses.add(courseDto);
            }
            return SUCCESS;
        } catch (Exception ex) {
            return ERROR;
        }
    }

    private CourseDto setCourseDtoProperties(Course course) {
        CourseDto courseDto = new CourseDto();
        courseDto.setCourseCode(course.getCourseCode());
        courseDto.setCourseName(course.getCourseName());
        courseDto.setCategory(course.getCategory());
        courseDto.setProfessor(course.getProfessor().getFullName());
        return courseDto;
    }
}
