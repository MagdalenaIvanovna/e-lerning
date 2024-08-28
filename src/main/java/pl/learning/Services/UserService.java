package pl.learning.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import pl.learning.Entities.User;
import pl.learning.Repositories.UserRepository;
import pl.learning.Requests.UserUpdateRequest;
import pl.learning.Responses.UserUpdateResponse;

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
}
