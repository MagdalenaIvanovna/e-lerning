package pl.learning.Requests;

public class UserUpdateRequest {
    private String lastName;
    private String email;
    private String oldPassword;
    private String newPassword;

    public UserUpdateRequest(String lastName, String email, String oldPassword, String newPassword) {
        this.lastName = lastName;
        this.email = email;
        this.oldPassword = oldPassword;
        this.newPassword = newPassword;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getOldPassword() {
        return oldPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }
}
