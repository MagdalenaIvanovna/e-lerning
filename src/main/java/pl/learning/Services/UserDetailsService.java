package pl.learning.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import pl.learning.Configs.UserDetailsImpl;
import pl.learning.Entities.User;
import pl.learning.Repositories.UserRepository;

@Service
public class UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    public UserDetails getByUserName(String userName){
        User user = userRepository.findByLogin(userName);
        return new UserDetailsImpl(user.getLogin(),user.getPassword(), user.getRole());
    }
}
