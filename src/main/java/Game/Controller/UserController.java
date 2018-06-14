package Game.Controller;

import Game.DTO.UserDto;

import Game.Entity.User;
import Game.Service.Impl.UserServiceImpl;
import Game.convertor.UserConvertor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.ApiOperation;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/user")
public class UserController {

        @Autowired
        private UserServiceImpl serviceUserImpl;

        private ModelMapper modelMapper;

        ObjectMapper mapper;

        UserDto userDto;

        private UserConvertor userConvertor;

//        @PostMapping(name = "/adding")
//        @ResponseStatus(HttpStatus.CREATED)
//        public UserDto addUser(@RequestBody UserDto userDto) {
//                User user = serviceUserImpl.addUser(userConvertor.toUser(userDto));
//                return userConvertor.toDto(user);
//        }

        @PostMapping(name = "/adding2")
        public void addUser2(@RequestBody User user) {
              serviceUserImpl.addUser(user);
        }

        @ApiOperation(value = "getAllUsers")
        @GetMapping(name = "/viewAll")
        public List<User> getAllUsers(){
               return serviceUserImpl.getAllUsers();
        }

        @GetMapping(value = "userId/{Id}",produces = MediaType.APPLICATION_JSON_VALUE)
        public Optional<User> getByIdUser(@PathVariable("Id") Long id){
                return serviceUserImpl.getByIdUser(id);
        }

        @RequestMapping("/hello")
        public String hello(){
                return "hello :)";
        }


}


