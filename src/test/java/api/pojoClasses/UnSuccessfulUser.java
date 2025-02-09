package api.pojoClasses;

public class UnSuccessfulUser {
    private String error;

    public UnSuccessfulUser() {
    }

    public UnSuccessfulUser(String error) {
        this.error = error;
    }

    public String getError() {
        return error;
    }
}
