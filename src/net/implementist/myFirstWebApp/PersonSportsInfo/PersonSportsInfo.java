package net.implementist.myFirstWebApp.PersonSportsInfo;

import java.sql.Date;

public class PersonSportsInfo {
    private int SNo;
    private int Id;
    private String Type;
    private Double Calorie;
    private int Duration;
    private Date Time;

    public int getSNo() {
        return SNo;
    }

    public void setSNo(int SNo) {
        this.SNo = SNo;
    }

    public void setId(int id) {
        Id = id;
    }

    public int getId() {
        return Id;
    }

    public Date getTime() {
        return Time;
    }

    public Double getCalorie() {
        return Calorie;
    }

    public int getDuration() {
        return Duration;
    }

    public String getType() {
        return Type;
    }

    public void setCalorie(Double calorie) {
        Calorie = calorie;
    }

    public void setDuration(int duration) {
        Duration = duration;
    }

    public void setTime(Date time) {
        Time = time;
    }

    public void setType(String type) {
        Type = type;
    }
}
