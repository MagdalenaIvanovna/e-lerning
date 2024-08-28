package pl.learning.Responses;

public class UserUpdateResponse {
    private boolean success;
    private String message;

    public UserUpdateResponse(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }
}
