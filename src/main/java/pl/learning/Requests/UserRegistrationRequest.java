package pl.learning.Requests;

public class UserRegistrationRequest {
    private String firstName;
    private String lastName;
    private String email;
    private String login;
    private String password;
    private String passwordConfirmation;
    private String role;

    public UserRegistrationRequest(String firstName, String lastName, String email, String login, String password, String passwordConfirmation, String role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.login = login;
        this.password = password;
        this.passwordConfirmation = passwordConfirmation;
        this.role = role;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getPasswordConfirmation() {
        return passwordConfirmation;
    }

    public String getRole() {
        return role;
    }
}
