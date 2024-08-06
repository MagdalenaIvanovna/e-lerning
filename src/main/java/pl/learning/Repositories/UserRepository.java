package pl.learning.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.learning.Entities.User;

public interface UserRepository extends JpaRepository<User,Integer> {
    User findByLogin(String login);
}
