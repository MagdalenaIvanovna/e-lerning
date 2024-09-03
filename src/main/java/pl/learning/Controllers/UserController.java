package pl.learning.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.learning.Requests.UserLoginRequest;
import pl.learning.Requests.UserRegistrationRequest;
import pl.learning.Requests.UserUpdateRequest;
import pl.learning.Responses.UserLoginResponse;
import pl.learning.Responses.UserRegistrationResponse;
import pl.learning.Responses.UserUpdateResponse;
import pl.learning.Services.AuthorisationService;
import pl.learning.Services.UserService;

@RestController
@RequestMapping(value = "/api/v1/user")
public class UserController {
    @Autowired
    private AuthorisationService authorisationService;
    @Autowired
    private UserService userService;

    @PostMapping(value = "/register")
    public ResponseEntity<UserRegistrationResponse> register(@RequestBody UserRegistrationRequest request) {
        return ResponseEntity.ok(authorisationService.register(request));
    }

    @PostMapping(value = "/login")
    public ResponseEntity<UserLoginResponse> login(@RequestBody UserLoginRequest request) {
        return ResponseEntity.ok(authorisationService.login(request));
    }
    @PutMapping(value = "/updateLastName")
    public ResponseEntity<UserUpdateResponse> updateLastName(@RequestBody UserUpdateRequest request){
        return ResponseEntity.ok(userService.updateLastName(request));
    }
    @PutMapping(value = "/updateEmail")
    public ResponseEntity<UserUpdateResponse> updateEmail(@RequestBody UserUpdateRequest request){
        return ResponseEntity.ok(userService.updateEmail(request));
    }
    @PutMapping(value = "/updatePassword")
    public ResponseEntity<UserUpdateResponse> updatePassword(@RequestBody UserUpdateRequest request) {
        return ResponseEntity.ok(userService.updatePassword(request));
    }
}
