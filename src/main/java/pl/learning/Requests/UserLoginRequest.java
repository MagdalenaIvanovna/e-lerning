package pl.learning.Requests;

public class UserLoginRequest {
    private String login;
    private String password;

    public UserLoginRequest(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }
}
