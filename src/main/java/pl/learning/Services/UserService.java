package pl.learning.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;
import pl.learning.Entities.User;
import pl.learning.Mappers.UserMapper;
import pl.learning.Repositories.UserRepository;
import pl.learning.Requests.UserLoginRequest;
import pl.learning.Requests.UserRegistrationRequest;
import pl.learning.Responses.UserLoginResponse;
import pl.learning.Responses.UserRegistrationResponse;
import pl.learning.Utils.PasswordUtils;
import pl.learning.Utils.ValidationUtils;

import java.net.Authenticator;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private AuthenticationManager authenticationManager;


    public UserRegistrationResponse register(UserRegistrationRequest request) {

        if (!ValidationUtils.validateEmail(request.getEmail())) {
            return new UserRegistrationResponse(false, "invalid email");
        }
        if (!ValidationUtils.validatePassword(request.getPassword())) {
            return new UserRegistrationResponse(false, "invalid password");
        }
        if (!request.getPassword().equals(request.getPasswordConfirmation())) {
            return new UserRegistrationResponse(false, "passwords do not match");
        }
        User user = userRepository.findByLogin(request.getLogin());
        if (user != null) {
            return new UserRegistrationResponse(false, "login already exist");
        }

        String salt = PasswordUtils.generateSalt();
        String hashPassword = PasswordUtils.hashPassword(request.getPassword(), salt);
        User newUser = userMapper.toEntity(request);
        newUser.setSalt(salt);
        newUser.setPassword(hashPassword);
        userRepository.saveAndFlush(newUser);

        return new UserRegistrationResponse(true, "Welcome");
    }

    public UserLoginResponse login(UserLoginRequest request) {
        //TODO: hash password
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getLogin(), request.getPassword()));
        //TODO: jeżeli sukces to wygenerować token i wysłać do użytkownika
        return null;
    }
}
