package net.implementist.myFirstWebApp.PersonalInfo;

public class PersonalInfo {
    private Double height;
    private Double weight;
    private int blood;
    private int SitupNumber;
    private int PushupNumber;

    public void setHeight(Double height){
        this.height=height;
    }
    public void setWeight(Double weight) {
        this.weight = weight;
    }
    public void setBlood(int blood) {
        this.blood = blood;
    }
    public void setPushupNumber(int pushupNumber) {
        PushupNumber = pushupNumber;
    }
    public void setSitupNumber(int situpNumber) {
        SitupNumber = situpNumber;
    }

    public Double getHeight() {
        return height;
    }

    public Double getWeight() {
        return weight;
    }

    public int getBlood() {
        return blood;
    }

    public int getPushupNumber() {
        return PushupNumber;
    }

    public int getSitupNumber() {
        return SitupNumber;
    }
}
