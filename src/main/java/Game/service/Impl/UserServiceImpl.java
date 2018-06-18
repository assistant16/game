package Game.service.Impl;


import Game.entity.User;
import Game.repository.UserRepository;
import Game.service.UserService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository UserRepository;


    @Override
    @Transactional
    public User addUser(User user){
        //User user1 = new User("qwe","qwe","qwe");
        return UserRepository.save(user);
    }

    @Override
    @Transactional
    public List<User> getAllUsers(){
        return UserRepository.findAll();
    }

    @Override
    @Transactional
    public Optional<User> getByIdUser(Long id) {
        return UserRepository.findById(id);
    }

    @Override
    public void deleteByIdUser(Long id){
        UserRepository.deleteById(id);
    }

    @Override
    public void deleteAllUser(){
        UserRepository.deleteAll();
    }


}
