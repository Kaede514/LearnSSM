package com.kaede.spring.pojo;

import java.util.List;

/**
 * @author kaede
 * @create 2022-07-23 14:07
 */

public class Clazz {
    private Integer clazzId;
    private String clazzName;

    private List<Student> clazzStudents;

    public Clazz() {
    }

    public Clazz(Integer clazzId, String clazzName) {
        this.clazzId = clazzId;
        this.clazzName = clazzName;
    }

    public Integer getClazzId() {
        return clazzId;
    }

    public void setClazzId(Integer clazzId) {
        this.clazzId = clazzId;
    }

    public String getClazzName() {
        return clazzName;
    }

    public void setClazzName(String clazzName) {
        this.clazzName = clazzName;
    }

    public List<Student> getClazzStudents() {
        return clazzStudents;
    }

    public void setClazzStudents(List<Student> clazzStudents) {
        this.clazzStudents = clazzStudents;
    }

    @Override
    public String toString() {
        return "Clazz{" +
                "clazzId=" + clazzId +
                ", clazzName='" + clazzName + '\'' +
                ", clazzStudents=" + clazzStudents +
                '}';
    }
}
