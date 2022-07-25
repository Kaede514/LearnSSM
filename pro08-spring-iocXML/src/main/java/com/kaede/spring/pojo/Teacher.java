package com.kaede.spring.pojo;

/**
 * @author kaede
 * @create 2022-07-23 15:04
 */

public class Teacher {
    private Integer teaId;
    private String teaName;

    public Teacher() {
    }

    public Teacher(Integer teaId, String teaName) {
        this.teaId = teaId;
        this.teaName = teaName;
    }

    public Integer getTeaId() {
        return teaId;
    }

    public void setTeaId(Integer teaId) {
        this.teaId = teaId;
    }

    public String getTeaName() {
        return teaName;
    }

    public void setTeaName(String teaName) {
        this.teaName = teaName;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "teaId=" + teaId +
                ", teaName='" + teaName + '\'' +
                '}';
    }
}
