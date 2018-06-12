package Game.Controller;

import Game.DTO.UserDto;

import Game.Entity.User;
import Game.Service.Impl.UserServiceImpl;
import Game.convertor.UserConvertor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


import java.io.File;

@RestController
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

        @RequestMapping(name = "/view",method = RequestMethod.GET)
        public String getAllUsers(){
               return serviceUserImpl.getAllUsers().toString();
        }

        @RequestMapping("/")
        public String hello(){
                return "hello :)";
        }


}


