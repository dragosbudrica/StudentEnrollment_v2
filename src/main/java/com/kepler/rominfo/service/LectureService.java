package com.kepler.rominfo.service;

import com.kepler.rominfo.mappers.LectureMapper;
import com.kepler.rominfo.model.Lecture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * Created by Dragos on 13.06.2017.
 */

@Service
public class LectureService {

    private LectureMapper lectureMapper;

    @Autowired
    public LectureService(LectureMapper lectureMapper) {
        this.lectureMapper = lectureMapper;
    }

    public List<Lecture> getLectures(long courseCode) {
        return lectureMapper.getLectures(courseCode);
    }

  /*  public void uploadFile(UploadedFile file, long lectureId) {
        try {
            if (file != null) {
                lectureMapper.uploadPDF(file., lectureId);
                addSuccessMessage("Upload successfully!");
            }
        } catch (Exception ex) {
            addErrorMessage(ex);
            ex.printStackTrace();
        }
    }

    private void addSuccessMessage(String s) {
        FacesMessage message = new FacesMessage(s);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    private void addErrorMessage(Exception exc) {
        FacesMessage message = new FacesMessage("Error: " + exc.getMessage());
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public Lecture getLectureByNameAndCourseCode(long courseCode, String lectureName) {
            return lectureMapper.getLectureByNameAndCourseCode(courseCode, lectureName);
    }*/
}
