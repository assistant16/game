package Game.convertor.Impl;

import Game.dto.UserDto;
import Game.entity.User;
import Game.convertor.UserConvertor;

public class UserConvertorImpl implements UserConvertor{

    public UserConvertorImpl(){}

    @Override
    public UserDto toDto(User user)
    {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setName(user.getName());
        userDto.setEmail(user.getEmail());
        userDto.setPassword(user.getPassword());
        return userDto;
    }

    @Override
    public User toUser(UserDto userDto){
        User user = new User();
        user.setId(userDto.getId());
        user.setName(userDto.getName());
        user.setPassword(userDto.getPassword());
        user.setEmail(userDto.getEmail());
        return user;
    }
}
