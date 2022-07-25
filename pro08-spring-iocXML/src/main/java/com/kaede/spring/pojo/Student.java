package com.kaede.spring.pojo;

import java.util.Arrays;
import java.util.Map;

/**
 * @author kaede
 * @create 2022-07-23 10:29
 */

public class Student implements Person {
    private Integer stuId;
    private String stuName;
    private Integer stuAge;
    private String stuGender;

    private Double stuScore;

    private Clazz stuClazz;

    private String[] stuHobbies;

    private Map<String,Teacher> teacherMap;

    public Student() {
    }

    public Student(Integer stuId, String stuName, String stuGender, Integer stuAge) {
        this.stuId = stuId;
        this.stuName = stuName;
        this.stuAge = stuAge;
        this.stuGender = stuGender;
    }

    public Student(Integer stuId, String stuName, String stuGender, Double stuScore) {
        this.stuId = stuId;
        this.stuName = stuName;
        this.stuGender = stuGender;
        this.stuScore = stuScore;
    }

    public Integer getStuId() {
        return stuId;
    }

    public void setStuId(Integer stuId) {
        this.stuId = stuId;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public Integer getStuAge() {
        return stuAge;
    }

    public void setStuAge(Integer stuAge) {
        this.stuAge = stuAge;
    }

    public String getStuGender() {
        return stuGender;
    }

    public void setStuGender(String stuGender) {
        this.stuGender = stuGender;
    }

    public Double getstuScore() {
        return stuScore;
    }

    public void setstuScore(Double stuScore) {
        this.stuScore = stuScore;
    }

    public Double getStuScore() {
        return stuScore;
    }

    public void setStuScore(Double stuScore) {
        this.stuScore = stuScore;
    }

    public Clazz getStuClazz() {
        return stuClazz;
    }

    public void setStuClazz(Clazz stuClazz) {
        this.stuClazz = stuClazz;
    }

    public String[] getStuHobbies() {
        return stuHobbies;
    }

    public void setStuHobbies(String[] stuHobbies) {
        this.stuHobbies = stuHobbies;
    }

    public Map<String, Teacher> getTeacherMap() {
        return teacherMap;
    }

    public void setTeacherMap(Map<String, Teacher> teacherMap) {
        this.teacherMap = teacherMap;
    }

    @Override
    public String toString() {
        return "Student{" +
                "stuId=" + stuId +
                ", stuName='" + stuName + '\'' +
                ", stuAge=" + stuAge +
                ", stuGender='" + stuGender + '\'' +
                ", stuScore=" + stuScore +
                ", stuClazz=" + stuClazz +
                ", stuHobbies=" + Arrays.toString(stuHobbies) +
                ", teacherMap=" + teacherMap +
                '}';
    }
}
