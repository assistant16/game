package Game.controller;

//
//import Game.entity.Greeting;
//import Game.entity.HelloMessage;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.MediaType;
//import org.springframework.messaging.handler.annotation.MessageMapping;
//import org.springframework.messaging.handler.annotation.SendTo;
//import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.util.HtmlUtils;
//
//import java.security.Principal;
//import java.util.Map;
//
//@RestController
//@RequestMapping("/api/email")
//public class LoginController {
//
//
//
//    @GetMapping(value = "/user")
//    public Principal user(Principal user) {
//
//        return user;
//    }
//
//    @GetMapping(value = "/get")
//    public Principal showEmail(Principal user){
//        OAuth2AuthenticationToken authentication = (OAuth2AuthenticationToken) user ;
//        Map<String,Object> details = authentication.getPrincipal().getAttributes();
////        //String email = String.valueOf(details.get("email"));
//        return user;
//    }
//
//    @MessageMapping("/hello")
//    @SendTo("/topic/greetings")
//    public Greeting greeting(HelloMessage message) throws Exception {
//        Thread.sleep(1000); // simulated delay
//        return new Greeting("Hello, " + HtmlUtils.htmlEscape(message.getName()) + "!");
//    }
//}