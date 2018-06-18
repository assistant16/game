package Game.convertor;

import Game.dto.UserDto;
import Game.entity.User;

public interface UserConvertor {
    UserDto toDto(User user);
    User toUser(UserDto userDto);

}
