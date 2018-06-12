package Game.Service;


import Game.Entity.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public interface UserService {
    User addUser(User user);
    List<User> getAllUsers();
    void deleteByIdUser(Long id);
    Optional<User> getByIdUser(Long id);
    void deleteAllUser();
}
