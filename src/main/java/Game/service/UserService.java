package Game.service;


import Game.entity.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public interface UserService {
    User addUser(User user);
    List<User> getAllUsers();
    Optional<User> getByIdUser(Long id);
    void deleteByIdUser(Long id);

    void deleteAllUser();
}
