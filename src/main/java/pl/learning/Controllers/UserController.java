package pl.learning.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.learning.Requests.UserLoginRequest;
import pl.learning.Requests.UserRegistrationRequest;
import pl.learning.Responses.UserLoginResponse;
import pl.learning.Responses.UserRegistrationResponse;
import pl.learning.Services.UserService;

@RestController
@RequestMapping(value = "/api/v1/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping(value = "/register")
    public ResponseEntity<UserRegistrationResponse> register(@RequestBody UserRegistrationRequest request) {
        return ResponseEntity.ok(userService.register(request));
    }

    @PostMapping(value = "/login")
    public ResponseEntity<UserLoginResponse> login(@RequestBody UserLoginRequest request) {
        return ResponseEntity.ok(userService.login(request));
    }
}
