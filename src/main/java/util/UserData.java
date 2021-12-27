package util;


public class UserData {
    private String userName;
    private String userPassword;
    private String authPage;

    public UserData(String userName, String userPassword, String authPage) {
        this.userName = userName;
        this.userPassword = userPassword;
        this.authPage = authPage;

    }

    public String getUserName() {
        return this.userName;
    }

    public String getUserPassword() {
        return this.userPassword;
    }

    public String getAuthPage() {
        return this.authPage;
    }
}
