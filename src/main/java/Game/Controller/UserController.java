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


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/user")
public class UserController {

        @Autowired
        private UserServiceImpl serviceUserImpl;

        UserDto userDto;

        private UserConvertor userConvertor;

//        @PostMapping(name = "/adding")
//        @ResponseStatus(HttpStatus.CREATED)
//        public UserDto addUser(@RequestBody UserDto userDto) {
//                User user = serviceUserImpl.addUser(userConvertor.toUser(userDto));
//                return userConvertor.toDto(user);
//        }
        @PostMapping(value = "/adding",produces = MediaType.APPLICATION_JSON_VALUE)
        public void addUser2(@RequestBody User user) {
              serviceUserImpl.addUser(user);
        }

        @PostMapping(value = "/addingU",produces = MediaType.APPLICATION_JSON_VALUE)
        public String addUser(@RequestParam String n,@RequestParam String p,@RequestParam String e ){
                User user = new User(n,p,e);
                serviceUserImpl.addUser(user);
                return "added";
        }


        @ApiOperation(value = "getAllUsers")
        @GetMapping(value = "/viewU",produces = MediaType.APPLICATION_JSON_VALUE)
        public List<User> getAllUsers(){
               return serviceUserImpl.getAllUsers();
        }


//        private static List<User> hardcode = new ArrayList<>();
//        static {
//                hardcode.add(new User( "user11", "user1", "user1"));
//                hardcode.add(new User( "user22", "user2", "user2"));
//                hardcode.add(new User( "user22", "user2", "user2"));
//        }
//
//        @GetMapping(name = "/someUsers")
//        public List<User> getAllUsers2(){
//                return hardcode;
//        }

        @GetMapping(value = "/userId/{Id}",produces = MediaType.APPLICATION_JSON_VALUE)
        public Optional<User> getByIdUser(@PathVariable("Id") Long id){
                return serviceUserImpl.getByIdUser(id);
        }

        @RequestMapping("/hello")
        public String hello(){
                return "hello :)";
        }


}


