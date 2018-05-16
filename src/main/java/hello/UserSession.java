package hello;

public class UserSession {
    private final String jsessionID;

    public UserSession(String jsessionID) {
        this.jsessionID = jsessionID;
    }

    @Override
    public String toString() {
        return "{jsessionID='" + jsessionID + '}';
    }
}
