package com.kepler.rominfo.model;

/**
 * Created by Dragos on 29.06.2017.
 */
public class Professor {
    private long professorId;
    private String entitling;
    private String department;

    public long getProfessorId() {
        return professorId;
    }

    public void setProfessorId(long professorId) {
        this.professorId = professorId;
    }

    public String getEntitling() {
        return entitling;
    }

    public void setEntitling(String entitling) {
        this.entitling = entitling;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

}
