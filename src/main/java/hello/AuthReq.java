package hello;

public class AuthReq {
    private String user;
    private String password;

    public AuthReq(){}

    public AuthReq(String user, String password) {
        this.user = user;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String username) {
        this.user = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}