package api.pojoClasses;

public class UserForRegisterAndLogin {
    private String email;
    private String password;

    public UserForRegisterAndLogin() {
    }

    public UserForRegisterAndLogin(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
