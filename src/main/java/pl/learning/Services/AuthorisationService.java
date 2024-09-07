package pl.learning.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.learning.Data.UserRole;
import pl.learning.Entities.User;
import pl.learning.Mappers.UserMapper;
import pl.learning.Repositories.UserRepository;
import pl.learning.Requests.UserLoginRequest;
import pl.learning.Requests.UserRegistrationRequest;
import pl.learning.Responses.UserLoginResponse;
import pl.learning.Responses.UserRegistrationResponse;
import pl.learning.Utils.JWTUtils;
import pl.learning.Utils.PasswordUtils;
import pl.learning.Utils.ValidationUtils;

import java.util.Arrays;

@Service
public class AuthorisationService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserMapper userMapper;


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
        UserRole[] roles = UserRole.values();
        boolean isSuccess = false;
        for (UserRole role : roles){
            if (role.toString().equals(request.getRole().toUpperCase())){
                isSuccess = true;
                break;
            }
        }
        if (!isSuccess) {
            return new UserRegistrationResponse(false, "Invalid user role");
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
        User user = userRepository.findByLogin(request.getLogin());
        if (user == null){
            return new UserLoginResponse(false,"");
        }
        String salt = user.getSalt();
        String password = request.getPassword();
        String hashPassword = PasswordUtils.hashPassword(password,salt);
        if (!user.getPassword().equals(hashPassword)){
            return new UserLoginResponse(false, "");
        }
        String jwt = JWTUtils.generateToken(request.getLogin());
        return new UserLoginResponse(true,jwt);
    }

}
