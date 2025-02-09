package api.pojoClasses;

public class SuccessfulUser {

    private Integer id;
    private String token;

    public SuccessfulUser() {
    }

    public SuccessfulUser( String token) {
        this.token = token;
    }

    public SuccessfulUser(Integer id, String token) {
        this.id = id;
        this.token = token;
    }

    public Integer getId() {
        return id;
    }

    public String getToken() {
        return token;
    }
}
