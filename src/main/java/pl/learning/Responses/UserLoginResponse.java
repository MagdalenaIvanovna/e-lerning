package pl.learning.Responses;

public class UserLoginResponse {
    private boolean loginSuccessful;
    private String token;

    public UserLoginResponse(boolean loginSuccessful, String token) {
        this.loginSuccessful = loginSuccessful;
        this.token = token;
    }

    public boolean isLoginSuccessful() {
        return loginSuccessful;
    }

    public String getToken() {
        return token;
    }
}
