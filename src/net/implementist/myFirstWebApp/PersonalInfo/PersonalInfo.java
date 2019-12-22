package net.implementist.myFirstWebApp.PersonalInfo;

public class PersonalInfo {
    private Double height;
    private Double weight;
    private int blood;
    private int SitupNumber;
    private int PushupNumber;
    private int pullUp;
    private int heartBeat;
    private int age;
    private int gender;

    public int getAge() {
        return age;
    }

    public int getGender() {
        return gender;
    }

    public int getHeartBeat() {
        return heartBeat;
    }

    public int getPullUp() {
        return pullUp;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public void setHeartBeat(int heartBeat) {
        this.heartBeat = heartBeat;
    }

    public void setPullUp(int pullUp) {
        this.pullUp = pullUp;
    }

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
