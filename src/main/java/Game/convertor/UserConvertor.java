package Game.convertor;

import Game.DTO.UserDto;
import Game.Entity.User;

public interface UserConvertor {
    UserDto toDto(User user);
    User toUser(UserDto userDto);

}
