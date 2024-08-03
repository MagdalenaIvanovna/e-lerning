package pl.learning.Responses;

public class UserRegistrationResponse {
    private boolean registrationSuccessful;
    private String message;

    public UserRegistrationResponse(boolean registrationSuccessful, String message) {
        this.registrationSuccessful = registrationSuccessful;
        this.message = message;
    }

    public boolean isRegistrationSuccessful() {
        return registrationSuccessful;
    }

    public String getMessage() {
        return message;
    }
}
