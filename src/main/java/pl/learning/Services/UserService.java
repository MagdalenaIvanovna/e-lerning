package pl.learning.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import pl.learning.Entities.User;
import pl.learning.Repositories.UserRepository;
import pl.learning.Requests.UserUpdateRequest;
import pl.learning.Responses.UserUpdateResponse;
import pl.learning.Utils.PasswordUtils;
import pl.learning.Utils.ValidationUtils;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public UserUpdateResponse updateLastName(UserUpdateRequest request){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userName = authentication.getName();
        User user = userRepository.findByLogin(userName);
        user.setLastName(request.getLastName());
        userRepository.saveAndFlush(user);
        return new UserUpdateResponse(true, "Last name has been updated");
    }
    public UserUpdateResponse updateEmail (UserUpdateRequest request){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userName = authentication.getName();
        if (!ValidationUtils.validateEmail(request.getEmail())){
            return new UserUpdateResponse(false, "Invalid email");
        }
        User user = userRepository.findByLogin(userName);
        user.setEmailAddress(request.getEmail());
        userRepository.saveAndFlush(user);
        return new UserUpdateResponse(true, "Email address has been updated");
    }
    public UserUpdateResponse updatePassword (UserUpdateRequest request){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userName = authentication.getName();
        if (!ValidationUtils.validatePassword(request.getNewPassword())) {
            return new UserUpdateResponse(false, "Incorrect password");
        }
        User user = userRepository.findByLogin(userName);
        String salt = user.getSalt();
        String hashedPassword = user.getPassword();
        String oldhashedPassword = PasswordUtils.hashPassword(request.getOldPassword(),salt);
        if(!hashedPassword.equals(oldhashedPassword)){
            return new UserUpdateResponse(false, "Incorrect old password");
        }
        user.setPassword(hashedPassword);
        userRepository.saveAndFlush(user);
        return new UserUpdateResponse(true, "Password has been updated");
    }
}
