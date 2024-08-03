package pl.learning.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.learning.Mappers.UserMapper;
import pl.learning.Repositories.UserRepository;
import pl.learning.Requests.UserRegistrationRequest;
import pl.learning.Responses.UserRegistrationResponse;
import pl.learning.Utils.ValidationUtils;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserMapper userMapper;
    public UserRegistrationResponse register(UserRegistrationRequest request){

        if (!ValidationUtils.validateEmail(request.getEmail())){
            return new UserRegistrationResponse(false,"invalid email");
        }

        //TODO: do the rest: validate login, password etc.

        //TODO: add user to database
        return new UserRegistrationResponse(true,"Welcome");
    }
}
