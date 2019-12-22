package net.implementist.myFirstWebApp.User;

public class User {
    private String userName;
    private int userId;
    //用户密码
    private String password;

    public String getUserName() {
        return userName;
    }
    public int getUserId(){
        return userId;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public void setUserId(int userId){

        this.userId=userId;
    }
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
