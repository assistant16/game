package Game.Controller;

import Game.DTO.UserDto;

import Game.Entity.User;
import Game.Service.Impl.UserServiceImpl;
import Game.convertor.UserConvertor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/user")
public class UserController {

        private UserServiceImpl serviceUserImpl;

        private ModelMapper modelMapper;

        ObjectMapper mapper;

        UserDto userDto;

        private UserConvertor userConvertor;

        @PostMapping(name = "/adding")
        @ResponseStatus(HttpStatus.CREATED)
        public UserDto addUser(@RequestBody UserDto userDto) {
                User user = serviceUserImpl.addUser(userConvertor.toUser(userDto));
                return userConvertor.toDto(user);
        }

        @GetMapping(name = "/viewAll",produces = MediaType.APPLICATION_JSON_VALUE)
        public List<User> getAllUsers(){
               return serviceUserImpl.getAllUsers();
        }

        @GetMapping(value = "userId/{userId}",produces = MediaType.APPLICATION_JSON_VALUE)
        public Optional<User> getByIdUser(@PathVariable("userId") Long id){
                return serviceUserImpl.getByIdUser(id);
        }

        @RequestMapping("/")
        public String hello(){
                return "hello :)";
        }


}


