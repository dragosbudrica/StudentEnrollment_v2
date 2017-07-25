package com.kepler.rominfo.action;

import com.kepler.rominfo.model.Lecture;
import com.kepler.rominfo.service.LectureService;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileInputStream;

/**
 * Created by Dragos on 14.07.2017.
 */

@Component
public class UploadAction extends ActionSupport {

    private LectureService lectureService;

    private String courseCode;

    @Autowired
    public void setLectureService(LectureService lectureService) {
        this.lectureService = lectureService;
    }

    private File fileUpload;
    private String fileUploadContentType;
    private String fileUploadFileName;
    private String lectureId;

    public String getLectureId() {
        return lectureId;
    }

    public void setLectureId(String lectureId) {
        this.lectureId = lectureId;
    }

    public String getFileUploadContentType() {
        return fileUploadContentType;
    }

    public void setFileUploadContentType(String fileUploadContentType) {
        this.fileUploadContentType = fileUploadContentType;
    }

    public String getFileUploadFileName() {
        return fileUploadFileName;
    }

    public void setFileUploadFileName(String fileUploadFileName) {
        this.fileUploadFileName = fileUploadFileName;
    }

    public File getFileUpload() {
        return fileUpload;
    }

    public void setFileUpload(File fileUpload) {
        this.fileUpload = fileUpload;
    }

    public String uploadLecture() {
        try {
            byte[] file = IOUtils.toByteArray(new FileInputStream(fileUpload));
            lectureService.uploadFile(file, Long.parseLong(lectureId));
            return SUCCESS;
        }catch(Exception ex) {
            ex.printStackTrace();
            return ERROR;
        }
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }
}
