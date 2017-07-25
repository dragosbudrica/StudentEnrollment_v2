package com.kepler.rominfo.action;

import com.kepler.rominfo.dto.LectureDto;
import com.kepler.rominfo.model.Course;
import com.kepler.rominfo.model.Lecture;
import com.kepler.rominfo.service.CourseService;
import com.kepler.rominfo.service.LectureService;
import com.kepler.rominfo.service.UserService;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dragos on 12.07.2017.
 */
@Component
public class LectureAction extends ActionSupport {
    private static final Log LOGGER = LogFactory.getLog(LectureAction.class);
    private CourseService courseService;
    private LectureService lectureService;

    private List<LectureDto> lectures = new ArrayList<>();
    private String courseCode;
    private String courseName;

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public LectureService getLectureService() {
        return lectureService;
    }

    public void setLectures(List<LectureDto> lectures) {
        this.lectures = lectures;
    }

    public List<LectureDto> getLectures() {
        return lectures;
    }

    @Autowired
    public void setCourseService(CourseService courseService) {
        this.courseService = courseService;
    }

    @Autowired
    public void setLectureService(LectureService lectureService) {
        this.lectureService = lectureService;
    }

    public String courseName() {
        try {
            courseName = courseService.getCourseByCode(Long.parseLong(courseCode)).getCourseName();
            return SUCCESS;
        } catch(Exception ex) {
            ex.printStackTrace();
            return ERROR;
        }
    }

    public String lectures() {
        try {
            Course course = courseService.getCourseByCode(Long.parseLong(courseCode));
            courseName = course.getCourseName();
            List<Lecture> lectureList = lectureService.getLectures(Long.parseLong(courseCode));
            for (Lecture l : lectureList) {
                LectureDto lectureDto = new LectureDto();
                lectureDto.setLectureName(l.getName());
                lectureDto.setFile(l.getAttachment());
                lectureDto.setLectureId(l.getLectureId());
                lectures.add(lectureDto);
            }
            return SUCCESS;
        } catch (Exception ex) {
            return ERROR;
        }
    }
}
