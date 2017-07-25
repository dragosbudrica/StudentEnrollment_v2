package com.kepler.rominfo.action;

import com.kepler.rominfo.service.LectureService;
import com.opensymphony.xwork2.ActionSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RemoveAction extends ActionSupport {
    private LectureService lectureService;

    @Autowired
    public void setLectureService(LectureService lectureService) {
        this.lectureService = lectureService;
    }

    private String lectureId;
    private String courseCode;

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public String getLectureId() {
        return lectureId;
    }

    public void setLectureId(String lectureId) {
        this.lectureId = lectureId;
    }

    public String removePdf() {
        try {
            lectureService.removeLectureAttachment(Long.parseLong(lectureId));
            return SUCCESS;
        } catch(Exception ex) {
            ex.printStackTrace();
            return ERROR;
        }
    }
}
