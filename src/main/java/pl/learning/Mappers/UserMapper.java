package pl.learning.Mappers;

import org.springframework.stereotype.Component;
import pl.learning.Entities.User;
import pl.learning.Requests.UserRegistrationRequest;

@Component
public class UserMapper {
    public User toEntity(UserRegistrationRequest request) {
        User user = new User();
        user.setEmailAddress(request.getEmail());
        user.setLogin(request.getLogin());
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        return user;
    }
}
