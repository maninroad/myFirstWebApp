package net.implementist.myFirstWebApp.Step;
import java.sql.Date;
public class Step {
    private int stepNo;
    private int Id;
    private Date date;
    private int stepCount;

    public Date getDate() {
        return date;
    }

    public int getId() {
        return Id;
    }

    public int getStepCount() {
        return stepCount;
    }

    public int getStepNo() {
        return stepNo;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setStepCount(int stepCount) {
        this.stepCount = stepCount;
    }
}
