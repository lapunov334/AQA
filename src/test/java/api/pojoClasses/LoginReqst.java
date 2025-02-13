package api.pojoClasses;

public class LoginReqst {
    private String password;
    private String username;

    public LoginReqst() {
    }

    public LoginReqst(String password, String username) {
        this.password = password;
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }
}
