package pl.learning.Mappers;

import org.springframework.stereotype.Component;
import pl.learning.Entities.User;
import pl.learning.Requests.UserRegistrationRequest;

@Component
public class UserMapper {
public User toEntity(UserRegistrationRequest request){
    return new User(
            request.getFirstName(),
            request.getLastName(),
            request.getEmail(),
            request.getLogin(),
            request.getPassword()
            );
}
}
