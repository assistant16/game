package Game.Service.Impl;


import Game.Entity.User;
import Game.Repository.UserRepository;
import Game.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private UserRepository UserRepository;

    @Override
    @Transactional
    public User addUser(User user){
        return UserRepository.save(user);
    }

    @Override
    @Transactional
    public List<User> getAllUsers(){
        List<User> users = new ArrayList<>();
            users.addAll(UserRepository.findAll());
        return users;
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
